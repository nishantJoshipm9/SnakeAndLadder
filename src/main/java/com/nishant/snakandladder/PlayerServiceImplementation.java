package com.nishant.snakandladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class PlayerServiceImplementation implements PlayerService{

    private Map<Player,Box> players=new HashMap<>();
    private AtomicInteger totalPlayers=new AtomicInteger(0);

    @Override
    public Set<Player> getAllPlayers(){
       return players.keySet();
    }

    @Override
    public void addPlayer(Player player) {
        player.setId(totalPlayers.incrementAndGet());
        players.put(player,BoardServiceImplementation.START);
    }

    @Override
    public void move(Player player, Box destination) {
        int nextVal=(players.get(player).getVal()+destination.getVal());
        if(nextVal<=BoardServiceImplementation.END.getVal())
            players.put(player,new Box(nextVal));
    }

    @Override
    public Box currentState(Player player) {
       return players.get(player);
    }

}
