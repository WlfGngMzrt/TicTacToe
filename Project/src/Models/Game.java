package Models;

import Exceptions.DuplicatePlayerCharacterException;
import Exceptions.InvalidBotCountException;
import Exceptions.InvalidDimensionException;
import Exceptions.InvalidNumberOfPlayers;

import Strategy.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player player;
    private GameState gameState;
    private Player winner;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(List<Player> players, Board board, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.board = board;
        this.moves = new ArrayList<Move>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winningStrategies = winningStrategies;
    }


    public static class Builder
    {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        public Builder() {

        }

        public static Builder builder()
        {
            return new Builder();
        }

        public Builder(List<Player> players, List<WinningStrategy> winningStrategies, int dimension) {
            this.players = new ArrayList<Player>();
            this.winningStrategies = new ArrayList<WinningStrategy>();
            this.dimension = 0;
        }
        public void setPlayers(List<Player> players) {
            this.players = players;
        }
        public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
        }
        public void setDimension(int dimension) {
            this.dimension = dimension;
        }

        public void addPlayer(Player player)
        {
            players.add(player);
        }

        public void addWinningStrategy(WinningStrategy winningStrategy)
        {
            winningStrategies.add(winningStrategy);
        }

        private void validateBotCounts()
        {
            int botCount = 0;
            for(Player player : players)
            {
                if(player.getPlayerType().equals(PlayerType.BOT))
                {
                    botCount++;
                }
                if(botCount > 1)
                {
                    //throw an Exception
                    throw new InvalidBotCountException("Bot Cout has exceeded 1");
                }
            }
        }

        private void validateDimension()
        {
            if(dimension < 3 || dimension > 10)
            {
                    throw new InvalidDimensionException("Dimension can either be more than 2 or less than 11");
            }
        }

        private void validateNumberOfPlayers()
        {
            if(players.size() != dimension -1)
            {
                throw new InvalidNumberOfPlayers("Players should be 1 less than the dimension");
            }
        }

        private void validateUniqueSymbolForAllPlayers()
        {
            HashSet<Character> set = new HashSet<>();
            for(Player player : players)
            {
                set.add(player.getSymbol().getSymbolChar());
            }
            if(set.size() != players.size())
            {
                throw new DuplicatePlayerCharacterException("Every Player should have unique symbol");
            }
        }
        private void validate()
        {
            validateDimension();
            validateBotCounts();
            validateNumberOfPlayers();
            validateUniqueSymbolForAllPlayers();
        }

        private Game build()
        {
            validate();
            return  new Game(players,new Board(dimension), winningStrategies);
        }
    }
}

