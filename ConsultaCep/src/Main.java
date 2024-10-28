import br.com.consultaCep.services.ConsultaAPI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Digite o CEP:");
        var input = new Scanner(System.in);
        var cep = input.next();
        var service = new ConsultaAPI();
        try{
            var endereco = service.consultaCep(cep);
            System.out.println(endereco);
            System.out.println("Gravando JSON");
            service.salvaJson(endereco);
        } catch (Exception e){
            System.out.println(e);
        }


    }
}