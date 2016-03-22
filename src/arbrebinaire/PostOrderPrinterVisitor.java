package arbrebinaire;

/**
 * @author Bruno Buiret <bruno.buiret@etu.univ-lyon1.fr>
 * @version 2.0
 * @since 2.0
 */
public class PostOrderPrinterVisitor implements ArithmeticalExpressionVisitorInterface
{
    /**
     * A string builder to build the post order visit.
     */
    protected StringBuilder printerBuilder;
    
    /**
     * Creates a new post order visitor which will
     */
    public PostOrderPrinterVisitor()
    {
        this.printerBuilder = new StringBuilder();
    }
    
    @Override
    public void visitConstantNode(Constante node) {
        this.printerBuilder.append(node.getValeur()).append(" ");
    }

    @Override
    public void visitNegationOperatorNode(Negation node) {
        this.printerBuilder.append(node.getOp()).append(" ");
    }

    @Override
    public void visitAdditionOperatorNode(Addition node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitMultiplicationOperatorNode(Multiplication node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
