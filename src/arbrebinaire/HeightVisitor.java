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
public class HeightVisitor implements ArithmeticalExpressionVisitorInterface
{
    /**
     * The current computed height.
     */
    protected int height;
    
    /**
     * A map memorizing the height of each node.
     */
    protected Map<Noeud, Integer> heightsMap;
    
    /**
     * Creates a new height visitor which will compute how high the binary tree
     * representing the arithmetical expression is.
     */
    public HeightVisitor()
    {
        this.height = 0;
        this.heightsMap = new HashMap<>();
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
            this.heightsMap.put(node, 1);
            
            // Update actual height
            this.updateHeight(node);
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
                this.heightsMap.put(node, 1 + this.heightsMap.get(childNode));
            }
            else
            {
                this.heightsMap.put(node, 1);
            }
            
            // Update actual height
            this.updateHeight(node);
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
                
                if(this.heightsMap.get(leftChildNode) > this.heightsMap.get(rightChildNode))
                {
                    this.heightsMap.put(node, 1 + this.heightsMap.get(leftChildNode));
                }
                else
                {
                    this.heightsMap.put(node, 1 + this.heightsMap.get(rightChildNode));
                }
            }
            else if(null != leftChildNode && null == rightChildNode)
            {
                this.heightsMap.put(node, 1 + this.heightsMap.get(leftChildNode));
            }
            else if(null == leftChildNode && null != rightChildNode)
            {
                this.heightsMap.put(node, 1 + this.heightsMap.get(rightChildNode));
            }
            else
            {
                this.heightsMap.put(node, 1);
            }
            
            // Update actual height
            this.updateHeight(node);
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
                
                if(this.heightsMap.get(leftChildNode) > this.heightsMap.get(rightChildNode))
                {
                    this.heightsMap.put(node, 1 + this.heightsMap.get(leftChildNode));
                }
                else
                {
                    this.heightsMap.put(node, 1 + this.heightsMap.get(rightChildNode));
                }
            }
            else if(null != leftChildNode && null == rightChildNode)
            {
                this.heightsMap.put(node, 1 + this.heightsMap.get(leftChildNode));
            }
            else if(null == leftChildNode && null != rightChildNode)
            {
                this.heightsMap.put(node, 1 + this.heightsMap.get(rightChildNode));
            }
            else
            {
                this.heightsMap.put(node, 1);
            }
            
            // Update actual height
            this.updateHeight(node);
        }
    }
    
    /**
     * Updates the current height according to the current node.
     * 
     * @param node The currently visited node.
     */
    protected void updateHeight(Noeud node)
    {
        if(node != null)
        {
            int currentHeight = this.heightsMap.get(node);
            
            if(this.height < currentHeight)
            {
                this.height = currentHeight;
            }
        }
    }
    
    /**
     * Gets the current computed height.
     * 
     * @return The current computed height.
     */
    public int getHeight()
    {
        return this.height;
    }
    
    /**
     * Resets the height for a new visit.
     */
    public void reset()
    {
        this.height = 0;
        this.heightsMap.clear();
    }
}
