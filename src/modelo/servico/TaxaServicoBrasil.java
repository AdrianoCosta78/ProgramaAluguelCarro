
package modelo.servico;

/**
 * @author Adriano
 */
public class TaxaServicoBrasil  {
    
    public double taxa(double valor){
        if(valor <= 100.0){
            return valor * 0.2;
        }
        else{
            return valor * 0.15;
        }
    }
}
