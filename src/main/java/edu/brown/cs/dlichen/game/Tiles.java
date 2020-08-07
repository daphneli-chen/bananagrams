package edu.brown.cs.dlichen.game;

import java.util.*;

/**
 * Class used for general Tile functions
 */
public final class Tiles {

    private static Map<Character, Integer> COUNTS;
    private static Map<Integer, Tile> TILES = new HashMap<>();

    //fills the map with the characters and their respective counts in the game
    static
    {
        COUNTS = new HashMap<>();
        COUNTS.put('j', 2);
        COUNTS.put('k', 2);
        COUNTS.put('q', 2);
        COUNTS.put('x', 2);
        COUNTS.put('z', 2);
        COUNTS.put('b', 3);
        COUNTS.put('c', 3);
        COUNTS.put('f', 3);
        COUNTS.put('h', 3);
        COUNTS.put('m', 3);
        COUNTS.put('p', 3);
        COUNTS.put('v', 3);
        COUNTS.put('w', 3);
        COUNTS.put('y', 3);
        COUNTS.put('g', 4);
        COUNTS.put('l', 5);
        COUNTS.put('d', 6);
        COUNTS.put('s', 6);
        COUNTS.put('u', 6);
        COUNTS.put('n', 8);
        COUNTS.put('t', 9);
        COUNTS.put('r', 9);
        COUNTS.put('o', 11);
        COUNTS.put('i', 12);
        COUNTS.put('a', 13);
        COUNTS.put('e', 18);

    }

    private Tiles() {}

    /**
     * Generates a set of Tile according to the set numbers in COUNTS
     * @return set of Tile, to be used for game
     */
    public static List<Tile> allTiles() {
        int id = 0;
        List<Tile> all = new ArrayList<>();
        for (Character c: COUNTS.keySet()) {
            for (int i = 0; i < COUNTS.get(c); i++) {
                id++;
                Tile t = new Tile(c, id);
                all.add(t); //this should give each tile a unique id
                TILES.put(id,t);
            }
        }
        return all;
    }

    public static Tile getTile(int id) {
        return TILES.get(id);
    }

}
