import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws IOException, InterruptedException {
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
    }
}
