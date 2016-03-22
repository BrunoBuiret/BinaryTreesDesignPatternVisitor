package arbrebinaire;

/**
 * @author Laëtitia Matignon
 * @version 1.0
 */
public abstract class OperateurUnaire implements Noeud {
    /**
     * The operator's representation.
     */
    private String op;
    
    /**
     * A reference to the child node.
     */
    private Noeud opG;

    /**
     * Creates a new unary operator.
     * 
     * @param s The operator's representation.
     * @param n A reference to the child node.
     */
    public OperateurUnaire(String s, Noeud n) {
        this.op = s;
        this.opG = n;
    }

    /**
     * Gets the operator's representation.
     * 
     * @return the operator's representation.
     */
    public String getOp() {
        return this.op;
    }

    /**
     * Gets a reference to the child node.
     * 
     * @return A reference to the child node.
     */
    public Noeud getOpG() {
        return this.opG;
    }
}
