package Tema_Java;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            socket = new Socket("localhost", 1234);

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter((outputStreamWriter));

            Scanner scanner = new Scanner(System.in); //user input from console
            while (true) {
                String msgToSend = scanner.nextLine();

                //trimitere mesaj catre server
                bufferedWriter.write(msgToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                //raspuns de la server
                System.out.println("Server: " + bufferedReader.readLine());

                if (msgToSend.equals("Bye."))
                    break;


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
