package arbrebinaire;

/**
 * @author Bruno Buiret <bruno.buiret@etu.univ-lyon1.fr>
 * @version 2.0
 * @since 2.0
 */
public interface ArithmeticalExpressionVisitorInterface {
    /**
     * Evaluates a constant.
     * 
     * @param node The node to visit.
     */
    public void visitConstantNode(Constante node);
    
    /**
     * Evaluates a negation operator.
     * 
     * @param node The node to visit.
     */
    public void visitNegationOperatorNode(Negation node);
    
    /**
     * Evaluates an addition operator.
     * 
     * @param node The node to visit.
     */
    public void visitAdditionOperatorNode(Addition node);
    
    /**
     * Evaluates a multiplication operator.
     * 
     * @param node The node to visit.
     */
    public void visitMultiplicationOperatorNode(Multiplication node);
}
