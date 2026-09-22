package mx.florinda.cardapio;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteItensCardapioComSocket {

    static void main() throws Exception {
        try(Socket socket = new Socket("localhost", 8009)){
            OutputStream clientOutputStream = socket.getOutputStream();
            PrintStream clientOutput = new PrintStream(clientOutputStream);

            clientOutput.println("GET / HTTP/1.1");
            clientOutput.println();

            InputStream clientInputStream = socket.getInputStream();
            Scanner scanner = new Scanner(clientInputStream);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
    }

}
