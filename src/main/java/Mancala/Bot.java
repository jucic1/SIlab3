package Mancala;

public class Bot extends Player {
    @Override
    public int chooseMove(Board board, Player otherPlayer) {
        Node root = new Node(board, this, otherPlayer, -1);
        root.buildDecisionTree(4, root);
        //min_max

        int move = 0;
        return move;
    }
}
