package tictactoe;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String userInput = scanner.nextLine();
        char[][] gameGrid = new char[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                gameGrid[i][j] = userInput.charAt(i * 3 + j);
            }
        }
        System.out.println("---------");
        for (int i = 0; i < 3; ++i) {
            System.out.print("| ");
            for (int j = 0; j < 3; ++j) {
                System.out.print(gameGrid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

    }
}
