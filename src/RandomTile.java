import java.util.Random;

public class RandomTile {
    static final int Probability = 10;
    static final int Breakpoint = 0;
    static final int MinVal = 2;
    static final int MaxVal = 4;

    public void AddTile(int[][] board) {
        int col, row;
        int value = (new Random().nextInt(Probability) == Breakpoint) ? MaxVal : MinVal;
        do {
            col = new Random().nextInt(board.length);
            row = new Random().nextInt(board[0].length);
        } while (board[row][col] != 0);

        board[row][col] = value;
    }
}
