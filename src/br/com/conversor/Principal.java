package br.com.conversor;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int opcao = 0;
        int quantidadeDeMoeda =0;
        String moedaOrigemBasecode ="";
        String moedaDestinoTargetCode ="";
        String menu = "********************************** \n"+
                "1) Dólar =>> Peso argentino \n" +
                "2) Peso argentino =>> Dólar \n" +
                "3) Dólar =>> Real brasileiro \n" +
                "4) Real =>> Peso argentino \n" +
                "5) Dólar =>> Peso colombiano \n" +
                "6) Peso colombiano =>> Dólar \n" +
                "7) Sair \n" +
                "Escolha uma opção válida: \n" +
                "**********************************";
        Scanner leitura = new Scanner(System.in);


        while (opcao != 7) {

            System.out.println(menu);
            opcao = leitura.nextInt();


            if ( opcao == 1 ){
                 moedaOrigemBasecode ="USD";
                 moedaDestinoTargetCode ="ARS";
            } else if( opcao == 2 ){
                moedaOrigemBasecode ="ARS";
                moedaDestinoTargetCode ="USD";
            } else if( opcao == 3 ){
                moedaOrigemBasecode ="USD";
                moedaDestinoTargetCode ="BRL";
            }else if( opcao == 4 ){
                moedaOrigemBasecode ="BRL";
                moedaDestinoTargetCode ="ARS";
            }else if( opcao == 5 ){
                moedaOrigemBasecode ="USD";
                moedaDestinoTargetCode ="COP";
            }else if( opcao == 6 ){
                moedaOrigemBasecode ="COP";
                moedaDestinoTargetCode ="USD";
            }
           if ( opcao != 7 ) {
               System.out.println("Digite o valor que deseja converter");
               Scanner opcaoMoeda = new Scanner(System.in);
               quantidadeDeMoeda = opcaoMoeda.nextInt();
               ConversorDeMoedas conversorDeMoedas = new ConversorDeMoedas();
               conversorDeMoedas.conversor(moedaOrigemBasecode,moedaDestinoTargetCode);
               System.out.println();
               double moeda = conversorDeMoedas.getConversorDeMoedas();
               moeda = moeda * quantidadeDeMoeda;
               System.out.println("O valor " + quantidadeDeMoeda + " [" + moedaOrigemBasecode + "] corresponde ao valor final de ==> " + String.format("%.10f",moeda) + " [" + moedaDestinoTargetCode + "] " );
            }
       }
    }
}