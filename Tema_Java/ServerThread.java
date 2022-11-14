package Tema_Java;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Integer.parseInt;


public class ServerThread extends Thread {
    private Socket socket;

    private PrintWriter output;

    private  ArrayList<Human> list =null;
    public ServerThread(Socket socket, ArrayList<Human> list) {
        this.socket = socket;
        this.list=list;
    }

    @Override
    public void run() {

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;
        try {
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter((outputStreamWriter));

            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));


            output = new PrintWriter(socket.getOutputStream(),true);



            while(true) {
                String msgFromClient = bufferedReader.readLine();

                String[] str= msgFromClient.split(" ");

                if(str[0].equals("Student") )
                {
                    Student std = new Student(str[1],str[2],str[3],parseInt(str[4]),parseInt(str[5]));

                    bufferedWriter.write("Mesaj primit.");

                    list.add(std);

                }
                else if(str[0].equals("Profesor") )
                {
                    Profesor prof = new Profesor(str[1],str[2],str[3],parseInt(str[4]),(str[5]));

                    bufferedWriter.write("Mesaj primit.");

                    list.add(prof);

                }
                else
                {
                    bufferedWriter.write("Obiectul nu este de tipul Student sau Profesor\n");

                }

                System.out.println("Client: " + msgFromClient);

                Collections.sort(list);
                System.out.println(list);

                // bufferedWriter.write("Mesaj primit");
                bufferedWriter.newLine();
                bufferedWriter.flush();


                if (msgFromClient.equals("Bye."))
                    break;

            }


        } catch (Exception e) {
            System.out.println("Error occured " +e.getStackTrace());
        }
    }



    }

