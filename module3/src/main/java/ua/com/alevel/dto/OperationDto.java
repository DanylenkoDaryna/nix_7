package ua.com.alevel.dto;

public class OperationDto{

    private String operationId;
    private String fullUserName;
    private String countId;
    private String dateTime;
    private String money;
    private String categoryId;
    private String categoryType;
    private String purpose;

    public OperationDto(){
    }

    @Override
    public String toString(){
        return "OperationDto{" +
                "operationId='" + operationId + '\'' +
                ", fullUserName='" + fullUserName + '\'' +
                ", countId='" + countId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", money='" + money + '\'' +
                ", categoryid='" + categoryId + '\'' +
                ", categoryType='" + categoryType + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }

    public String getOperationId(){
        return operationId;
    }

    public void setOperationId(String operationId){
        this.operationId = operationId;
    }

    public String getFullUserName(){
        return fullUserName;
    }

    public void setFullUserName(String fullUserName){
        this.fullUserName = fullUserName;
    }

    public String getCountId(){
        return countId;
    }

    public void setCountId(String countId){
        this.countId = countId;
    }

    public String getDateTime(){
        return dateTime;
    }

    public void setDateTime(String dateTime){
        this.dateTime = dateTime;
    }

    public String getMoney(){
        return money;
    }

    public void setMoney(String money){
        this.money = money;
    }

    public String getCategoryId(){
        return categoryId;
    }

    public void setCategoryId(String categoryId){
        this.categoryId = categoryId;
    }

    public String getCategoryType(){
        return categoryType;
    }

    public void setCategoryType(String categoryType){
        this.categoryType = categoryType;
    }

    public String getPurpose(){
        return purpose;
    }

    public void setPurpose(String purpose){
        this.purpose = purpose;
    }
}
