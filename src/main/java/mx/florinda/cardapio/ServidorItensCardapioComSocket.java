package mx.florinda.cardapio;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServidorItensCardapioComSocket
{
    static void main() throws Exception {

        try(ServerSocket serverSocket = new ServerSocket(8009)){
            System.out.println("Servidor Iniciado");

            while(true){
                try(Socket clientSocket = serverSocket.accept()){
                    InputStream clientSocketInputStream = clientSocket.getInputStream();

                    StringBuilder requestBuilder = new StringBuilder();

                    int data;

                    do {
                        data = clientSocketInputStream.read();
                        requestBuilder.append((char) data);
                    } while (clientSocketInputStream.available() > 0);

                    String request = requestBuilder.toString();
                    System.out.println(request);

                    //Enviando a response
                    Path path = Paths.get("itensCardapio.json");
                    String json = Files.readString(path);

                    OutputStream clientOutputStream = clientSocket.getOutputStream();
                    PrintStream clientOut = new PrintStream(clientOutputStream);

                    clientOut.println("HTTP/1.1 200 OK");
                    clientOut.println("Content-Type: application/json; charset=utf-8");
                    clientOut.println("Content-Length: " + json.getBytes().length);
                    clientOut.println();
                    clientOut.println(json);
                }
            }
        }
    }
}
