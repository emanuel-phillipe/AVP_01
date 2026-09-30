package com.emanuel.provapm;

import java.util.ArrayList;
import java.util.Scanner;

public class ProvaPM {
    
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        ArrayList<Reserva> reservas = new ArrayList<>();
        ArrayList<Salao> saloes = new ArrayList<>();
        ArrayList<Organizador> organizadores = new ArrayList<>();
        
        saloes.add(new Salao(101, 20, "Corredor C", "DISCOTECA"));
        saloes.add(new Salao(102, 30, "Corredor B", "DISCOTECA"));
        saloes.add(new Salao(103, 10, "Corredor A", "REUNIÃO"));
        
        organizadores.add(new Organizador("Eduardo Ramos", "345.654.678-09", "(31) 96785-4656", "GESTÃO"));
        organizadores.add(new Organizador("Cleiton Ribeiro", "678.444.345-19", "(31) 95763-5466", "GESTÃO"));
        organizadores.add(new Organizador("Glinda Martins", "876.678.098-23", "(31) 95689-0986", "GESTÃO"));
        
        boolean funcionar = true;
        while(funcionar){
            printMenu();
            
            System.out.print("Selecione a opção desejada: ");
            switch (input.nextInt()) {
                case 1:
                    reservas.add(makeNewReserva());
                    break;
                case 2:
                    
                    System.out.println("ANEXAR ORGANIZAR A SALÃO\n");
                    
                    System.out.println("Organizadores: \n");
                    
                    for(Organizador organizador : organizadores){
                        System.out.println(organizadores.indexOf(organizador) + " - " + organizador.toString());
                    }
                    
                    System.out.println("Salões Disponíveis: \n");
                    for(Salao salao : saloes){
                        if(salao.getOrganizador() == null){
                            System.out.println(saloes.indexOf(salao) + " - " + salao.toString());
                        }
                    }
                    
                    System.out.print("Digite o número do organizador: ");
                    Organizador organizadorEscolhido = organizadores.get(input.nextInt());
                    
                    System.out.print("Digite o número do salão: ");
                    saloes.get(input.nextInt()).setOrganizador(organizadorEscolhido);
                    
                    break;
                case 3:
                    
                    System.out.println("ATRIBUIR RESERVA A SALÃO\n");
                    
                    System.out.println("Reservas Disponíveis: \n");
                    for(Reserva reserva : reservas){
                        if(reserva.getStatus().equals("SOLICITADA")){
                            System.out.println(reservas.indexOf(reserva) + " - " + reserva.toString());
                        }
                    }
                    
                    System.out.println("Salões Disponíveis: \n");
                    for(Salao salao : saloes){
                        System.out.println(saloes.indexOf(salao) + " - " + salao.toString());
                    }
                    
                    System.out.print("Digite o número da reserva: ");
                    Reserva reservaEscolhida = reservas.get(input.nextInt());
                    
                    System.out.print("Digite o número do salão: ");
                    Salao salaoEscolhido = saloes.get(input.nextInt());
                    
                    for(Reserva reserva : reservas){
                        if(reserva.getSalao() != null){
                            if(reserva.getStatus().equals("SOLICITADA") && reserva.getSalao().equals(salaoEscolhido)){
                                if(reserva.getData().equals(reservaEscolhida.getData()) &&
                                        reserva.getHorario().equals(reservaEscolhida.getHorario())){
                                    System.out.println("O salão já possui uma reserva com a mesma data e horário.");
                                    return;
                                }
                        }
                        }
                    }
                    
                    reservas.get(reservas.indexOf(reservaEscolhida)).setStatus("CONFIRMADA");
                    reservas.get(reservas.indexOf(reservaEscolhida)).setSalao(salaoEscolhido);
     
                    break;
                case 4:
                    
                    System.out.println("RESERVAS DE UM SALÃO \n");
                    
                    for(Salao salao : saloes){
                        for(Reserva reserva : reservas){
                            if(reserva.getSalao().equals(salao) && reserva.getStatus().equals("CONFIRMADA")){
                                System.out.println(reserva.toString());
                            }
                        }
                    }
                    input.nextLine();
                    break;
                case 5:    
                    
                    System.out.println("RESERVAS FINALIZADAS DE UM SALÃO \n");
                    
                    for(Salao salao : saloes){
                        int counter = 0;
                        for(Reserva reserva : reservas){
                            if(reserva.getSalao().equals(salao) && reserva.getStatus().equals("FINALIZADA")){
                                counter+=1;
                            }
                        }
                        System.out.println(salao.getNumero() + ": " + counter + " reservas finalizadas.");
                    }
                    input.nextLine();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        
    }
    
    private static Reserva makeNewReserva(){
        
        Reserva reserva = new Reserva();
        
        System.out.println("CRIAR NOVA RESERVA\n");
        
        input.nextLine();
        
        System.out.print("Digite o nome do cliente: ");
        reserva.setNomeCliente(input.nextLine());
        
        System.out.print("Digite a data prevista (dd/mm/aaaa): ");
        reserva.setData(input.nextLine());
        
        System.out.print("Digite o horário (MANHÃ, TARDE, NOITE): ");
        reserva.setHorario(input.nextLine().toUpperCase());
        
        System.out.print("Digite a quantidade de convidados: ");
        reserva.setQuantConvidados(input.nextInt());
        
        System.out.print("Digite o valor total: ");
        reserva.setValorTotal(input.nextDouble());
        
        return reserva;
    }
    
    private static void printMenu(){
        System.out.println("============ SALÕES & CO ==============");
        System.out.println("1 - Cadastrar uma reserva");
        System.out.println("2 - Associar um organizador a um salão");
        System.out.println("3 - Atribuir reserva a um salão");
        System.out.println("4 - Exibir todas as reservas confirmadas em um salão");
        System.out.println("5 - Informar a quantidade total de reservas finalizadas para cada salão");
        System.out.println("6 - Buscar reservas por status.");
        System.out.println("7 - Exibir os detalhes completos de uma reserva específica");
        System.out.println("0 - Sair");
    }
}
