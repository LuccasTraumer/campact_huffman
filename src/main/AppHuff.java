package main;

import huffman.Huff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class AppHuff {

    public static void main(String[] args) throws Exception{

//        System.out.println("Vamos compactar ou descompactar?");
//        huffman.Huff.compactar("textos/fileIn.txt", "textos/fileOut.txt");
//        huffman.Huff.descompactar("Poesia.huff","Poesia_des.txt");

        Scanner menu = new Scanner(System.in);

        while (true) {

            System.out.print("|-----------------------------|\n");
            System.out.print("| Opção 1 - Compactar         |\n");
            System.out.print("| Opção 2 - Descompactar      |\n");
            System.out.print("| Opção 3 - Sair              |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: \n");

            int opcao = menu.nextInt();

            if (opcao == 3) {
                System.out.print("\nAté logo! =D");
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.print("\nInforme o endereço do arquivo que será compactado\n");
                    Scanner compactarInputUser = new Scanner(System.in);
                    String inputArqEntrada = compactarInputUser.nextLine();
                    compactarInputUser.close();
                    Scanner compactarOutputUser = new Scanner(System.in);
                    String compactarOutputArqSaida = compactarOutputUser.nextLine();
                    compactarOutputUser.close();
                    if (inputArqEntrada.isEmpty() || compactarOutputArqSaida.isEmpty())
                        Huff.compactar("textos/compactFileIn.txt", "textos/compactFileOut.txt");
                    else
                        Huff.compactar(inputArqEntrada, compactarOutputArqSaida);
                    break;

                case 2:
                    System.out.print("\nInforme o endereço do arquivo que será descompactado\n");
                    Scanner descompactarInputUser = new Scanner(System.in);
                    String outputArqEntrada = descompactarInputUser.nextLine();
                    descompactarInputUser.close();
                    Scanner descompactarOutputUser = new Scanner(System.in);
                    String descompactarOutputArqSaida = descompactarOutputUser.nextLine();
                    descompactarOutputUser.close();
                    if (outputArqEntrada.isEmpty() || descompactarOutputArqSaida.isEmpty())
                        Huff.descompactar("textos/descompactFileIn.txt", "textos/descompactFileOut.txt");
                    else
                        Huff.compactar(outputArqEntrada, descompactarOutputArqSaida);
                    break;

                default:
                    System.out.print("\nOpção Inválida!");
                    break;
            }
        }
        menu.close();
        
        
    }
    
}
