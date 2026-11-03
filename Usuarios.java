package com.mycompany.rifa;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {
    ArrayList<Rifa> usuarios = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    public void menu(){
        int opcao;
        boolean ativo = true;
        while(ativo){
            System.out.println("---MENU RIFA---");
            System.out.println("1: Cadastrar Conta | 2: Adicionar Saldo | 3: Consultar Conta | 4: Comprar Rifa | 5: Vender a última rifa comprada | 6: Consultar número de cotas disponíveis | 7: Dia do Sorteio | 8: Sair do programa");
            opcao = sc.nextInt();
            sc.nextLine();
            switch(opcao){
                case 1:
                    System.out.println("Digite seu nome: ");
                    String nome = sc.nextLine();
                    System.out.println("Informe seu cpf: ");
                    String cpf = sc.nextLine();
                    usuarios.add(new Rifa(nome, cpf));
                    System.out.println("Você acabou de registrar sua conta " + nome + " agora deposite no mínimo 5 reais pra comprar 1 cota");
                    break;
                case 2:
                    System.out.println("Digite seu nome: ");
                    String nomeProcurado = sc.nextLine();
                    for(Rifa r : usuarios){
                        if(r.getNome().equalsIgnoreCase(nomeProcurado)){
                            System.out.println("Coloque a quantidade de saldo que você quer adicionar entre R$0.01 e R$15.00");
                            double saldo = sc.nextDouble();
                            r.adicionarSaldo(saldo);
                        }
                        else{
                            System.out.println("Nome não encontrado no sistema");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite seu nome: ");
                    nomeProcurado = sc.nextLine();
                    for(Rifa r : usuarios){
                        if(r.getNome().equalsIgnoreCase(nomeProcurado)){
                            System.out.println("Nome: " + r.getNome() + " cpf " + r.getCpf() + " Saldo: R$" + r.getSaldo());
                        }
                        else{
                            System.out.println("Nome não encontrado no sistema");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Digite seu nome: ");
                    nomeProcurado = sc.nextLine();
                    for(Rifa r : usuarios){
                        if(r.getNome().equalsIgnoreCase(nomeProcurado)){
                            System.out.println("Escolha a quantidade, lembrando que só é possível comprar 3 rifas por pessoa: ");
                            int qtd = sc.nextInt();
                            r.comprar(qtd);
                        }
                        else{
                            System.out.println("Nome não encontrado no sistema");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Digite seu nome: ");
                    nomeProcurado = sc.nextLine();
                    for(Rifa r : usuarios){
                        if(r.getNome().equalsIgnoreCase(nomeProcurado)){
                            r.venderAcaoAtual();
                        }
                        else{
                            System.out.println("Nome não encontrado no sistema");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Digite seu nome: ");
                    nomeProcurado = sc.nextLine();
                    for(Rifa r : usuarios){
                        if(r.getNome().equalsIgnoreCase(nomeProcurado)){
                            System.out.println("O Número de cotas disponíveis é: "+r.getCotasDisponiveis());
                            
                        }
                        else{
                            System.out.println("Nome não encontrado no sistema");
                        }
                    }
                    break;
                case 7:
                    System.out.println("Digite seu nome: ");
                    nomeProcurado = sc.nextLine();
                    for(Rifa r : usuarios){
                        if(r.getNome().equalsIgnoreCase(nomeProcurado)){
                            r.sortearVencedor();
                        }
                        else{
                            System.out.println("Nome não encontrado no sistema, o sorteio só pode ser iniciado após a consulta ser validada");
                        }
                    }
                    break;
                case 8:
                    System.out.println("Saindo...");
                    ativo = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente de novo");
                    break;
            }
        }
    }
    public static void main(String[] args){
        Usuarios usuario = new Usuarios();
        usuario.menu();
    }
}