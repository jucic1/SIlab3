package Mancala;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {
    @Override
    public int chooseMove(Board board, Player otherPlayer) {
        ArrayList<Integer> choices = board.getChoicesForPlayer(this);
        ArrayList<Integer> choicesForHuman = translateChoicesForHuman(choices);
        System.out.println("Make a move. Those are your choices: " + choicesForHuman);
        Scanner in = new Scanner(System.in);
        Integer move = Integer.valueOf(in.nextLine());
        while (!choicesForHuman.contains(move)) {
            System.out.println("Move can't be played. Chose a correct one: " + choicesForHuman);
            move = Integer.valueOf(in.nextLine());
        }
        return translateHumanMoveToIndex(move);
    }

    private ArrayList<Integer> translateChoicesForHuman(ArrayList<Integer> choices) {
        ArrayList<Integer> choicesForHuman = new ArrayList<Integer>();
        for(Integer choice : choices) {
            if(choice >= 7) {
                choicesForHuman.add(choice);
            }else {
                choicesForHuman.add(0, translateHumanMoveToIndex(choice));
            }
        }
        return choicesForHuman;
    }

    private int translateHumanMoveToIndex(int move) {
        if (move <= 6) {
            return Math.abs(move - 6);
        } else {
            return move;
        }
    }
}
