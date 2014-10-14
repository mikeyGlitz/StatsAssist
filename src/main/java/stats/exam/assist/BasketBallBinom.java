/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stats.exam.assist;

import java.util.ArrayList;
import org.apache.commons.math3.util.CombinatoricsUtils;

/**
 * Calculates the probability that more than a basketball player can make more than
 * 22 free-throws.
 * <p>
 * This class models a statistics question in which there is a given basketball
 * player making free throws. There is a total of 25 throws and the player has
 * a 90% chance of making a single free-throw. What is the probability that the player
 * can make more than 22 free throws?
 * </p>
 * <p>
 * To solve this problem, the binomial probability distribution is used.
 * </p>
 * @author Michael Glitzos
 */
public class BasketBallBinom {
    /**
     * Main method. This is the application's primary entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        //Declare variables for the probability distribution formula
        double p = 0.90;
        int n = 25;
        
        ArrayList<Double> calculatedDistributions = new ArrayList<>();
        for(int i = 23; i <= 25; i++){
            double combintion = CombinationHelper.calculateCombination(n, i);
            double distribution = calculateBernoulliDistribution(p, n, i);
            
            double binomialDistribution = combintion * distribution;
            System.out.println("Binomial Distribution, p(" + i + ") = " + 
                    binomialDistribution);
            
            calculatedDistributions.add(binomialDistribution);
        }
        
        double probabilityGreater22 = 0.0;
        for(double distribution : calculatedDistributions){
            probabilityGreater22 += distribution;
        }
        
        System.out.println("Probability that p(y > 22) = " + probabilityGreater22);
    }
    
    /**
     * Calculates the Bernoulli Distribution for the given variables.
     * @param p
     * @param n
     * @param y
     * @return the Bernoulli Distribution for the given variables.
     */
    private static double calculateBernoulliDistribution(double p, int n, int y){
        double q = 1.0 - p;
        
        double pRaisedY = Math.pow(p, y);
        double qRaisedNMinusY = Math.pow(q, n - y);
        return pRaisedY * qRaisedNMinusY;
    }
}
