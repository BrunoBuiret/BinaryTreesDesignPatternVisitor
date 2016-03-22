package test;

import arbrebinaire.Addition;
import arbrebinaire.Constante;
import arbrebinaire.ExpressionArithmetique;
import arbrebinaire.Multiplication;
import arbrebinaire.Negation;

public abstract class TestArbreBinaire
{
    /**
     * Main entry point.
     * 
     * @param args The command line arguments.
     */
    public static void main(String[] args)
    {
        // Faire 1 + 2 * 3 + (-4) = 3
        Addition premierCalcul = new Addition(
            new Addition(
                new Constante(1),
                new Multiplication(
                    new Constante(2),
                    new Constante(3)
                )
            ),
            new Negation(new Constante(4))
        );
        ExpressionArithmetique premiereExpression = new ExpressionArithmetique(premierCalcul);

        premiereExpression.afficherInFixe();
        System.out.println("Calcul valeur : " + premiereExpression.calculerValeur());
        System.out.println("Calcul hauteur : " + premiereExpression.calculerHauteur());
        premiereExpression.afficherPostFixe();
        
        System.out.println();

        // Faire (1 + 3) * (-(3 * 4)) = -48
        Multiplication deuxiemeCalcul = new Multiplication(
            new Negation(
                new Multiplication(
                    new Constante(3),
                    new Constante(4)
                )
            ),
            new Addition(
                new Constante(1),
                new Constante(3)
            )
        );
        
        ExpressionArithmetique deuxiemeExpression = new ExpressionArithmetique(deuxiemeCalcul);

        deuxiemeExpression.afficherInFixe();
        System.out.println("Calcul valeur : " + deuxiemeExpression.calculerValeur());
        System.out.println("Calcul hauteur : " + deuxiemeExpression.calculerHauteur());
        deuxiemeExpression.afficherPostFixe();
    }
}
