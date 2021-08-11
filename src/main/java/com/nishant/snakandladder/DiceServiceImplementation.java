package com.nishant.snakandladder;

import java.util.Random;

public class DiceServiceImplementation implements DiceService{


    private Random random=new Random();

    @Override
    public Integer generateRandomNumber() {
        return (random.nextInt(6)+1);
    }

    @Override
    public Integer generateRandomNumberAgain(int initialDiceNumber) {
        return initialDiceNumber+(random.nextInt(6)+1);
    }
}
