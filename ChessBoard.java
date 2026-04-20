public class ChessBoard {
    private char[][] board;

    public ChessBoard() {
        loadFromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
    }

    public void loadFromFEN(String fen) {
        board = new char[8][8];
        String[] rows = fen.split("/");

        for (int i = 0; i < 8; i++) {
            int col = 0;
            for (char c : rows[i].toCharArray()) {
                if (Character.isDigit(c)) {
                    int empty = c - '0';
                    for (int j = 0; j < empty; j++) {
                        board[i][col++] = '.';
                    }
                } else {
                    board[i][col++] = c;
                }
            }
        }
    }

    public void printBoard() {
        System.out.println("\n  a b c d e f g h");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(8 - i);
        }
        System.out.println("  a b c d e f g h\n");
    }

    public boolean move(String from, String to) {
        int[] start = parsePosition(from);
        int[] end = parsePosition(to);

        if (start == null || end == null) return false;

        char piece = board[start[0]][start[1]];
        if (piece == '.') return false;

        // simple move (no validation yet)
        board[end[0]][end[1]] = piece;
        board[start[0]][start[1]] = '.';

        return true;
    }

    private int[] parsePosition(String pos) {
        if (pos.length() != 2) return null;

        int col = pos.charAt(0) - 'a';
        int row = 8 - (pos.charAt(1) - '0');

        if (row < 0 || row > 7 || col < 0 || col > 7) return null;

        return new int[]{row, col};
    }
}