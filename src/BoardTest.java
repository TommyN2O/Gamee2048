import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @Test
    public void TestAddTile() {
        Board board = new Board();
        board.AddRandomTile();
        boolean tileAdded = false;

        for (int i = 0; i < Board.size; i++) {
            for (int j = 0; j < Board.size; j++) {
                if (board.GetTileValue(i, j) != 0) {
                    tileAdded = true;
                    break;
                }
            }
        }

        assertTrue(tileAdded, "No tile added to the board.");
    }

    @Test
    public void TestMoveDown() {
        Board board = new Board();
        board.SetTileValue(0, 0, 2);
        board.SetTileValue(1, 0, 2);
        board.SetTileValue(2, 0, 4);

        board.MoveDown();

        assertEquals(0, board.GetTileValue(1, 0));
        assertEquals(4, board.GetTileValue(2, 0));
        assertEquals(4, board.GetTileValue(3, 0));
    }

    @Test
    public void TestAllMoves() {
        Board board = new Board();

        board.SetTileValue(0, 0, 4);
        board.SetTileValue(0, 3, 8);
        board.SetTileValue(1, 0, 4);
        board.SetTileValue(1, 3, 16);

        board.MoveUp();
        board.MoveRight();
        board.MoveDown();
        board.MoveLeft();

        assertEquals(32, board.GetTileValue(3, 0));
    }

    @Test
    public void TestGameOver(){
        Board board = new Board();
        for(int i=0;i<Board.size;i++){
            for(int j=0;j<Board.size;j++){
                board.SetTileValue(i, j, 2);
            }
        }
        assertFalse(board.GameOver(), "Game shouldn't be over there are available moves.");
    }
    @Test
    public void TestGameOverWithEmptyBoard() {
        Board board = new Board();

        assertFalse(board.GameOver(), "Game should not be over with an empty board.");
    }

    @Test
    public void TestGameOverWithNoAvailableMoves() {
        Board board = new Board();
        board.SetTileValue(0, 0, 2);
        board.SetTileValue(0, 1, 4);
        board.SetTileValue(0, 2, 8);
        board.SetTileValue(0, 3, 16);
        board.SetTileValue(1, 0, 16);
        board.SetTileValue(1, 1, 8);
        board.SetTileValue(1, 2, 4);
        board.SetTileValue(1, 3, 2);
        board.SetTileValue(2, 0, 2);
        board.SetTileValue(2, 1, 4);
        board.SetTileValue(2, 2, 8);
        board.SetTileValue(2, 3, 16);
        board.SetTileValue(3, 0, 16);
        board.SetTileValue(3, 1, 8);
        board.SetTileValue(3, 2, 4);
        board.SetTileValue(3, 3, 2);

        assertTrue(board.GameOver(), "Game should be over with no available moves.");
    }

    @Test
    public void TestGameWin(){
        Board board = new Board();
        board.SetTileValue(2, 1, 2048);
        assertTrue(board.GameWin(), "Game should be won with a 2048 tile.");
    }

    @Test
    public void TestGameWinWithEmptyBoard() {
        Board board = new Board();

        assertFalse(board.GameWin(), "Game should not be won with an empty board.");
    }

    @Test
    public void TestGameWinWithNo2048Tile() {
        Board board = new Board();
        board.SetTileValue(0, 0, 2);
        board.SetTileValue(0, 1, 4);
        board.SetTileValue(0, 2, 8);
        board.SetTileValue(0, 3, 16);
        board.SetTileValue(1, 0, 16);
        board.SetTileValue(1, 1, 8);
        board.SetTileValue(1, 2, 4);
        board.SetTileValue(1, 3, 2);
        board.SetTileValue(2, 0, 2);
        board.SetTileValue(2, 1, 4);
        board.SetTileValue(2, 2, 8);
        board.SetTileValue(2, 3, 16);
        board.SetTileValue(3, 0, 16);
        board.SetTileValue(3, 1, 8);
        board.SetTileValue(3, 2, 4);
        board.SetTileValue(3, 3, 2);

        assertFalse(board.GameWin(), "Game should not be won with no 2048 tile.");
    }
}

