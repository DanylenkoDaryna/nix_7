package ua.com.alevel.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.cmd.Messages10;
import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.entity.Location;
import ua.com.alevel.entity.Problem;
import ua.com.alevel.entity.Route;
import ua.com.alevel.entity.Solution;
import ua.com.alevel.service.LocationService;
import ua.com.alevel.service.ProblemService;
import ua.com.alevel.service.RouteService;
import ua.com.alevel.service.SolutionService;

import java.util.*;

public class App10Controller{

    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");
    private static RouteService routeService = ObjectFactory.getInstance().getImplClass(RouteService.class);
    private static LocationService locationService = ObjectFactory.getInstance().getImplClass(LocationService.class);
    private static ProblemService problemService = ObjectFactory.getInstance().getImplClass(ProblemService.class);
    private static SolutionService solutionService = ObjectFactory.getInstance().getImplClass(SolutionService.class);

    private int[][] adjacentMatrix;

    public void startApp(){
        makeMatrix();
    }

    private void makeMatrix(){
        Map<Integer, Integer> cities = new TreeMap<>();
        List<Location> locations = locationService.getAll();
        for(int i = 0; i < locations.size(); i++){
            cities.put(locations.get(i).getId(), convertToArrayId(locations.get(i).getId()));
        }
        if(locations.isEmpty()){
            System.out.println("we don`t have any locations!!");
            LOGGER_ERR.error("we don`t have any locations!!");
        }else{
            adjacentMatrix = new int[locations.size()][locations.size()];
            List<Route> routes = routeService.getAllRoutes();
            for(int i = 0; i < routes.size(); i++){
                int rowElem = convertToArrayId(routes.get(i).getFromId());
                int columnElem = convertToArrayId(routes.get(i).getToId());
                adjacentMatrix[rowElem][columnElem] = routes.get(i).getCost();
            }
            showAdjacentMatrix();
            List<Problem> problems = problemService.getAll();
            if(!problems.isEmpty()){
                List<Solution> solutions = new ArrayList<>();
                for(Problem tempProblem : problems){
                    int cheapestCost = findCheapestWayBetween(tempProblem.getFromId(), tempProblem.getToId(), cities);
                    if(cheapestCost > Messages10.MAX_PATH_COST){
                        LOGGER_ERR.error("The way can not be greater than " + Messages10.MAX_PATH_COST);
                    }else{
                        solutions.add(new Solution(tempProblem.getId(), cheapestCost));
                    }
                }
                solutionService.addAll(solutions);
            }else{
                System.out.println("There are no any problems!!");
            }
        }
    }

    private int convertToArrayId(int id){
        return id - Messages10.OFFSET_CUZ_ARRAY_STARTS_WITH_ZERO;
    }

    private void showAdjacentMatrix(){
        for(int[] AdjacentRow : adjacentMatrix){
            System.out.println(Arrays.toString(AdjacentRow));
        }
    }

    private int findCheapestWayBetween(int departure, int destination, Map<Integer, Integer> cities){
        if(Objects.equals(cities.get(departure), cities.get(destination))){
            return 0;
        }else{
            return findWay(departure, destination, cities);
        }
    }

    private int findWay(int departure, int destination, Map<Integer, Integer> cities){
        int departureId;
        int destinationId;
        if(cities.get(departure) > cities.get(destination)){
            departureId = cities.get(destination);
            destinationId = cities.get(departure);
        }else{
            departureId = cities.get(departure);
            destinationId = cities.get(destination);
        }
        int minCost = Messages10.MAX_PATH_COST;
        for(int j = 0; j < adjacentMatrix.length; j++){
            int countIterationCost = 0;
            if(adjacentMatrix[departureId][j] != 0){
                if(j == destinationId){
                    countIterationCost = countIterationCost + adjacentMatrix[departureId][j];
                    minCost = checkCost(countIterationCost, minCost);
                    break;
                }else{
                    countIterationCost = countIterationCost + adjacentMatrix[departureId][j];
                    countIterationCost = getAnotherWay(j, destinationId, adjacentMatrix[j], countIterationCost);
                    minCost = checkCost(countIterationCost, minCost);
                }
            }
        }
        return minCost;
    }

    private int checkCost(int countIterationCost, int minCost){
        if(countIterationCost < minCost){
            return countIterationCost;
        }else return minCost;
    }

    private int getAnotherWay(int departureId, int destinationId, int[] adjacent, int countIterationCost){
        for(int k = departureId; k < adjacent.length; k++){
            if(adjacent[k] != 0 && k != departureId){
                if(k == destinationId){
                    countIterationCost = countIterationCost + adjacent[k];
                    return countIterationCost;
                }else{
                    countIterationCost = countIterationCost + adjacent[k];
                    return getAnotherWay(k, destinationId, adjacentMatrix[k], countIterationCost);
                }
            }
        }
        return countIterationCost;
    }
}
