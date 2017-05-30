package co.simulab.domain.model.random.generator;


import co.simulab.domain.model.random.RandomNumberSet;

import java.util.LinkedHashSet;

/**
 * Created by DiazHerrera on 30/04/2017.
 */
public class RectangularNumbersGenerator {

    public static RandomNumberSet generar(int unaSemilla, int unMultiplicador, int unaConstanteAditiva, int unModulo) {
        int xi = unaSemilla;
        int a = unMultiplicador;
        int c = unaConstanteAditiva;
        int m = unModulo;
        LinkedHashSet<Float> numeros = new LinkedHashSet<>();

        for(int i = 0; i <= m; i++){
            xi = ((a*xi + c) % m);
            float numero = ((float)xi / (float)m);
            if(!numeros.add(new Float(numero)))
                break;
        }

        return new RandomNumberSet(xi, a, c, m, numeros);

    }
}

