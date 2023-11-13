import java.util.Scanner;

public class GameRules {
    private final Board board;
    private final Scanner scanner;

    public GameRules() {
        board = new Board();
        scanner = new Scanner(System.in);
    }

    public void Game2048() {
        board.Start();
        board.AddRandomTile();
        board.AddRandomTile();
        board.PrintBoard();
        while (true) {
            Input();
            board.AddRandomTile();
            board.PrintBoard();
            if (board.GameOver()|| board.GameWin()){
                break;
            }
        }
        scanner.close();
    }

    public void Input() {
        boolean repeat;
        System.out.print("(W) Up (A) Left (S) Down (D) Right (R) Restart (Q) Quit: ");
        do {
            repeat = false;
            String input = scanner.next().toUpperCase();
            switch (input) {
                case "W" -> board.MoveUp();
                case "S" -> board.MoveDown();
                case "D" -> board.MoveRight();
                case "A" -> board.MoveLeft();
                case "R" -> {
                    board.Start();
                    board.AddRandomTile();
                }
                case "Q" -> {
                    System.out.println("Quitting the game.");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid input. Use W/A/S/D to move.");
                    repeat = true;
                }
            }
        } while (repeat);
    }
}


