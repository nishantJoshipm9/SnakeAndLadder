package com.nishant.snakandladder;

import java.util.HashMap;
import java.util.Map;

public class SnakeServiceImplementation implements SnakeService{


    private Map<Box,Box> snakes=new HashMap<>();

    public void addSnake(Box start,Box end) {
         snakes.put(start,end);
    }


    @Override
    public boolean checkIfSnakeExist(Box box) {

        return snakes.containsKey(box);
    }

    @Override
    public Box reachBottom(Box start) {
        return snakes.getOrDefault(start,start);
    }
}
