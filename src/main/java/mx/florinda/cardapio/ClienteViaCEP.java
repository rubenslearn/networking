package mx.florinda.cardapio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteViaCEP {

    static void main() {
        // Utilizando a consulta para o via CEP

        URI uri = URI.create("https://viacep.com.br/ws/01001000/json/");

        try(HttpClient httpClient = HttpClient.newHttpClient()){
            HttpRequest httpRequest = HttpRequest.newBuilder(uri).build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            String body = httpResponse.body();

            System.out.println(statusCode);
            System.out.println(body);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
