package Mancala;

import MyUtils.MyUtils;

import java.util.ArrayList;
import java.util.Arrays;

class Board {
    private int[] board;

    Board() {
        board = new int[]{4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0};
    }

    ArrayList<Integer> getChoicesForPlayer(Player player) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        if (player.getOrder().equals(Order.FIRST)) {
            for (int i = 5; i >= 0; i--) {
                if (board[i] != 0) {
                    indexes.add(translateHumanMoveToIndex(i));
                }
            }
        } else {
            for (int i = 7; i <= 12; i++) {
                if (board[i] != 0) {
                    indexes.add(i);
                }
            }
        }
        return indexes;
    }

    boolean moveRocks(Player currentPlayer, int move) { //if return true, then another move
        int amountOfRocks = pickRocksForIndex(translateHumanMoveToIndex(move));
        int indexOfCurrentHole = translateHumanMoveToIndex(move) + 1;
        if (currentPlayer.getOrder().equals(Order.FIRST)) {
            return moveRocksForPlayer(6, 13, amountOfRocks, indexOfCurrentHole);
        } else {
            return moveRocksForPlayer(13, 6, amountOfRocks, indexOfCurrentHole);
        }
    }

    int getPointsForPlayer(Player player) {
        if (player.getOrder().equals(Order.FIRST)) {
            return board[6];
        } else {
            return board[13];
        }
    }

    void print() {
        System.out.println("   " + Arrays.toString(MyUtils.invertArray(Arrays.copyOfRange(board, 0, 6))));
        System.out.printf(board[6] + "%" + 23 + "s" + board[13] + "\n", " ");
        System.out.println("   " + Arrays.toString(Arrays.copyOfRange(board, 7, 13)));
        System.out.println("---------------------------------");
    }

    boolean isPlayerSideEmpty(Player player) {
        int startIndex, endIndex;
        if (player.getOrder().equals(Order.FIRST)) {
            startIndex = 0;
            endIndex = 5;
        } else {
            startIndex = 7;
            endIndex = 12;
        }
        for (int i = startIndex; i <= endIndex; i++) {
            if (board[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private int pickRocksForIndex(int index) {
        int rocksAmount = board[index];
        board[index] = 0;
        return rocksAmount;
    }

    private int translateHumanMoveToIndex(int move) {
        if (move <= 6) {
            return Math.abs(move - 6);
        } else {
            return move;
        }
    }

    private boolean moveRocksForPlayer(int myPointsIndex, int otherPointsIndex, int amountOfRocks, int index) {
        while (amountOfRocks != 0) {
            if (index == otherPointsIndex) {
                index = otherPointsIndex == 13 ? 0 : 7;
            }
            board[index] = board[index] + 1;
            amountOfRocks--;
            if (amountOfRocks == 0 && board[index] > 1) { //if last rock
                if (index == myPointsIndex) { //if last rock falls into my points
                    return true;
                } else {
                    amountOfRocks = pickRocksForIndex(index);
                }
            }
            index++;
        }
        return false;
    }
}

