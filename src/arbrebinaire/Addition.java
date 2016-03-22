package arbrebinaire;

/**
 * @author Laëtitia Matignon
 * @version 2.0
 * @since 1.0
 */
public class Addition extends OperateurBinaire {
    /**
     * Creates a new addition node.
     * 
     * @param ng A reference to the left child node.
     * @param nd A reference to the right child node.
     * @since 1.0
     */
    public Addition(Noeud ng, Noeud nd) {
        super("+", ng, nd);
    }

    /**
     * Accepts a visitor for the current node.
     * 
     * @param visitor A reference to the visitor.
     * @since 2.0
     */
    @Override
    public void accept(ArithmeticalExpressionVisitorInterface visitor) {
        visitor.visitAdditionOperatorNode(this);
    }
}
