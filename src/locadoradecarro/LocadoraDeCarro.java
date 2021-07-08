
package locadoradecarro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import modelo.entidade.AluguelCarro;
import modelo.entidade.Veiculo;
import modelo.servico.ServicoAluguel;
import modelo.servico.TaxaServicoBrasil;

/**
 * @author Adriano
 */
public class LocadoraDeCarro {

    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:ss");
        
        System.out.println("INSIRA OS DADOS DO ALUGUÉL");
        System.out.println("  ");
        System.out.print("Modelo do Carro: ");
        String modeloCarro = sc.nextLine();
        System.out.print("Entrada (dd/mm/aaaa hh:mm): ");
        Date inicio = sdf.parse(sc.nextLine());
        System.out.print("Saida (dd/mm/aaaa HH:mm): ");
        Date fim = sdf.parse(sc.nextLine());
        
        AluguelCarro al = new AluguelCarro(inicio, fim, new Veiculo(modeloCarro));
        
        System.out.print("Inrira o preço por hora: ");
        double precoPorHora = sc.nextDouble();
        System.out.print("Insira o preço por dia: ");
        double precoPorDia = sc.nextDouble();
        
        ServicoAluguel servicoAluguel = new ServicoAluguel(precoPorDia, precoPorHora, new TaxaServicoBrasil());
        
        servicoAluguel.processoFatura(al);
        System.out.println("  ");
        System.out.println("FATURA: ");
        System.out.println("  ");
        System.out.println("Pagamento Basico: " + String.format("%.2f",al.getFatura().getPagamentoBasico()));
        System.out.println("Taxa: " + String.format("%.2f", al.getFatura().getTaxa()));
        System.out.println("Pagamento Total: " + String.format("%.2f", al.getFatura().getPagamentoToral()));
        
        
        sc.close();
    }
    
}
