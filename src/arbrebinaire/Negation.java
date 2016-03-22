package arbrebinaire;

/**
 * @author Laëtitia Matignon
 * @version 2.0
 * @since 1.0
 */
public class Negation extends OperateurUnaire {
    /**
     * Creates a new negation node.
     * 
     * @param n A reference to the node to negate.
     * @since 1.0
     */
    public Negation(Noeud n) {
        super("-", n);
    }

    /**
     * Accepts a visitor for the current node.
     * 
     * @param visitor A reference to the visitor.
     * @since 2.0
     */
    @Override
    public void accept(ArithmeticalExpressionVisitorInterface visitor) {
        visitor.visitNegationOperatorNode(this);
    }
}
