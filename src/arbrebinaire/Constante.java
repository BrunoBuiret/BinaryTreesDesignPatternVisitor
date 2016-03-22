package arbrebinaire;

/**
 * @author Laëtitia Matignon
 * @version 2.0
 * @since 1.0
 */
public class Constante implements Noeud {
    /**
     * The constant's value.
     */
    private int valeur;

    /**
     * Creates a new constant node.
     * 
     * @param v The constant's value.
     * @since 1.0
     */
    public Constante(int v) {
        this.valeur = v;
    }

    /**
     * Gets the constant's value.
     * 
     * @return The constant's value.
     * @since 1.0
     */
    public int getValeur() {
        return this.valeur;
    }

    /**
     * Accepts a visitor for the current node.
     * 
     * @param visitor A reference to the visitor.
     * @since 2.0
     */
    @Override
    public void accept(ArithmeticalExpressionVisitorInterface visitor) {
        visitor.visitConstantNode(this);
    }
}
