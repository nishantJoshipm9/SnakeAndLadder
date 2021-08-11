package com.nishant.snakandladder;

public interface SnakeService {


    public void addSnake(Box start,Box end);

    public boolean checkIfSnakeExist(Box box);

    public Box reachBottom(Box start);
}
