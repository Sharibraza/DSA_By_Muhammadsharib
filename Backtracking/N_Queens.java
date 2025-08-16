package Backtracking;

import java.util.Scanner;

public class N_Queens {
     static int count = 0;

  public static void printBoard(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("---------------");
  }

  public static boolean isSafe(char board[][], int row, int col) {

    // up
    for (int i = row - 1; i >= 0; i--) {
      if (board[i][col] == 'Q') {
        return false;
      }
    }

    // rd
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    // ld
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    return true;
  }

  public static boolean nQueens(char board[][], int row) {

    // if (row == board.length) {
    // count++;
    // printBoard(board);
    // return;
    // }

    if (row == board.length) { // For printing only one soln
      return true;
    }

    for (int j = 0; j < board.length; j++) {

      if (isSafe(board, row, j)) {
        board[row][j] = 'Q';
        if (nQueens(board, row + 1)) {
          return true;
        } else {
          board[row][j] = '-';
        }
      }

    }
    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = 5;

    char board[][] = new char[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '-';
      }
    }

    if (nQueens(board, 0)) {
      System.out.println("\nsol is possible\n");
      printBoard(board);
    } else {
      System.out.println("sol is not possible");
    }

    System.out.println(count);
  }
}

// N_Queens :- 4 variations

// 1. No Attack, all ways
// 2. With Attack ( isSafe )
// 3. count all possible sol
// 4. Print only one sol

