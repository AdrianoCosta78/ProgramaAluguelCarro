
package modelo.servico;

import modelo.entidade.AluguelCarro;
import modelo.entidade.Fatura;

/**
 * @author Adriano
 */
public class ServicoAluguel {
    private Double precoPorDia;
    private Double precoPorHora;
    
    private TaxaServicoBrasil taxaServicoBrasil;

    public ServicoAluguel(Double precoPorDia, Double precoPorHora, TaxaServicoBrasil taxaServicoBrasil) {
        super();
        this.precoPorDia = precoPorDia;
        this.precoPorHora = precoPorHora;
        this.taxaServicoBrasil = taxaServicoBrasil;
    }
    
    public void processoFatura(AluguelCarro aluguelCarro){
        long t1 = aluguelCarro.getInicio().getTime();
        long t2 = aluguelCarro.getFim().getTime();
        double horas = (double)(t2-t1)/1000/60/60;
        
        double pagamentoBasico;
        
        if (horas<=12.0){
            pagamentoBasico = Math.ceil(horas)* precoPorHora;
        }
        else{
            pagamentoBasico = Math.ceil(horas/24)* precoPorDia;
        }
        
        double taxa = taxaServicoBrasil.taxa(pagamentoBasico);
        
        aluguelCarro.setFatura(new Fatura(pagamentoBasico, taxa));
    }
    
    
}
