package main;

import java.util.Scanner;

public class m {
    public static final int CONTINUE = 0;
    public static final int WIN_1 = 1;
    public static final int WIN_2 = 2;
    public static final int DRAW = 3;
    public static final char PLAYER_1 ='+';
    public static final char PLAYER_2='-';
    public static final char EMPTY='@';

    public static void main(String[] args) {
        //oihhborthbjrtnb

        char[][] gameField = {{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}};
        showField(gameField);
        int result;
        char symbol = PLAYER_1;
        do {
            move(gameField, symbol);
            symbol = symbol == PLAYER_1 ? PLAYER_2 : PLAYER_1;
            showField(gameField);
            result = checkField(gameField);


        } while (result == CONTINUE);

        showResult(result);

    }

    public static int checkField(char[][] gameField) {      //Проверка условий победы

        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] == gameField[i][1] && gameField[i][1] == gameField[i][2]) {
                if (gameField[i][0] == PLAYER_1) {
                    return WIN_1;
                }
                if (gameField[i][0] == PLAYER_2) {
                    return WIN_2;
                }
            }
            if (gameField[0][i] == gameField[1][i] && gameField[1][i] == gameField[2][i]) {
                if (gameField[0][i] == PLAYER_1) {
                    return WIN_1;
                }
                if (gameField[0][i] == PLAYER_2) {
                    return WIN_2;


                }
            }
        }
        if (gameField[0][0] == gameField[1][1] && gameField[1][1] == gameField[2][2]) {
            if (gameField[0][0] == PLAYER_1) return WIN_1;
            if (gameField[0][0] == PLAYER_2) return WIN_2;
        }
        if (gameField[0][2] == gameField[1][1] && gameField[1][1] == gameField[2][0]) {
            if (gameField[0][0] == PLAYER_1) return WIN_1;
            if (gameField[0][0] == PLAYER_2) return WIN_2;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameField[i][j] == EMPTY) return CONTINUE;
            }
        }
        return DRAW;
    }

    public static void move(char[][] gameField, char symbol) {  // Ход
        Scanner in = new Scanner(System.in);
        int n, m, number;
        do {
            System.out.println("Сейчас ходит " + symbol);
            number = in.nextInt();

            n = 2 - (number - 1) / 3;
            m = (number - 1) % 3;

        } while (number < 1 || number > 9 || gameField[n][m] != EMPTY);
        gameField[n][m] = symbol;
        System.out.println();

    }

    public static void showField(char a[][]) { //Игровое поле
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

    public static void showResult(int result) { // Вывод итогов игры
        switch (result) {
            case WIN_1:
                System.out.println("Победа "+PLAYER_1);
                break;
            case WIN_2:
                System.out.println("Победа "+PLAYER_2);
                break;
            case DRAW:
                System.out.println("Ничья");
                break;
        }

    }
}
