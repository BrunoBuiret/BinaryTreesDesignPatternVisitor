package arbrebinaire;

/**
 * @author Laëtitia Matignon
 * @version 2.0
 * @since 1.0
 */
public class Multiplication extends OperateurBinaire {
    /**
     * Creates a new multiplication node.
     * 
     * @param ng A reference to the left child node.
     * @param nd A reference to the right child node.
     * @since 1.0
     */
    public Multiplication(Noeud ng, Noeud nd) {
        super("*", ng, nd);
    }

    /**
     * Accepts a visitor for the current node.
     * 
     * @param visitor A reference to the visitor.
     * @since 2.0
     */
    @Override
    public void accept(ArithmeticalExpressionVisitorInterface visitor) {
        visitor.visitMultiplicationOperatorNode(this);
    }
}
