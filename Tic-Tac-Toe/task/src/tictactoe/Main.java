package tictactoe;
import java.util.Scanner;
public class Main {
    static char[][] gameGrid = new char[3][3];
    public static boolean impossibleCheck(char[][] gameGrid) {
        boolean isXWon = false;
        boolean isYWon = false;
        int XCount = 0;
        int OCount = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (gameGrid[i][j] == 'X') {
                    ++XCount;
                } else if (gameGrid[i][j] == 'O') {
                    ++OCount;
                }
            }

        }

        char currentSymbolCheck = 'X';
        for (int start = 0; start < 2; ++start) {
            for (int i = 0; i < 3; ++i) {
                if (gameGrid[i][0] == currentSymbolCheck && gameGrid[i][1] == currentSymbolCheck && gameGrid[i][2] == currentSymbolCheck){
                    if (currentSymbolCheck == 'X') {
                        isXWon = true;
                    } else {
                        isYWon = true;
                    }
                    break;

                }
                if (gameGrid[0][i] == currentSymbolCheck && gameGrid[1][i] == currentSymbolCheck && gameGrid[2][i] == currentSymbolCheck){
                    if (currentSymbolCheck == 'X') {
                        isXWon = true;
                    } else {
                        isYWon = true;
                    }
                    break;
                }
            }
            for (int j = 0; j < 2; ++j) {
                if (gameGrid[0][0] == currentSymbolCheck && gameGrid[1][1] == currentSymbolCheck && gameGrid[2][2] == currentSymbolCheck){
                    if (currentSymbolCheck == 'X') {
                        isXWon = true;
                    } else {
                        isYWon = true;
                    }
                    break;
                }
                if (gameGrid[0][2] == currentSymbolCheck && gameGrid[1][1] == currentSymbolCheck && gameGrid[2][0] == currentSymbolCheck){
                    if (currentSymbolCheck == 'X') {
                        isXWon = true;
                    } else {
                        isYWon = true;
                    }
                    break;
                }
            }
            currentSymbolCheck = 'O';
        }
        if ((isXWon && isYWon) || Math.abs(XCount - OCount) >= 2) {
            return true;
        }
        return false;
    }
    public static int checkEmptyCells(char[][] gameGrid) {
        int emptyCellsCount = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (gameGrid[i][j] == '_') {
                    ++emptyCellsCount;
                }
            }
        }
        return  emptyCellsCount;
    }

    public static String checkWins(char[][] gameGrid) {
        char currentSymbolCheck = 'X';
        for (int start = 0; start < 2; ++start) {
            for (int i = 0; i < 3; ++i) {
                if (gameGrid[i][0] == currentSymbolCheck && gameGrid[i][1] == currentSymbolCheck && gameGrid[i][2] == currentSymbolCheck){
                    return  currentSymbolCheck + " wins";

                }
                if (gameGrid[0][i] == currentSymbolCheck && gameGrid[1][i] == currentSymbolCheck && gameGrid[2][i] == currentSymbolCheck){
                    return  currentSymbolCheck + " wins";
                }
            }
            for (int j = 0; j < 2; ++j) {
                if (gameGrid[0][0] == currentSymbolCheck && gameGrid[1][1] == currentSymbolCheck && gameGrid[2][2] == currentSymbolCheck){
                    return  currentSymbolCheck + " wins";
                }
                if (gameGrid[0][2] == currentSymbolCheck && gameGrid[1][1] == currentSymbolCheck && gameGrid[2][0] == currentSymbolCheck){
                    return  currentSymbolCheck + " wins";
                }
            }
            currentSymbolCheck = 'O';
        }
        return "";
    }

    public static String getGameState(char[][] gameGrid) {
        String winStatus = checkWins(gameGrid);
        if (impossibleCheck(gameGrid)){
            return "Impossible";
        } else if (winStatus != "") {
            return winStatus;
        } else if (checkWins(gameGrid) == "" && checkEmptyCells(gameGrid) == 0) {
           return "Draw";
        } else {
            return "Game not finished";
        }

    }
    public static void displayGameGrid(char[][] gameGrid) {
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

    public static void updateGameGrid(char[][] gameGrid, int currentPlayerSymbol) {
        Scanner scanner = new Scanner(System.in);
        boolean isException = true;
        System.out.println("Enter the coordinates:");
        String inputX = scanner.next();
        String inputY = scanner.next();
        while (!inputX.matches("[0-9]+") || !inputY.matches("[0-9]+")) {
            System.out.println("You should enter numbers!");
            System.out.println("Enter the coordinates:");
            inputX = scanner.next();
            inputY = scanner.next();
        }
        int intX = Integer.parseInt(inputX);
        int intY = Integer.parseInt(inputY);
        while (intX > 3 || intY > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            System.out.println("Enter the coordinates:");
            inputX = scanner.next();
            inputY = scanner.next();
            while (!inputX.matches("[0-9]+") || !inputY.matches("[0-9]+")) {
                System.out.println("You should enter numbers!");
                System.out.println("Enter the coordinates:");
                inputX = scanner.next();
                inputY = scanner.next();
            }
            intX = Integer.parseInt(inputX);
            intY = Integer.parseInt(inputY);
        }
        while (gameGrid[3 - intY][intX - 1] != '_') {
            System.out.println("This cell is occupied! Choose another one!");
            System.out.println("Enter the coordinates:");
            inputX = scanner.next();
            inputY = scanner.next();
            while (!inputX.matches("[0-9]+") || !inputY.matches("[0-9]+")) {
                System.out.println("You should enter numbers!");
                System.out.println("Enter the coordinates:");
                inputX = scanner.next();
                inputY = scanner.next();
            }
            intX = Integer.parseInt(inputX);
            intY = Integer.parseInt(inputY);

            while (intX > 3 || intY > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                System.out.println("Enter the coordinates:");
                inputX = scanner.next();
                inputY = scanner.next();
                while (!inputX.matches("[0-9]+") || !inputY.matches("[0-9]+")) {
                    System.out.println("You should enter numbers!");
                    System.out.println("Enter the coordinates:");
                    inputX = scanner.next();
                    inputY = scanner.next();
                }
                intX = Integer.parseInt(inputX);
                intY = Integer.parseInt(inputY);
            }


        }
        if (currentPlayerSymbol == 0) {
            gameGrid[3 - intY][intX - 1] = 'X';
        } else {
            gameGrid[3 - intY][intX - 1] = 'O';
        }

        //displayGameGrid(gameGrid);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "_________";
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                gameGrid[i][j] = userInput.charAt(i * 3 + j);
            }
        }
        displayGameGrid(gameGrid);
        String currentGameState = getGameState(gameGrid).toString();
        //System.out.println(currentGameState);
        int totalMoves = 0;
        while (currentGameState.equals("Game not finished")) {
            updateGameGrid(gameGrid,totalMoves % 2);
            currentGameState = getGameState(gameGrid).toString();
            //System.out.println(currentGameState);
            displayGameGrid(gameGrid);
            ++totalMoves;
        }
        System.out.println(currentGameState);
    }
}
