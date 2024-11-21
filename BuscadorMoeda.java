import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BuscadorMoeda {

    public static JsonObject buscarDadosMoeda(String moeda) throws IOException {
        String urlComum = "https://v6.exchangerate-api.com/v6/f388e383fae3e501ed7f3610/latest/";
        String url_str = urlComum + moeda;

        try {
            // Fezendo o Request
            URL url = new URL(url_str);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Lendo a resposta
            int responseCode = con.getResponseCode();
            if (responseCode != 200) {
                throw new IOException("Erro ao buscar taxa de câmbio: " + responseCode);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parseando o JSON
            JsonParser parser = new JsonParser();

            return parser.parse(response.toString()).getAsJsonObject();

        }catch (IOException e) {
            System.err.println("Erro ao buscar dados da moeda: " + e.getMessage());
            return null;
        }
    }
}
