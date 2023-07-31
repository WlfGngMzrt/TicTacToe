package Strategy.WinningStrategies;

import Models.Board;
import Models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy{

    private List<HashMap<Character,Integer>> rowSymbolCount = new ArrayList<>();
    private List<HashMap<Character,Integer>> colSymbolCount = new ArrayList<>();

    private List<HashMap<Character,Integer>> topLeftDiagonalSymbolCount = new ArrayList<>();

    private List<HashMap<Character,Integer>> bottomLeftDiagonalSymbolCount = new ArrayList<>();

    private List<HashMap<Character,Integer>> cornerSymbolCount = new ArrayList<>();

    public OrderOneWinningStrategy(int dimension) {

        for(int i = 0;i < dimension; i++)
        {
            rowSymbolCount.add(new HashMap<>());
            colSymbolCount.add(new HashMap<>());
            topLeftDiagonalSymbolCount.add(new HashMap<>());
            bottomLeftDiagonalSymbolCount.add(new HashMap<>());

        }



    }

    @Override
    public Player checkWinner(Board board) {
        return null;
    }
}
