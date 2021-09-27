package ua.com.alevel.entity;

public class Solution{

    private int problemId;
    private int finalCost;

    public Solution(){
    }

    public Solution(int problemId, int finalCost){
        this.problemId = problemId;
        this.finalCost = finalCost;
    }

    public int getProblemId(){
        return problemId;
    }

    public void setProblemId(int problemId){
        this.problemId = problemId;
    }

    public int getFinalCost(){
        return finalCost;
    }

    public void setFinalCost(int finalCost){
        this.finalCost = finalCost;
    }
}
