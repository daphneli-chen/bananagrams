package edu.brown.cs.dlichen.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private List<Tile> tiles = new ArrayList<>();
    private Set<Tile> placed = new HashSet<>();

    public void addTile(Tile t) {
        tiles.add(t);
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> t) {
        tiles = t;
    }

    public boolean canPeel() {
        return (placed.size() == tiles.size());
    }

    public void placeTile(Tile t, Tile[] neighbors) {
        t.setNeighbors(neighbors);
    }

}
