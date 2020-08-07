package edu.brown.cs.dlichen.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Bunch {
    private List<Tile> tiles;

    public Bunch(List<Tile> t) {
        tiles = t;
    }

    public void peel(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            int random = new Random().nextInt(tiles.size());
            players.get(i).addTile(tiles.get(random));
            tiles.remove(random);
        }
    }
}
