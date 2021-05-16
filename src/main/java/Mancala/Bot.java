package Mancala;

import java.util.ArrayList;

public class Bot extends Player {
    @Override
    public int chooseMove(Board board, Player otherPlayer) {
        ArrayList<Integer> choices = board.getChoicesForPlayer(this);

        Node root = new Node(board, this, otherPlayer);
        root.buildDecisionTree(4, root);


        int move = 0;
        return move;
    }
}
