import Principal.OpcaoInvalidaException;
import com.google.gson.JsonObject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws OpcaoInvalidaException {
        //Cria a leitura de variáveis
        Scanner leitura = new Scanner(System.in);
        int opcao = 0;
        double valorParaConverter, resultado, taxaDeCambio;
        String moedaAtual, moedaParaConverter;

        do{
            menu.menuDeOpcoes();    //Exibe a classe com as opções do menu
            opcao = leitura.nextInt();  //Captura a escolha de classe

            //Encerra o sistema
            if(opcao == 13){
                System.out.println("Sistema encerrado.");
                break;

            //Se for uma das opções do menu, passa para a busca
            }else if(opcao >=1 && opcao <= 12){
                moedaAtual = menu.verificaMoeda(opcao); //Pega a string da moeda que será inserida
                moedaParaConverter = menu.verificaMoedaC(opcao);    //Pega a string da moeda que será convertida

                try {
                    // Chamando a BuscadorMoeda
                    JsonObject jsonObject = BuscadorMoeda.buscarDadosMoeda(moedaAtual);

                    if (jsonObject != null){
                        // Chamando a extrairTaxaDeConversao
                        extrairTaxaDeConversao extractor = new extrairTaxaDeConversao();
                        taxaDeCambio = extractor.obterTaxaDeConversao(jsonObject, moedaParaConverter);

                        System.out.println("Qual valor deseja converter? ");
                        valorParaConverter = leitura.nextDouble();

                        //Calcula a conversão
                        resultado = valorParaConverter * taxaDeCambio;

                        System.out.println("\nTaxa de cambio de " + moedaAtual + " para " + moedaParaConverter + " e: " + taxaDeCambio);

                        System.out.printf("O valor de %.2f em %s convertido para %s é: %.2f%n", valorParaConverter, moedaAtual, moedaParaConverter, resultado);

                    }else{
                        System.out.println("Não foi possível obter os dados da API.");
                    }
                } catch (Exception e) {     //Se der algum erro, apresenta a menssagem
                    System.out.println("\n\nOcorreu um erro: " + e.getMessage());
                }
            } else {//Se não for uma opção valida, retorna ao loop.
                System.out.println("Opção invalida!");

            }
        }while(opcao != 7);

        leitura.close();
    }
}