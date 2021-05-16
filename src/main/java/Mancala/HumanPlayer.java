package Mancala;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {
    @Override
    public int chooseMove(Board board, Player otherPlayer) {
        ArrayList<Integer> choices = board.getChoicesForPlayer(this);
        System.out.println("Make a move. Those are your choices: " + choices);
        Scanner in = new Scanner(System.in);
        Integer move = Integer.valueOf(in.nextLine());
        while (!choices.contains(move)) {
            System.out.println("Move can't be played. Chose a correct one: " + choices);
            move = Integer.valueOf(in.nextLine());
        }
        return move;
    }
}
