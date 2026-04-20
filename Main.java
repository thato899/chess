import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.printBoard();

            System.out.print("Enter move (e.g. e2 e4) or 'exit': ");
            String input = scanner.nextLine();

            if (input.equals("exit")) break;

            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid input!");
                continue;
            }

            if (!board.move(parts[0], parts[1])) {
                System.out.println("Invalid move!");
            }
        }

        scanner.close();
    }
}