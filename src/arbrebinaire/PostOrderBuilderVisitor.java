package arbrebinaire;

/**
 * @author Bruno Buiret <bruno.buiret@etu.univ-lyon1.fr>
 * @version 2.0
 * @since 2.0
 */
public class PostOrderBuilderVisitor implements ArithmeticalExpressionVisitorInterface
{
    /**
     * A string builder to build the post order visit.
     */
    protected StringBuilder visitBuilder;
    
    /**
     * Creates a new post order visitor which will build a string representing the visit.
     */
    public PostOrderBuilderVisitor()
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
            Noeud childNode = node.getOpG();

            if(null != childNode)
            {
                childNode.accept(this);
            }

            // Then, the node itself
            this.visitBuilder.append(node.getOp()).append(" ");
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

            // Then, the right child node
            Noeud rightChildNode = node.getOpD();

            if(null != rightChildNode)
            {
                rightChildNode.accept(this);
            }            

            // Finally, the node itself
            this.visitBuilder.append(node.getOp()).append(" ");
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

            // Then, the right child node
            Noeud rightChildNode = node.getOpD();

            if(null != rightChildNode)
            {
                rightChildNode.accept(this);
            }            

            // Finally, the node itself
            this.visitBuilder.append(node.getOp()).append(" ");
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
