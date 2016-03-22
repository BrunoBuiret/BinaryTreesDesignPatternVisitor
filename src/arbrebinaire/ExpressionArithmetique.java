package arbrebinaire;

/**
 * @author Laëtitia Matignon
 * @version 2.0
 * @since 1.0
 */
public class ExpressionArithmetique
{
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
    public ExpressionArithmetique(Noeud racine)
    {
        this.racine = racine;
    }

    /**
     * Gets the expression's root node.
     *
     * @return The expression's root node.
     * @since 1.0
     */
    public Noeud getRacine()
    {
        return racine;
    }
    
    /**
     * Prints a post order visit of the tree.
     *
     * @version 2.0
     * @since 1.0
     */
    public void afficherPostFixe()
    {
        System.out.print("Parcours postfixe : ");

        if(null != this.racine)
        {
            // Visit the tree
            PostOrderBuilderVisitor visitor = new PostOrderBuilderVisitor();
            this.racine.accept(visitor);

            // Then, print the result
            System.out.println(visitor.getVisit());
        }
        else
        {
            System.out.println();
        }
    }

    /**
     * Prints a in order visit of the tree.
     *
     * @version 2.0
     * @since 1.0
     */
    public void afficherInFixe()
    {
        System.out.print("Parcours infixe : ");

        if(null != this.racine)
        {
            // Visit the tree
            InOrderBuilderVisitor visitor = new InOrderBuilderVisitor();
            this.racine.accept(visitor);

            // Then, print the result
            System.out.println(visitor.getVisit());
        }
        else
        {
            System.out.println();
        }
    }

    /**
     * Computes the arithmetical expression.
     *
     * @return The expression's value.
     * @throws IllegalArgumentException If the arithmetical expression doesn't have a root.
     * @version 2.0
     * @since 1.0
     */
    public int calculerValeur()
    throws IllegalArgumentException
    {
        if(null != this.racine)
        {
            // Visit the tree
            ComputeVisitor visitor = new ComputeVisitor();
            this.racine.accept(visitor);

            // Then, print the result
            return visitor.getValue(this.racine);
        }
        else
        {
            throw new IllegalArgumentException("This arithmetical expression has no root.");
        }
    }

    /**
     * Computes the arithmetical expression's tree's height.
     *
     * @return The arithmetical expression's tree's height.
     * @version 2.0
     * @since 1.0
     */
    public int calculerHauteur()
    {
        if(null != this.racine)
        {
            // Visit the tree
            HeightVisitor visitor = new HeightVisitor();
            this.racine.accept(visitor);

            // Then, print the result
            return visitor.getHeight();
        }
        else
        {
            return 0;
        }
    }
}
