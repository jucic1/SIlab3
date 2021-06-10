package Mancala;

import java.util.ArrayList;

public class Node {
    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;
    private int chosenValue;
    private ArrayList<Node> children;

    Node(Board board, Player firstPlayer, Player secondPlayer, int chosenValue) {
        this.board = board;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.chosenValue = chosenValue;
        this.children = new ArrayList<Node>();
    }

    public void buildDecisionTree(int depth, Node currentNode) {
        if (depth == 0) {
            //
        }
        ArrayList<Integer> choices = board.getChoicesForPlayer(currentNode.firstPlayer);
        for (Integer choice : choices) {
            Board tempBoard = new Board(currentNode.board);
            boolean samePlayer = tempBoard.moveRocks(currentNode.firstPlayer, choice); //if true dont change player, else change
            Player nextPlayer = samePlayer ? currentNode.firstPlayer : currentNode.secondPlayer;
            Player nextOponent = samePlayer ? currentNode.secondPlayer : currentNode.firstPlayer;
            Node child = new Node(tempBoard, nextPlayer, nextOponent, choice);
            currentNode.children.add(child);
            int newDepth = samePlayer ? depth : depth - 1;
            currentNode.buildDecisionTree(newDepth, child);
        }
    }
}