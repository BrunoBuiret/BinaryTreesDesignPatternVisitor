package arbrebinaire;

/**
 * @author Laëtitia Matignon
 * @version 2.0
 * @since 1.0
 */
public class ExpressionArithmetique {
    /**
     * The expression's root node.
     * 
     * @since 1.0
     */
    private Noeud racine;

    /**
     * Creates a new arithmetical expression.
     * 
     * @param racine A reference to the expression's root node.
     * @since 1.0
     */
    public ExpressionArithmetique(Noeud racine) {
        this.racine = racine;
    }

    /**
     * Gets the expression's root node.
     * 
     * @return The expression's root node.
     * @since 1.0
     */
    public Noeud getRacine() {
        return racine;
    }

    /**
     * 
     * @version 2.0
     * @since 1.0
     */
    public void afficherPostFixe() {
        System.out.println("\n postfixe:");
        // TODO
    }

    /**
     * Computes the arithmetical expression.
     * 
     * @return The expression's value.
     * @version 2.0
     * @since 1.0
     */
    public int calculerValeur() {
        // TODO
        return 0;
    }

    /**
     * Computes the arithmetical expression's tree's height.
     * 
     * @return The arithmetical expression's tree's height.
     * @version 2.0
     * @since 1.0
     */
    public int calculerHauteur() {
        // TODO
        return 0;
    }

    /**
     * 
     * @version 2.0
     * @since 1.0
     */
    public void afficherInFixe() {
        System.out.println("\n infixe:");
        // TODO
    }
}
