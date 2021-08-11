package com.nishant.snakandladder;

import java.util.Set;

public interface PlayerService {



    public void addPlayer(Player player);

    public Set<Player> getAllPlayers();

    public void move(Player player,Box destinaton);

    public Box currentState(Player player);
}
