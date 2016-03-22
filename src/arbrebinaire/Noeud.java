package arbrebinaire;

/**
 * @author Laëtitia Matignon
 * @version 2.0
 * @since 1.0
 */
public interface Noeud {
    /**
     * Applies a visitor to the current node.
     * 
     * @param visitor A reference to the visitor.
     * @since 2.0
     */
    public void accept(ArithmeticalExpressionVisitorInterface visitor);
}
