import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int opcao = 0;

        System.out.println("Seja bem vindo!");

        String nome = getNome(input);
        double saldo = getSaldo(input);
        imprimeUI(nome,saldo);
        
        while (opcao != 4){
            imprimeMenu();
            opcao = getOpcao(input);
            saldo = avaliaOpcao(opcao, saldo, nome, input);
        }
    }

    private static double avaliaOpcao(int opcao, double saldo, String nome, Scanner input) {
        switch (opcao){
            case 1:
                imprimeUI(nome,saldo);
                break;
            case 2:
                saldo = transferirValor(saldo,input);
                break;
            case 3:
                saldo = receberValor(saldo,input);
                break;
            case 4:
                System.out.println("Adeus!");
                break;
            default:
                System.out.println("Opção incorreta!");
                break;

        }
        return saldo;
    }

    private static double receberValor(double saldo, Scanner input) {
        System.out.println("Insira o valor a ser recebido:");
        double valor = input.nextDouble();
        return (saldo + valor) ;
    }

    private static double transferirValor(double saldo, Scanner input) {

        System.out.println("Insira o valor a ser transferido:");
        double valor = input.nextDouble();

        if (saldo >= valor) {
            return saldo - valor;
        } else {
            System.out.println("Saldo insuficiente!");
            return saldo;
        }
    }

    private static int getOpcao(Scanner input){
        System.out.println("Insira a opção:");
        return input.nextInt();
    }

    private static String getNome(Scanner input) {
        System.out.println("Insira seu nome:");
        return input.next();
    }

    private static double getSaldo(Scanner input) {
        System.out.println("Insira Saldo Inicial:");
        return input.nextDouble();
    }

    private static void imprimeUI(String nome, double saldo){
        String ui = """
                ***********************
                Dados iniciais do cliente:
                \s
                Nome: %s
                Tipo conta: Corrente
                Saldo inicial: R$ %.2f
                ***********************
               \s""";
        System.out.println(String.format(ui,nome,saldo));

    }

    private static void imprimeMenu() {
        String menu = """
                ** Digite sua opção **
                1 - Consultar saldo
                2 - Transferir valor
                3 - Receber valor
                4 - Sair
                """;
        System.out.println(menu);
    }

}