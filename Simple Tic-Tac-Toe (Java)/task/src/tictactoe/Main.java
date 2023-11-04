package tictactoe;

import java.util.Scanner;

public class Main {

    public static void showGrid(char[][] grid) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("| ");
            System.out.println();
        }
        System.out.println("---------");
    }

    public static void turnX(char[][] grid) {
        do {
            Scanner s = new Scanner(System.in);
            String data = s.nextLine();
            String dataNS = data.replace(" ", "");
            int n1;
            int n2;
            if (!dataNS.matches("\\d+")) {
                System.out.println("You should enter numbers!");
            } else {
                char c1 = dataNS.charAt(0);
                char c2 = dataNS.charAt(1);
                int numberOne = Character.getNumericValue(c1);
                int numberTwo = Character.getNumericValue(c2);
                if (( numberOne < 1 || numberOne > 3 ) || (numberTwo < 1 || numberTwo > 3 )) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (grid[numberOne - 1][numberTwo - 1] == 'X' || grid[numberOne - 1][numberTwo - 1] == 'O'){
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    n1 = numberOne;
                    n2 = numberTwo;
                    grid[n1 - 1][n2 - 1] = 'X';
                    showGrid(grid);
                    break;
                }
            }
        } while (true);
    }

    public static void turnO(char[][] grid) {
        do {
            Scanner s = new Scanner(System.in);
            String data = s.nextLine();
            String dataNS = data.replace(" ", "");
            int n1;
            int n2;
            if (!dataNS.matches("\\d+")) {
                System.out.println("You should enter numbers!");
            } else {
                char c1 = dataNS.charAt(0);
                char c2 = dataNS.charAt(1);
                int numberOne = Character.getNumericValue(c1);
                int numberTwo = Character.getNumericValue(c2);
                if (( numberOne < 1 || numberOne > 3 ) || (numberTwo < 1 || numberTwo > 3 )) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (grid[numberOne - 1][numberTwo - 1] == 'X' || grid[numberOne - 1][numberTwo - 1] == 'O'){
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    n1 = numberOne;
                    n2 = numberTwo;
                    grid[n1 - 1][n2 - 1] = 'O';
                    showGrid(grid);
                    break;
                }
            }
        } while (true);
    }

    public static boolean checkResult(char[][] grid) {
        boolean winner = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && ( grid[i][0] == 'X' || grid[i][0] == 'O' )) {
                    System.out.print(grid[i][0] + " wins!");
                    winner = false;
                    break;
                } else if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && ( grid[0][i] == 'X' || grid[0][i] == 'O' )) {
                    System.out.print(grid[0][i] + " wins!");
                    winner = false;
                    break;
                }
            }
        }
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && ( grid[0][0] == 'X' || grid[0][0] == 'O' )) {
            System.out.print(grid[0][0] + " wins!");
            winner = false;
        } else if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && ( grid[1][1] == 'X' || grid[1][1] == 'O' )) {
            System.out.print(grid[1][1] + " wins!");
            winner = false;
        }
        return winner;
    }

    public static void main(String[] args) {
        char[][] grid2D= new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid2D[i][j] = ' ';
            }
        }
        showGrid(grid2D);

        int rounds = 0;
        boolean endGame;

        do {
            turnX(grid2D);
            endGame = checkResult(grid2D);
            rounds++;
            if (!endGame) {
                break;
            } else if (rounds == 9) {
                System.out.println("Draw");
                break;
            }
            turnO(grid2D);
            endGame = checkResult(grid2D);
            rounds++;
        } while (endGame);

    }
}