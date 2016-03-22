package arbrebinaire;

/**
 * @author Bruno Buiret <bruno.buiret@etu.univ-lyon1.fr>
 * @version 2.0
 * @since 2.0
 */
public class InOrderBuilderVisitor implements ArithmeticalExpressionVisitorInterface
{
    /**
     * A string builder to build the post order visit.
     */
    protected StringBuilder visitBuilder;

    /**
     * Creates a new in order visitor which will build a string representing the visit.
     */
    public InOrderBuilderVisitor()
    {
        this.visitBuilder = new StringBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitConstantNode(Constante node)
    {
        if(null != node)
        {
            // Only the node itself
            this.visitBuilder.append(node.getValeur()).append(" ");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitNegationOperatorNode(Negation node)
    {
        if(null != node)
        {
            // First, the child node
            this.visitBuilder.append(node.getOp()).append("(");
            
            // Then, the node itself
            Noeud childNode = node.getOpG();

            if(null != childNode)
            {
                childNode.accept(this);
                
                // Get rid of a possible space at the end
                if(this.visitBuilder.charAt(this.visitBuilder.length() - 1) == ' ')
                {
                    this.visitBuilder.deleteCharAt(this.visitBuilder.length() - 1);
                }
            }
            
            // Finally, wrap everything
            this.visitBuilder.append(")");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitAdditionOperatorNode(Addition node)
    {
        if(null != node)
        {
            // First, the left child node
            Noeud leftChildNode = node.getOpG();

            if(null != leftChildNode)
            {
                leftChildNode.accept(this);
            }

            // Then, the node itself
            this.visitBuilder.append(node.getOp()).append(" ");

            // Finally, the right child node
            Noeud rightChildNode = node.getOpD();

            if(null != rightChildNode)
            {
                rightChildNode.accept(this);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitMultiplicationOperatorNode(Multiplication node)
    {
        if(null != node)
        {
            // First, the left child node
            Noeud leftChildNode = node.getOpG();

            if(null != leftChildNode)
            {
                leftChildNode.accept(this);
            }

            // Then, the node itself
            this.visitBuilder.append(node.getOp()).append(" ");

            // Finally, the right child node
            Noeud rightChildNode = node.getOpD();

            if(null != rightChildNode)
            {
                rightChildNode.accept(this);
            }
        }
    }

    /**
     * Gets the string resulting from a post order visit.
     *
     * @return The post order visit string.
     */
    public String getVisit()
    {
        return this.visitBuilder.toString().trim();
    }

    /**
     * Resets the builder for a new visit.
     */
    public void reset()
    {
        this.visitBuilder = new StringBuilder();
    }
}
