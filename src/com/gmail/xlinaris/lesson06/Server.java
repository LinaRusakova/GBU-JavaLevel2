package com.gmail.xlinaris.lesson06;

/*
Author Lina Rusakova.
This is my beautiful solution to creating chat between client-server!
Thanks! :-)
* */
import java.io.*;
import java.net.*;

class NServer {
    private Socket socket;
    DataInputStream inMessage;
    DataOutputStream outMessage;
    String message = "", str = "";

    private volatile boolean isRunning = true;
    BufferedReader bufferedReader;
    InputStreamReader isr;

    public NServer(Socket s) throws IOException {
        socket = s;
        inMessage = new DataInputStream(socket.getInputStream());
        outMessage = new DataOutputStream(socket.getOutputStream());
    }

    public void run() {

        //Thread for sending messages.
        try {
            Runnable r = () -> {
                sendMessage();

            };
            var mr = new Thread(r);
            mr.setDaemon(true);
            mr.start();


        } catch (Exception e) {
            e.printStackTrace();
        }

        //Thread for receiving messages.
        try {
            Runnable s = () -> {
                receiveMessage();
            };
            var ms = new Thread(s);

            ms.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        while (isRunning) {
            isr = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(isr);
            try {
                message = bufferedReader.readLine();
                if (message.equals("/END")) {
                    System.out.println("Socket closed.");
                    outMessage.writeUTF(message);
                    bufferedReader.close();
                    isRunning = false;
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outMessage.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void receiveMessage() {
        while (isRunning) {
            try {
                str = inMessage.readUTF();
                if (str.equals("/END")) {
                    outMessage.writeUTF("Socket closed.");
                    socket.close();
                    isRunning = false;
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Incoming Client message: " + str);
            try {
                outMessage.writeUTF("***Yor message was received by Server.***");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Server {
    private static final int PORT = 8189;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("--Server Started.--");
            System.out.println("--Server waiting for new connection.--");
            Socket clientSocket = serverSocket.accept();
            System.out.println("--Client has been connected.--");
            NServer firstClientServer = new NServer(clientSocket);
            firstClientServer.run();
        }
    }
}
