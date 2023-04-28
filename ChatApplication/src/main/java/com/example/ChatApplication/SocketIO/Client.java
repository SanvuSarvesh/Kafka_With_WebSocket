package com.example.ChatApplication.SocketIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    Socket socket;
    BufferedReader br;
    PrintWriter out;
    public Client() {
        try {
            System.out.println("Sending Request to Server...");
            socket = new Socket("localhost",1111);
            System.out.println("Connection Establish...");
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
                        System.out.println("Server has terminated the chat.");
                        break;
                    }
                    System.out.println("Server : " + message);
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
                    br = new BufferedReader(new InputStreamReader(System.in));
                    String content = br.readLine();
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
//        System.out.println("Client has Started...");
//        new Client();
//    }
}