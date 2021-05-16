package Mancala;

import java.util.Random;

public class Mancala {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player currentPlayer;
    private Board board;

    public Mancala(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.currentPlayer = randomizeFirstPlayer();
        this.board = new Board();
    }

    public void run() {
        board.print();
        while (!isGameFinished()) {
            int move = currentPlayer.chooseMove(board, getOtherPlayer(currentPlayer));
            boolean samePlayer = board.moveRocks(currentPlayer, move);
            if (!samePlayer) {
                currentPlayer = changePlayer();
            }
            board.print();
        }
        System.out.println(getWinner().getOrder() + " player won!");
    }

    private Player getOtherPlayer(Player player) {
        return player.equals(firstPlayer)? secondPlayer : firstPlayer;
    }

    private Player getWinner() {
        return board.getPointsForPlayer(firstPlayer) > board.getPointsForPlayer(secondPlayer) ? firstPlayer : secondPlayer;
    }

    private Player randomizeFirstPlayer() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            firstPlayer.setOrder(Order.FIRST);
            secondPlayer.setOrder(Order.SECOND);
            return firstPlayer;
        } else {
            firstPlayer.setOrder(Order.SECOND);
            secondPlayer.setOrder(Order.FIRST);
            return secondPlayer;
        }
    }

    private Player changePlayer() {
        return firstPlayer.equals(currentPlayer) ? secondPlayer : firstPlayer;
    }

    private boolean isGameFinished() {
        return board.isPlayerSideEmpty(firstPlayer) && board.isPlayerSideEmpty(secondPlayer);
    }
}
