package com.gmail.xlinaris.lesson06;

/*
Author Lina Rusakova.
This is my beautiful solution to creating chat between client-server!
Thanks! :-)
* */
import java.io.*;
import java.net.*;

class NClient {

    Socket clientSocket;
    String message = "";
    DataInputStream inMessage;
    DataOutputStream outMessage;
    BufferedReader bufferedReader;
    private volatile boolean isRunning = true;
    String str;

    public NClient() throws IOException {
        clientSocket = new Socket("localhost", 8189);
        inMessage = new DataInputStream(clientSocket.getInputStream());
        outMessage = new DataOutputStream(clientSocket.getOutputStream());
        System.out.println("--Client is connected to the Server.--");
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
            InputStreamReader isr = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(isr);
            try {
                message = bufferedReader.readLine();
                outMessage.writeUTF(message);
                if (message.equals("/END")) {
                    bufferedReader.close();
                    isRunning = false;
                    break;
                }

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
                    //socket.close();
                    clientSocket.close();
                    isRunning = false;
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Incoming Server message: " + str);
        }
    }
}


public class Client {

    public static void main(String[] args) throws IOException {

        NClient client = new NClient();
        client.run();

    }
}

