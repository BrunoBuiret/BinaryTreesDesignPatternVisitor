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
            this.visitBuilder.append(node.getValeur());
        }
        else
        {
            this.visitBuilder.append("?");
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
            // First, open wrapper
            this.visitBuilder.append(node.getOp()).append("(");
            
            // Then, treat the child node
            Noeud childNode = node.getOpG();

            if(null != childNode)
            {
                childNode.accept(this);
            }
            else
            {
                this.visitBuilder.append("?");
            }
            
            // Finally, wrap everything
            this.visitBuilder.append(")");
        }
        else
        {
            this.visitBuilder.append("?");
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
            else
            {
                this.visitBuilder.append("?");
            }

            // Then, the node itself
            this.visitBuilder.append(" ").append(node.getOp()).append(" ");

            // Finally, the right child node
            Noeud rightChildNode = node.getOpD();

            if(null != rightChildNode)
            {
                boolean needsPriority = rightChildNode instanceof Negation;
                
                if(needsPriority)
                {
                    this.visitBuilder.append("(");
                }
                
                rightChildNode.accept(this);
                
                if(needsPriority)
                {
                    this.visitBuilder.append(")");
                }
            }
            else
            {
                this.visitBuilder.append("?");
            }
        }
        else
        {
            this.visitBuilder.append("?");
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
                boolean needsPriority = leftChildNode instanceof Addition;
                
                if(needsPriority)
                {
                    this.visitBuilder.append("(");
                }
                
                leftChildNode.accept(this);
                
                if(needsPriority)
                {
                    this.visitBuilder.append(")");
                }
            }
            else
            {
                this.visitBuilder.append("?");
            }

            // Then, the node itself
            this.visitBuilder.append(" ").append(node.getOp()).append(" ");

            // Finally, the right child node
            Noeud rightChildNode = node.getOpD();

            if(null != rightChildNode)
            {
                boolean needsPriority = rightChildNode instanceof Addition || rightChildNode instanceof Negation;
                
                if(needsPriority)
                {
                    this.visitBuilder.append("(");
                }
                
                rightChildNode.accept(this);
                
                if(needsPriority)
                {
                    this.visitBuilder.append(")");
                }
            }
            else
            {
                this.visitBuilder.append("?");
            }
        }
        else
        {
            this.visitBuilder.append("?");
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
