package ua.com.alevel.service;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.controller.FinanceManagerController;
import ua.com.alevel.dto.OperationDto;
import ua.com.alevel.dto.UserDto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class JdbcService{

    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateService.class);
    private FinanceManagerController controller;
    private FinanceServiceJdbc financeService;

    public JdbcService(FinanceManagerController fController){
        controller = fController;
        financeService = new FinanceServiceJdbc();
    }

    public void exportInfo(String userEmail, SessionFactory sessionFactory){
        try(Session session = sessionFactory.openSession()){
            UserDto userDto = financeService.findUser(userEmail, session);
            System.out.println(userDto.toString());
            int countId = controller.chooseCount(userDto);
            Instant start = controller.chooseStartDate();
            Instant end = controller.chooseEndDate();
            List<OperationDto> operations = financeService.getOperations(countId, start, end, session);
            if(operations.isEmpty()){
                LOGGER.info("There is no operations for this count of this user in this period..");
                System.out.println("There is no operations for this count of this user in this period..");
            }else{
                addInfoToOperations(userDto, operations);
                writeToCsv(operations);

            }
        }catch(IOException e){
            LOGGER.error("Troubles with writing operations in .csv file", e);
        }
    }

    private void addInfoToOperations(UserDto userDto, List<OperationDto> operations){
        String fullName = userDto.getFirstName() + " " + userDto.getLastName();
        for(OperationDto operationDto : operations){
            operationDto.setFullUserName(fullName);
        }
    }

    private void writeToCsv(List<OperationDto> operations) throws IOException{
        String pathToCsv = "module3/" + controller.enterFileName();
        FileUtils.touch(new File(pathToCsv));
        try(FileWriter writer = new FileWriter(pathToCsv)){
            ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
            mappingStrategy.setType(OperationDto.class);
            String[] columns = {"operationId", "fullUserName", "countId", "dateTime", "money",
                    "categoryId", "categoryType", "purpose"};
            mappingStrategy.setColumnMapping(columns);
            StatefulBeanToCsv beanWriter = new StatefulBeanToCsvBuilder(writer)
                    .withMappingStrategy(mappingStrategy).build();
            writer.append("operationId,fullUserName,countId,dateTime,money,categoryId,categoryType,purpose\n");
            beanWriter.write(operations);
        }catch(CsvDataTypeMismatchException e){
            LOGGER.error("writeToCsv", e);
        }catch(CsvRequiredFieldEmptyException e){
            LOGGER.error("writeToCsv", e);
        }
    }
}