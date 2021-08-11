package com.nishant.snakandladder;

import java.util.HashMap;
import java.util.Map;

public class LadderServiceImplementation implements LadderService{

    private Map<Box,Box> ladder=new HashMap<>();

    @Override
    public void addLadder(Box start,Box end){
         ladder.put(start,end);
    }

    @Override
    public boolean checkIfLadderExists(Box box) {

        return ladder.containsKey(box);
    }

    @Override
    public Box reachTop(Box initialBox) {
        return ladder.getOrDefault(initialBox,initialBox);
    }
}
