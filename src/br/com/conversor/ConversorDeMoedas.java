package br.com.conversor;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMoedas  {
    private String moedaOrigemBasecode;
    private String moedaDestinoTargetCode;
    private double conversion_rate;

    public void conversor(String moedaOrigemBasecode, String moedaDestinoTargetCode) {
        try {

            String chave = "";//Coloque entre aspas a sua chave!
            String url = "https://v6.exchangerate-api.com/v6/" + chave + "/pair/" + moedaOrigemBasecode + "/" + moedaDestinoTargetCode;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            ConversionRates conversionRates = gson.fromJson(response.body(), ConversionRates.class);
            this.moedaOrigemBasecode = conversionRates.moedaOrigemBasecode();
            this.moedaDestinoTargetCode = conversionRates.moedaDestinoTargetCode();
            this.conversion_rate = conversionRates.conversion_rate();

        } catch (Exception exception) {
            throw new RuntimeException("Ocorreu um erro.");
        }


    }
    public double getConversorDeMoedas(){
        return conversion_rate;
    }
    @Override
    public String toString() {

        return String.format("%.2f", conversion_rate);
    }
}
