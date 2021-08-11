package com.nishant.snakandladder;

public interface LadderService {


    public void addLadder(Box start,Box en);

    public boolean checkIfLadderExists(Box box);

    public Box reachTop(Box initialBox);
}
