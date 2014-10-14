/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stats.exam.assist;

import org.apache.commons.math3.util.CombinatoricsUtils;

/**
 *
 * @author Michael
 */
public class CombinationHelper {

    private CombinationHelper() {
    }

    /**
     *Calculates the combination of n and r
     * @param n
     * @param r
     * @return the combination of n and r
     */
    public static double calculateCombination(int n, int r) {
        double nFactorial = CombinatoricsUtils.factorialDouble(n);
        double rFactorial = CombinatoricsUtils.factorialDouble(r);
        double nMinusRFactorial = CombinatoricsUtils.factorialDouble(n - r);

        return nFactorial / (rFactorial * nMinusRFactorial);
    }
}
