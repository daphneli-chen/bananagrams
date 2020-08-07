package edu.brown.cs.dlichen.game;

public class Tile {
    private Character c;
    private Tile[] neighbors = {null, null, null, null}; //left, up, down, right
    int id;

    public Tile(Character ch, int i) {
        c = ch;
        id = i;
    }

    public void setNeighbors(Tile[] neighbors) {
        this.neighbors = neighbors;
    }

    public Tile[] getNeighbors() {
        return neighbors;
    }
}
