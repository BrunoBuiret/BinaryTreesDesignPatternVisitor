package arbrebinaire;

/**
 * @author Laëtitia Matignon
 * @version 1.0
 */
public abstract class OperateurBinaire extends OperateurUnaire {
    /**
     * A reference to the right child node.
     */
    private Noeud opD;

    /**
     * Creates a new binary operator.
     * 
     * @param s The operator' representation.
     * @param ng A reference to the left child node.
     * @param nd A reference to the right child node.
     */
    public OperateurBinaire(String s, Noeud ng, Noeud nd) {
        super(s, ng);
        this.opD = nd;
    }
    
    /**
     * Gets the right child node's reference.
     * 
     * @return The reference to the right child node.
     */
    public Noeud getOpD() {
        return this.opD;
    }
}
