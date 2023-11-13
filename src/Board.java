public class Board {
    static final int size = 4;
    private int[][] board;
    private final RandomTile randomtile;

    public Board() {
        board = new int[size][size];
        randomtile = new RandomTile();
    }

    public void Start() {
        board = new int[size][size];
    }

    public void AddRandomTile() {
        randomtile.AddTile(board);
    }

    public void PrintBoard() {
        System.out.println();
        System.out.println("Current Board:");
        for (int[] col : board) {
            for (int number : col) {
                System.out.print(number + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean GameOver() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0 ||
                        (i + 1 < size && board[i][j] == board[i + 1][j]) ||
                        (j + 1 < size && board[i][j] == board[i][j + 1])) {
                    return false;
                }
            }
        }
        System.out.println("Game over!");
        return true;
    }
    public boolean GameWin() {
        for (int[] row : board) {
            for (int value : row){
                if(value == 2048){
                    System.out.println("You won!");
                    return true;
                }
            }
        }
        return false;
    }

    public void MoveUp() {
        for (int col = 0; col < size; col++) {
            for (int row = 1; row < size; row++) {
                Condition(row, col,"Up");
            }
        }
    }

    public void MoveDown() {
        for (int col = 0; col < size; col++) {
            for (int row = size - 2; row >= 0; row--) {
                Condition(row, col,"Down");
            }
        }
    }

    public void MoveRight() {
        for (int row = 0; row < size; row++) {
            for (int col = size - 2; col >= 0; col--) {
               Condition(row, col,"Right");
            }
        }
    }

    public void MoveLeft() {
        for (int row = 0; row < size; row++) {
            for (int col = 1; col < size; col++) {
                Condition(row, col,"Left");
            }
        }
    }
    public void Condition(int row, int col, String move) {
        if (board[row][col] != 0) {
            if(move == "Right"){
                int currentCol = col;
                MovementLR(row, currentCol, "Right", 1);
            }
            else if(move == "Left"){
                int currentCol = col;
                MovementLR(row, currentCol, "Left", -1);
            }
            else if(move == "Up"){
                int currentRow = row;
                MovementUD(col, currentRow, "Up", -1);
            }
            else if(move == "Down"){
                int currentRow = row;
                MovementUD(col, currentRow, "Down", 1);
            }
        }
    }

    public void MovementLR(int row, int currentCol, String move, int next) {
        do {
            if (board[row][currentCol + next] == 0) {
                board[row][currentCol + next] = board[row][currentCol];
                board[row][currentCol] = 0;
                currentCol = currentCol + next;
            } else if (board[row][currentCol + next] == board[row][currentCol]) {
                board[row][currentCol + next] *= 2;
                board[row][currentCol] = 0;
                break;
            } else {
                break;
            }
        } while (move == "Right" && currentCol < size - 1 ||
                move == "Left" && currentCol > 0);


    }

    public void MovementUD(int col, int currentRow, String move, int next) {
        do {
            if (board[currentRow + next][col] == 0) {
                board[currentRow + next][col] = board[currentRow][col];
                board[currentRow][col] = 0;
                currentRow = currentRow + next;
            } else if (board[currentRow + next][col] == board[currentRow][col]) {
                board[currentRow + next][col] *= 2;
                board[currentRow][col] = 0;
                break;
            } else {
                break;
            }
        } while (move == "Down" && currentRow < size - 1 ||
                move == "Up" && currentRow > 0);


    }

    public int GetTileValue(int col, int row) {
        return board[col][row];
    }

    public void SetTileValue(int col, int row, int value) {
        board[col][row] = value;
    }
}
