package Mancala;

abstract class Player {
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    abstract int chooseMove(Board board, Player otherPlayer);
}
