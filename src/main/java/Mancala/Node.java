package Mancala;

public class Node {
    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;

    public Node(Board board, Player firstPlayer, Player secondPlayer) {
        this.board = board;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void buildDecisionTree(int depth, Node root) {


    }
}


//        for choice in get_player_choices(current_node.player1, current_node.board):
//                tmp_board = deepcopy(current_node.board)
//                another_turn = move_rocks(current_node.player1, tmp_board, choice)
//                child = Node(tmp_board, current_node.player1 if another_turn else current_node.player2,
//                current_node.player2 if another_turn else current_node.player1, choice)
//                current_node.children.append(child)
//                current_node.build_decision_tree(depth - 1 if not another_turn else depth, child)
