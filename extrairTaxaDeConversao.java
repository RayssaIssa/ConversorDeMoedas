import com.google.gson.JsonObject;

public class extrairTaxaDeConversao {
    public double obterTaxaDeConversao(JsonObject jsonObject, String moedaDesejada) {
        // Acessar o objeto "conversion_rates"
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        if (conversionRates.has(moedaDesejada)) {
            return conversionRates.get(moedaDesejada).getAsDouble();
        } else {
            System.out.println("Moeda não encontrada.");
            return 0.0; // Ou lançar uma exceção
        }
    }
}