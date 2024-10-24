package br.com.listacompras.model;

import java.util.Scanner;

public class Menu {

    private int opcao = 1;
    private Scanner input;
    private Cartao cartao;
    private Lista lista;

    public Menu(){
        this.input= new Scanner(System.in);
        this.lista = new Lista();
    }

    private void perguntaLimiteCartao(){
        System.out.println("Digite o limite do cartão:");
        this.cartao = new Cartao(input.nextDouble());
    }

    public void showMenu(){
        perguntaLimiteCartao();

        while (this.opcao != 0){
            inserirItem();
            continueOuPare();
        }
        this.lista.imprimeLista();
        System.out.println(this.cartao);
    }

    private void inserirItem() {
        System.out.println("Digite a descrição da compra:");
        var descricao = input.next();
        System.out.println("Digite o valor da compra:");
        var valor = input.nextDouble();
        if (this.cartao.avaliaSaldo(valor)){
            this.cartao.debita(valor);
            this.lista.adicionaItem(descricao,valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    private void continueOuPare(){
        System.out.println("Digite 0 para sair ou 1 para continuar:");
        opcao = input.nextInt();
        if ( opcao != 0 && opcao != 1){
            System.out.println("Opção Inválida!");
        }
    }
}
