package co.simulab.domain.model.random;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by JotaUribe on 30/04/2017.
 */
public class RandomNumberSet {

    private int semilla;
    private int multiplicador;
    private int constanteAditiva;
    private int modulo;
    private Set<Float> numeros;

    public RandomNumberSet(int unaSemilla,
                           int unMultiplicador,
                           int unaConstanteAditiva,
                           int unModulo,
                           Set<Float> numeros){
        semilla = unaSemilla;
        multiplicador = unMultiplicador;
        constanteAditiva = unaConstanteAditiva;
        modulo = unModulo;
        this.numeros = numeros;
    }

    public int getSemilla() {
        return semilla;
    }

    public void setSemilla(int semilla) {
        this.semilla = semilla;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public int getConstanteAditiva() {
        return constanteAditiva;
    }

    public void setConstanteAditiva(int constanteAditiva) {
        this.constanteAditiva = constanteAditiva;
    }

    public int getModulo() {
        return modulo;
    }

    public void setModulo(int modulo) {
        this.modulo = modulo;
    }

    public Set<Float> getNumeros() {
        return numeros;
    }

    public void setNumeros(Set<Float> numeros) {
        this.numeros = numeros;
    }

    public int size(){
        return numeros.size();
    }

    public double media(){
        double sumatoria = 0;
        for (Float f :
                numeros) {
            sumatoria = sumatoria + f;
        }
        return sumatoria/(float)size();
    }

    public int frecuencia(double lowerLimit, double upperLimit){
        int frecuencia = 0;
        for (Float f :
                numeros) {
            if (f >= lowerLimit && f < upperLimit)
                frecuencia++;
        }
        return frecuencia;
    }

    public double[] toDoubleVector(){
        double[] data = new double[numeros.size()];
        Iterator<Float> iterator = numeros.iterator();
        for(int i = 0; iterator.hasNext(); i++){
            data[i] = iterator.next();
        }
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RandomNumberSet that = (RandomNumberSet) o;

        if (semilla != that.semilla) return false;
        if (multiplicador != that.multiplicador) return false;
        if (constanteAditiva != that.constanteAditiva) return false;
        if (modulo != that.modulo) return false;
        return numeros != null ? numeros.equals(that.numeros) : that.numeros == null;
    }

    @Override
    public int hashCode() {
        int result = semilla;
        result = 31 * result + multiplicador;
        result = 31 * result + constanteAditiva;
        result = 31 * result + modulo;
        result = 31 * result + (numeros != null ? numeros.hashCode() : 0);
        return result;
    }
}