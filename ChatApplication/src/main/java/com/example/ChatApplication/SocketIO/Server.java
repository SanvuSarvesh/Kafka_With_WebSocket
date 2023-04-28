package com.example.ChatApplication.SocketIO;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    public Server() {
        try{
            serverSocket = new ServerSocket(1111);
            System.out.println("Server is Ready...");
            System.out.println("Waiting for the Client...");
            socket = serverSocket.accept();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    void startReading() throws Exception{
        Runnable runnable1 = ()->{
            System.out.println("Reader Started...");
            while (true){
                try{
                    System.out.println("Start Chatting...");
                    br = new BufferedReader(new InputStreamReader(System.in));
                    String message = br.readLine();
                    if(message.equals("Bye")){
                        System.out.println("Client has terminated the chat.");
                        break;
                    }
                    System.out.println("Client : " + message);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        };
        new Thread(runnable1).start();
    }

    void startWriting(){
        Runnable runnable2 = ()->{
            while (true){
                try{
                    BufferedReader br1 =
                            new BufferedReader(new InputStreamReader(System.in));
                    String content = br1.readLine();
                    out.println(content);
                    out.flush();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        };
        new Thread(runnable2).start();
    }
//    public static void main(String[] args) {
//        System.out.println("Server is starting...");
//        new Server();
//    }
}