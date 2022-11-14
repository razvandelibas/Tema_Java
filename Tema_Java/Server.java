package Tema_Java;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Server {
    public static void main(String args[]) throws IOException {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket(1234);

        ArrayList<Human> list = new ArrayList<>();

        while (true) // creem un nou socket de fiecare data cand clientul accepta o conexiune
        {
            try {
                socket = serverSocket.accept();

                ServerThread serverThread = new ServerThread(socket,list);
                serverThread.start();

               /* inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter((outputStreamWriter));

                while (true)//pt a trimite/primi date
                {
                    String msgFromClient = bufferedReader.readLine();

                    String[] str= msgFromClient.split(" ");

                    if(str[0].equals("Student") )
                    {
                        Student std = new Student(str[1],str[2],str[3],parseInt(str[4]),parseInt(str[5]));
                       // list.add(new Student());
                        bufferedWriter.write("Mesaj primit");

                        list.add(std);

                    }
                    else if(str[0].equals("Profesor") )
                    {
                        Profesor prof = new Profesor(str[1],str[2],str[3],parseInt(str[4]),(str[5]));

                        bufferedWriter.write("Mesaj primit:");

                        list.add(prof);

                    }
                    else
                    {
                        bufferedWriter.write("Obiectul nu este de tipul Student sau Profesor\n");

                    }

                    System.out.println("Client: " + msgFromClient);
                    System.out.println(list);

                   // bufferedWriter.write("Mesaj primit");
                   bufferedWriter.newLine();
                   bufferedWriter.flush();


                    if (msgFromClient.equals("Bye."))
                        break;

                }
*/
            } catch (IOException e) {
                e.printStackTrace();

            }

        }
    }
}
