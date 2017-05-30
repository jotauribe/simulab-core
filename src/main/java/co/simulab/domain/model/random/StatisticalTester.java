package co.simulab.domain.model.random;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.inference.ChiSquareTest;
import org.apache.commons.math3.stat.inference.KolmogorovSmirnovTest;

/**
 * Created by JotaUribe on 30/04/2017.
 */
public class StatisticalTester {

    private static final double DEFAULT_CONFIDENCE_INTERVAL = 0.95;
    private static final double DEFAULT_NUMBER_OF_INTERVALS = 5;
    private static final NormalDistribution STANDARD_NORMAL_DISTRIBUTION = new NormalDistribution(0 , 1);

    public static boolean averageTest(RandomNumberSet randomNumberSet){

        double media = randomNumberSet.media();
        double N = randomNumberSet.size();
        double Zo = ( (media - 0.5) * Math.sqrt(N) ) / Math.sqrt((float)1/12);
        double confidenceInterval = DEFAULT_CONFIDENCE_INTERVAL;
        double Zb = STANDARD_NORMAL_DISTRIBUTION.inverseCumulativeProbability(confidenceInterval + (1-confidenceInterval)/2);

        if(Math.abs(Zo) < Zb)
            return true;
        return false;
    }

    public static boolean frencuencyTest(RandomNumberSet randomNumberSet){

        double longitudDelIntervalo = 1/DEFAULT_NUMBER_OF_INTERVALS;
        double frecuencaiaEsperada = (double)randomNumberSet.size()/DEFAULT_NUMBER_OF_INTERVALS;
        long[] frecuenciasObservadas = new long[(int)DEFAULT_NUMBER_OF_INTERVALS];
        double[] frecuenciasEsperadas = {frecuencaiaEsperada, frecuencaiaEsperada, frecuencaiaEsperada, frecuencaiaEsperada, frecuencaiaEsperada};

        for (int i = 0;i < DEFAULT_NUMBER_OF_INTERVALS; i++){
            double loweLimit = longitudDelIntervalo*i;
            double upperLimit = loweLimit + longitudDelIntervalo;
            frecuenciasObservadas[i] = randomNumberSet.frecuencia(loweLimit, upperLimit);
        }

        ChiSquareTest chiSquareTest = new ChiSquareTest();
        double resultado = chiSquareTest.chiSquare(frecuenciasEsperadas, frecuenciasObservadas);
        if(resultado < 9.4877)
            return true;
        return false;
    }

    public static boolean kolmogorovSmirnovTest(RandomNumberSet randomNumberSet){

        double[] data = randomNumberSet.toDoubleVector();
        KolmogorovSmirnovTest ksTest = new KolmogorovSmirnovTest();
        double resultado = ksTest.kolmogorovSmirnovStatistic(new NormalDistribution(0, 1), data);
        System.out.print(resultado);

        return false;
    }

}
