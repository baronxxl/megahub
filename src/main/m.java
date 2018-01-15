package main;

import java.util.Scanner;

public class m {
    public static void main(String[] args) {
        //oihhborthbjrtnb

        char[][] gameField = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        showField(gameField);
        int result;
        char symbol = 'x';
        do {
            move(gameField, symbol);
            symbol = symbol == 'x' ? '0' : 'x';
            showField(gameField);
            result = checkField(gameField);


        } while (result == 0);
        switch (result) {
            case 1:
                System.out.println("pobeda X");
                break;
            case 2:
                System.out.println("pobeda 0");
                break;
            case 3:
                System.out.println("ni4'9");
                break;
        }


    }

    public static int checkField(char[][] gameField) {

        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] == gameField[i][1] && gameField[i][1] == gameField[i][2]) {
                if (gameField[i][0] == 'x') {
                    return 1;
                }
                if (gameField[i][0] == '0') {
                    return 2;
                }
            }
            if (gameField[0][i] == gameField[1][i] && gameField[1][i] == gameField[2][i]) {
                if (gameField[0][i] == 'x') {
                    return 1;
                }
                if (gameField[0][i] == '0') {
                    return 2;


                }
            }
        }
        if (gameField[0][0] == gameField[1][1] && gameField[1][1] == gameField[2][2]) {
            if (gameField[0][0] == 'x') return 1;
            if (gameField[0][0] == '0') return 2;
        }
        if (gameField[0][2] == gameField[1][1] && gameField[1][1] == gameField[2][0]) {
            if (gameField[0][0] == 'x') return 1;
            if (gameField[0][0] == '0') return 2;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameField[i][j] == ' ') return 0;
            }
        }
        return 3;
    }

    public static void move(char[][] gameField, char symbol) {
        Scanner in = new Scanner(System.in);
        int n, m, number;
        do {
            System.out.println("Сейчас ходит " + symbol);
            number = in.nextInt();

            n = 2 - (number - 1) / 3;
            m = (number - 1) % 3;

        } while (number < 1 || number > 9 || gameField[n][m] != ' ');
        gameField[n][m] = symbol;
        System.out.println();

    }

    public static void showField(char a[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + a[i][j] + " ");
                if (j != 2) {
                    System.out.print("|");
                }
            }
            if (i != 2) {
                System.out.println();
                System.out.print("-----------");
                System.out.println();
            }
        }
        System.out.println();


    }
}
