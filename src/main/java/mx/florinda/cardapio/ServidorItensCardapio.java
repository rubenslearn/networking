package mx.florinda.cardapio;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServidorItensCardapio {

    static void main() throws IOException {
        // inicializa
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8009);
        HttpServer httpServer = HttpServer.create(inetSocketAddress, 0);

        httpServer.createContext("/itensCardapio", exchange -> {
            Path path = Paths.get("itensCardapio.json");
            String json = Files.readString(path);
            byte[] jsonBytes = json.getBytes();

            Headers responseHeaders = exchange.getResponseHeaders();
            responseHeaders.add("Content-Type", "application/json; charset=UTF-8");

            exchange.sendResponseHeaders(200, jsonBytes.length);

            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(jsonBytes);
            exchange.close();
        });

        System.out.println("Subiu servidor http!");
        httpServer.start();
    }

}
