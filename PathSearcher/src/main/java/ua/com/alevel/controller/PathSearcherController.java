package ua.com.alevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.cmd.PSMessages;

import java.io.*;
import java.util.*;

public class PathSearcherController{

    //todo private static final String PATH_TO_INPUT = "files/input.txt";
    private static final String PATH_TO_INPUT = "module2/files/input.txt";
    //todo private static final String PATH_TO_OUTPUT = "files/output.txt";
    private static final String PATH_TO_OUTPUT = "module2/files/output.txt";
    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");

    private int[][] adjacentMatrix;

    public void findCheapestPath(){
        System.out.println("Looking for cheapest path for cities from 'input.txt'...");
        Map<String, Integer> cities = new TreeMap<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_INPUT));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_TO_OUTPUT))){
            while(bufferedReader.ready()){
                int numOfCities = Integer.parseInt(bufferedReader.readLine());
                adjacentMatrix = new int[numOfCities][numOfCities];
                for(int i = 0; i < numOfCities; i++){
                    String name = bufferedReader.readLine();
                    cities.put(name, i);
                    int numOfNeghbours = Integer.parseInt(bufferedReader.readLine());
                    for(int k = 0; k < numOfNeghbours; k++){
                        String path = bufferedReader.readLine();
                        int cityOfDestination = convertToArrayId(Integer.parseInt(path.split(" ")[0]));
                        int cost = Integer.parseInt(path.split(" ")[1]);
                        adjacentMatrix[i][cityOfDestination] = cost;
                    }
                }
                showAdjacentMatrix(adjacentMatrix);
                int numOfPathesToFind = Integer.parseInt(bufferedReader.readLine());
                for(int j = 0; j < numOfPathesToFind; j++){
                    String path = bufferedReader.readLine();
                    String cityOfDeparture = path.split(PSMessages.SPACE)[PSMessages.CITY_OF_DEPARTURE];
                    String cityOfDestination = path.split(PSMessages.SPACE)[PSMessages.CITY_OF_DESTINATION];
                    writeInFile(findCheapestWayBetween(cityOfDeparture, cityOfDestination, cities), bufferedWriter);
                }
                bufferedWriter.flush();
            }
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private void writeInFile(String cheapestWayBetween, BufferedWriter writer){
        try{
            writer.write(cheapestWayBetween);
            writer.write(System.lineSeparator());
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private int convertToArrayId(int id){
        return id - PSMessages.OFFSET_CUZ_ARRAY_STARTS_WITH_ZERO;
    }

    private void showAdjacentMatrix(int[][] adjacentMatrix){
        for(int[] anAdjacentMatrix : adjacentMatrix){
            System.out.println(Arrays.toString(anAdjacentMatrix));
        }
    }

    private String findCheapestWayBetween(String departure, String destination, Map<String, Integer> cities){
        if(Objects.equals(cities.get(departure), cities.get(destination))){
            return String.valueOf(0);
        }else{
            return findWay(departure, destination, cities);
        }
    }

    private String findWay(String departure, String destination, Map<String, Integer> cities){
        int departureId;
        int destinationId;
        if(cities.get(departure) > cities.get(destination)){
            departureId = cities.get(destination);
            destinationId = cities.get(departure);
        }else{
            departureId = cities.get(departure);
            destinationId = cities.get(destination);
        }
        int minCost = PSMessages.MAX_PATH_COST;
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
        return String.valueOf(minCost);
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