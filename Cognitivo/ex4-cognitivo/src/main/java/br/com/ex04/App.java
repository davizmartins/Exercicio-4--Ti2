package br.com.ex04;

import org.json.*;
import java.net.http.*;
import java.net.URI;

public class App {
    public static void main(String[] args) throws Exception {
        
        final String endpoint = "https://ai-ex04.cognitiveservices.azure.com/";
        
        final String key = System.getenv("AZURE_AI_KEY");
        if (key == null || key.isBlank()) {
            throw new IllegalStateException("Defina a variável de ambiente AZURE_AI_KEY com sua Key 1.");
        }

        
        JSONArray documents = new JSONArray()
            .put(new JSONObject().put("id","1").put("text","Estou muito feliz com esse projeto!").put("language","pt"))
            .put(new JSONObject().put("id","2").put("text","O atendimento foi péssimo e me deixou irritado.").put("language","pt"))
            .put(new JSONObject().put("id","3").put("text","O serviço é razoável, nada demais.").put("language","pt"));

        // Corpo no formato da nova API
        JSONObject body = new JSONObject()
            .put("kind", "SentimentAnalysis")
            .put("analysisInput", new JSONObject().put("documents", documents))
            .put("parameters", new JSONObject()
                .put("modelVersion", "latest")
                .put("opinionMining", false)
            );

        // Rota nova:
        String url = endpoint + "language/:analyze-text?api-version=2023-04-01";

        HttpClient http = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Ocp-Apim-Subscription-Key", key)
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
            .build();

        HttpResponse<String> resp = http.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("HTTP status: " + resp.statusCode());
        System.out.println("JSON bruto: " + resp.body());

        if (resp.statusCode() == 200) {
            JSONObject json = new JSONObject(resp.body());
            JSONArray docs = json.getJSONObject("results").getJSONArray("documents");
            for (Object o : docs) {
                JSONObject d = (JSONObject) o;
                String id = d.getString("id");
                String sentimento = d.getString("sentiment");
                JSONObject c = d.getJSONObject("confidenceScores");
                System.out.printf("Doc %s -> %s (pos: %.2f | neu: %.2f | neg: %.2f)%n",
                        id, sentimento, c.getDouble("positive"), c.getDouble("neutral"), c.getDouble("negative"));
            }
        }
    }
}
