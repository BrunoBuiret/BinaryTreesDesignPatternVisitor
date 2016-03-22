/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbrebinaire;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruno Buiret <bruno.buiret@etu.univ-lyon1.fr>
 * @version 2.0
 * @since 2.0
 */
public class ComputeVisitor implements ArithmeticalExpressionVisitorInterface
{
    /**
     * A map memorizing the value up to each node.
     */
    protected Map<Noeud, Integer> valuesMap;
    
    /**
     * Creates a new compute visitor which will compute the whole arithmetical expression.
     */
    public ComputeVisitor()
    {
        this.valuesMap = new HashMap<>();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void visitConstantNode(Constante node)
    {
        if(null != node)
        {
            // +1
            this.valuesMap.put(node, node.getValeur());
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
            // 1 + height(child)
            Noeud childNode = node.getOpG();
            
            if(null != childNode)
            {
                childNode.accept(this);
                this.valuesMap.put(node, -this.valuesMap.get(childNode));
            }
            else
            {
                this.valuesMap.put(node, 0);
            }
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
            // 1 + max(height(leftChild) ; height(rightChild))
            Noeud leftChildNode = node.getOpG();
            Noeud rightChildNode = node.getOpD();
            
            if(null != leftChildNode && null != rightChildNode)
            {
                leftChildNode.accept(this);
                rightChildNode.accept(this);
                
                this.valuesMap.put(
                    node,
                    this.valuesMap.get(leftChildNode) + this.valuesMap.get(rightChildNode)
                );
            }
            else if(null != leftChildNode && null == rightChildNode)
            {
                this.valuesMap.put(
                    node,
                    this.valuesMap.get(leftChildNode)
                );
            }
            else if(null == leftChildNode && null != rightChildNode)
            {
                this.valuesMap.put(
                    node,
                    this.valuesMap.get(rightChildNode)
                );
            }
            else
            {
                this.valuesMap.put(node, 0);
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
            // 1 + max(height(leftChild) ; height(rightChild))
            Noeud leftChildNode = node.getOpG();
            Noeud rightChildNode = node.getOpD();
            
            if(null != leftChildNode && null != rightChildNode)
            {
                leftChildNode.accept(this);
                rightChildNode.accept(this);
                
                this.valuesMap.put(
                    node,
                    this.valuesMap.get(leftChildNode) * this.valuesMap.get(rightChildNode)
                );
            }
            else if(null != leftChildNode && null == rightChildNode)
            {
                this.valuesMap.put(
                    node,
                    this.valuesMap.get(leftChildNode)
                );
            }
            else if(null == leftChildNode && null != rightChildNode)
            {
                this.valuesMap.put(
                    node,
                    this.valuesMap.get(rightChildNode)
                );
            }
            else
            {
                this.valuesMap.put(node, 0);
            }
        }
    }
    
    /**
     * Gets the current computed value up to the given node.
     * 
     * @param node The node to get the value from.
     * @return The current computed value for the node.
     * @throws IllegalArgumentException If the node doesn't belong to the visited arithmetical expression.
     */
    public int getValue(Noeud node)
    throws IllegalArgumentException
    {
        if(this.valuesMap.containsKey(node))
        {
            return this.valuesMap.get(node);
        }
        else
        {
            throw new IllegalArgumentException(
                "This node doesn't belong to the visited arithmetical expression."
            );
        }
    }
    
    /**
     * Resets the value for a new visit.
     */
    public void reset()
    {
        this.valuesMap.clear();
    }
}
