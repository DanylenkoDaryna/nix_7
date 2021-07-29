package ua.com.alevel.service;

import ua.com.alevel.data.Figure;

public interface FigureService{

    void moveTo(String position);
    boolean checkAbilityToMove(Figure figure, String toPosition);


}
