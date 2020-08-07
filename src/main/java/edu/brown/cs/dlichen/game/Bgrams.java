package edu.brown.cs.dlichen.game;

import edu.brown.cs.dlichen.common.Constants;

import java.util.*;

/**
 * Bananagrams driver, representation of the game
 */
public class Bgrams {

    private Bunch bunch;
    private List<Player> players;

    /**
     * constructor
     */
    public Bgrams() {
    }

    public void startGame(int numPlayers) {
        assert numPlayers > 0; //can you play alone?
        assert numPlayers < 9;
        players = new ArrayList<>();
        //TODO: what happens with one player?
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player());
        }
        this.distributeTiles();
    }

    /**
     * distributes tiles to players and to the Bunch
     */
    private void distributeTiles() {
        List<Tile> tiles = Tiles.allTiles();
        int numPlayers = players.size();

        Map<Player, Set<Integer>> playerTiles = new HashMap<>();
        List<Tile> used = new ArrayList<>();

        int numTilesPP = -1;
        if (numPlayers <= 4) {
            numTilesPP = Constants.FOUR_PLAYER_NUMTILES;
        } else if (numPlayers <= 6) {
            numTilesPP = Constants.SIX_PLAYER_NUMTILES;
        } else if (numPlayers <= 8) {
            numTilesPP = Constants.EIGHT_PLAYER_NUMTILES;
        }

        assert numTilesPP != -1; //TODO: check this!

        for (Player p: players) {
            used = new ArrayList<>();
            for (int i = 0; i < numTilesPP; i++) {
                int random = new Random().nextInt(tiles.size() - used.size());
                while (used.contains(tiles.get(random))) {
                    random = new Random().nextInt(tiles.size() - used.size()); //until you get a non used random
                }
                used.add(tiles.get(random));
            }
            tiles.removeAll(used);
            p.setTiles(used);
        }

//        Iterator<Player> playerIter = players.iterator();
//        while (playerIter.hasNext()) {
//            Player currPlayer = playerIter.next();
//            Set<Integer> currTiles = playerTiles.get(currPlayer);
//            if (currTiles == null) {
//                currTiles = new HashSet<>();
//            }
//            for (int i = 0; i < numTilesPP; i++) {
//                int random = new Random().nextInt(tiles.size() - used.size());
//                while (used.contains(random)) { //makes it so multiple players can't claim the same tile
//                    random = new Random().nextInt(tiles.size() - 1 - used.size());
//                }
//                currTiles.add(random);
//                used.add(random);
//            }
//            playerTiles.put(currPlayer, currTiles);
//        }
//
//        Iterator<Tile> tilesIter = tiles.iterator();
//        int i = 0;
//        while (tilesIter.hasNext()) {
//            for (Player p: playerTiles.keySet()) {
//                if (playerTiles.get(p).contains(i)) {
//                    p.addTile(tilesIter.next());
//                    tilesIter.remove();
//                }
//            }
//            i++;
//        }

        bunch = new Bunch(tiles); //add remaining tiles to the bunch

    }
}
