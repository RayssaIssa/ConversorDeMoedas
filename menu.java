import Principal.OpcaoInvalidaException;
import java.util.Map;

public class menu {

    public static void menuDeOpcoes() {
        System.out.println("\n*************************************");
        System.out.println("Seja bem vindo ao Conversor de Moedas!\n");
        System.out.println("1) Dólar -> Peso Argentino");
        System.out.println("2) Peso Argentino -> Dólar");
        System.out.println("3) Dólar -> Real Brasileiro");
        System.out.println("4) Real Brasileiro -> Dólar");
        System.out.println("5) Dólar -> Euro");
        System.out.println("6) Euro -> Dólar");
        System.out.println("7) Dólar -> Won Sul-Coreano");
        System.out.println("8) Won Sul-Coreano -> Dólar");
        System.out.println("9) Dólar -> Libra Esterlina");
        System.out.println("10) Libra Esterlina -> Dólar");
        System.out.println("11) Dólar -> Yuan");
        System.out.println("12) Yuan -> Dólar");
        System.out.println("13) Sair");

        System.out.println("\nEscolha uma das opções: ");
    }

    private static final Map<Integer, String> moeda = Map.ofEntries(
            Map.entry(1, "USD"),
            Map.entry(2, "ARS"),
            Map.entry(3, "USD"),
            Map.entry(4, "BRL"),
            Map.entry(5, "USD"),
            Map.entry(6, "EUR"),
            Map.entry(7, "USD"),
            Map.entry(8, "KRW"),
            Map.entry(9, "USD"),
            Map.entry(10, "GBP"),
            Map.entry(11, "USD"),
            Map.entry(12, "CNY")
    );

    private static final Map<Integer, String> moedaC = Map.ofEntries(
            Map.entry(1, "ARS"),
            Map.entry(2, "USD"),
            Map.entry(3, "BRL"),
            Map.entry(4, "USD"),
            Map.entry(5, "EUR"),
            Map.entry(6, "USD"),
            Map.entry(7, "KRW"),
            Map.entry(8, "USD"),
            Map.entry(9, "GBP"),
            Map.entry(10, "USD"),
            Map.entry(11, "CNY"),
            Map.entry(12, "USD")
    );


    public static String verificaMoeda(int opcao) throws OpcaoInvalidaException {
        if (!moeda.containsKey(opcao)) {
            throw new OpcaoInvalidaException("Opção inválida!");
        }
        return moeda.get(opcao);
    }

    public static String verificaMoedaC(int opcao) throws OpcaoInvalidaException {
        if (!moedaC.containsKey(opcao)) {
            throw new OpcaoInvalidaException("Opção inválida!");
        }
        return moedaC.get(opcao);
    }

}