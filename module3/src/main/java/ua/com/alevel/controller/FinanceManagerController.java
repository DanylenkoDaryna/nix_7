package ua.com.alevel.controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dto.UserDto;
import ua.com.alevel.entity.*;
import ua.com.alevel.exceptions.WrongInputException;
import ua.com.alevel.service.HibernateService;
import ua.com.alevel.service.JdbcService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class FinanceManagerController{
    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceManagerController.class);
    private JdbcService jdbcService;
    private HibernateService hibernateService;
    private Configuration appConfiguration;

    public FinanceManagerController(String dbUser, String dbPass){
        jdbcService = new JdbcService(this);
        hibernateService = new HibernateService(this);
        appConfiguration = new Configuration();
        appConfiguration.setProperty("hibernate.connection.username", dbUser);
        appConfiguration.setProperty("hibernate.connection.password", dbPass);
        appConfiguration.configure();
    }

    public void startApp(String userEmail){
        try(SessionFactory sessionFactory = appConfiguration.buildSessionFactory()){
            showMenu();
            String input = getUsersPreEditedCommand();
            switch(input){
                case "1":
                    LOGGER.info("User {} chose to add new operation", userEmail);
                    hibernateService.addOperation(userEmail, sessionFactory);
                    break;
                case "2":
                    LOGGER.info("User {} chose to export info about operations in .csv", userEmail);
                    jdbcService.exportInfo(userEmail, sessionFactory);
                    break;
                case "0":
                    LOGGER.info("User {} chose to exit", userEmail);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect input! Please, try again...");
                    LOGGER.warn("User {} sent incorrect command", userEmail);
                    startApp(userEmail);
            }
        }
    }

    private void showMenu(){
        System.out.println("Choose an option:");
        System.out.println("1 - to add new operation");
        System.out.println("2 - to export account statements in csv");
        System.out.println("0 - exit");
    }

    public Operation addNewOperation(Count count, List<OperationCategory> categories){
        Operation operation = new Operation();
        if(categories.isEmpty()){
            LOGGER.info("There is no operation categories yet. User need to create some..");
            setNewOperationCategory(operation);
        }else{
            setOperationCategory(operation, categories);
        }
        setOperationSum(operation);
        operation.setDateTime(Instant.now());
        count.addOperation(operation);
        return operation;
    }

    private void setOperationCategory(Operation operation, List<OperationCategory> categories){
        System.out.println("Choose category of operation:");
        int i = 1;
        for(OperationCategory category : categories){
            String categoryType = category.getClass() == IncomeCategory.class ?"income" :"expense";
            System.out.printf("%d - %d category, %s, %s %n",
                    i, category.getId(), categoryType, category.getPurpose());
            i++;
        }
        System.out.println("0 - create new category");
        int input = Integer.parseInt(getUsersPreEditedCommand());
        if(input == 0){
            LOGGER.info("User chose to create new category type..");
            setNewOperationCategory(operation);
        }else{
            LOGGER.info("User chose to use existing category type {}", input);
            operation.setCategory(categories.get(input - 1));
        }
    }

    private void showCategoryMenu(){
        System.out.println("Choose category of operation:");
        System.out.println("1 - income");
        System.out.println("2 - expense");
    }

    private void setNewOperationCategory(Operation operation){
        showCategoryMenu();
        String input = getUsersPreEditedCommand();
        OperationCategory category = new OperationCategory();
        switch(input){
            case "1":
                LOGGER.info("User chose income category");
                category = new IncomeCategory();
                break;
            case "2":
                LOGGER.info("User chose expence category");
                category = new ExpenseCategory();
                break;
            default:
                System.out.println("Incorrect category! Please, try again...");
                LOGGER.warn("User chose incorrect category..");
                setNewOperationCategory(operation);
        }
        System.out.println("Enter the purpose/goal of operation(payment, shopping, theater, ets.):");
        category.setPurpose(getUsersPreEditedInput());
        LOGGER.info("Users purpose for new operation is {}", category.getPurpose());
        operation.setCategory(category);
    }

    private void setOperationSum(Operation operation){
        System.out.println("Enter an amount of gryvna you gained or lost:");
        System.out.println("* for income is format 23.40, 45.99, 280.00, 100000.00");
        System.out.println("* for expense is format -23.40 -45.99, -280.00, -100000.00");
        String sum = getUsersPreEditedInput();
        if(isSumMatchesRules(sum, operation)){
            String[] gryvnaKopiyka = sum.split("\\.");
            int gryvny = Integer.parseInt(gryvnaKopiyka[0]);
            long kopiyky = Long.parseLong(gryvnaKopiyka[1]);
            long money = gryvny * 100 + kopiyky;
            if(money == 0){
                LOGGER.error("Amount of money can`t be 0");
                setOperationSum(operation);
            }
            LOGGER.info("Users amount of money in operation is {} (translated in kopeck)", money);
            operation.setMoney(money);
        }else setOperationSum(operation);
    }

    private boolean isSumMatchesRules(String moneyAmount, Operation operation){
        if(moneyAmount.matches("^(-)?[0-9]+.[0-9]+$")){
            if(moneyAmount.contains("-") & operation.getCategory().getClass().equals(IncomeCategory.class)){
                LOGGER.error("Income can`t be negative");
                return false;
            }else if(operation.getCategory().getClass().equals(ExpenseCategory.class) & !moneyAmount.contains("-")){
                LOGGER.error("Expense can`t be positive");
                return false;
            }else{
                return true;
            }
        }
        return false;
    }

    public int chooseCount(UserDto userDto){
        int countId = -1;
        if(userDto.getCountIds().size() > 1){
            System.out.println("Choose your count (input number of your count):");
            for(int i = 0; i < userDto.getCountIds().size(); i++){
                System.out.printf("\t№%d count %n", userDto.getCountIds().get(i));
            }
            try{
                countId = makeChoice(userDto.getCountIds());
                LOGGER.info("User chose count {}", countId);
            }catch(WrongInputException e){
                chooseCount(userDto);
                LOGGER.error("User made a mistake!", e);
            }
        }else{
            LOGGER.info("Users default count is {}", userDto.getCountIds().get(0));
            countId = userDto.getCountIds().get(0);
        }
        return countId;
    }

    private int makeChoice(List<Integer> countsIds){
        String usersChoice = getUsersPreEditedInput();
        if(usersChoice.matches("\\d+")){
            int choice = Integer.parseInt(usersChoice);
            for(Integer id : countsIds){
                if(choice == id){
                    return choice;
                }
            }
            throw new WrongInputException("No such count. Please, try again!");
        }else{
            throw new WrongInputException("Count id is a number. Please, try again!");
        }
    }

    private static BufferedReader getReader(){
        BufferedReader mainReader = null;
        try{
            mainReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        }catch(UnsupportedEncodingException e){
            LOGGER.error("Problem in main conroller", e);
        }
        return mainReader;
    }

    private static String getUsersPreEditedCommand(){
        return getUsersPreEditedInput().toLowerCase().replaceAll(" ", "");
    }

    private static String getUsersPreEditedInput(){
        try{
            return getReader().readLine().trim();
        }catch(NullPointerException e){
            LOGGER.error("method getReader() returned null", e);
            return getUsersPreEditedCommand();
        }catch(IOException e){
            LOGGER.error("Can`t read from input", e);
            return getUsersPreEditedInput();
        }
    }

    public Instant chooseStartDate(){
        try{
            System.out.println("Please, enter start date in ISO_LOCAL_DATE_TIME format: '2021-10-17T17:44:06.052'");
            String startDate = getUsersPreEditedInput();
            LOGGER.info("User wants to get all operations from date {} ",
                    LocalDateTime.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            return LocalDateTime.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME).toInstant(ZoneOffset.UTC);
        }catch(DateTimeParseException e){
            LOGGER.error("Wrong start date input from user", e);
            System.out.println("Wrong input! Please, try again..");
            return chooseStartDate();
        }
    }

    public Instant chooseEndDate(){
        try{
            System.out.println("Please, enter end date in ISO_LOCAL_DATE_TIME format: '2021-10-17T17:44:06.052'");
            String endDate = getUsersPreEditedInput();
            LOGGER.info("User wants to get all operations to date {} ",
                    LocalDateTime.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            return LocalDateTime.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME).toInstant(ZoneOffset.UTC);
        }catch(DateTimeParseException e){
            LOGGER.error("Wrong end date input from user", e);
            System.out.println("Wrong input! Please, try again..");
            return chooseEndDate();
        }
    }

    public String enterFileName(){
        System.out.println("Please, enter name of csv file in format 'operations.csv'");
        String input = getUsersPreEditedInput();
        if(input.matches("^.+\\.csv$")){
            LOGGER.info("User chose to name .csv file as {}", input);
            return input;
        }else{
            System.out.println("Wrong input! Please, try again..");
            LOGGER.warn("User chose name that doesn`t fit to format..");
            return enterFileName();
        }
    }
}