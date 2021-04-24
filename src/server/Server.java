package server;

import gameclasses.Card;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {
    //static ServerSocket variable
    private ServerSocket server;
    //socket server port on which it will listen
    private int port = 5000;
    private ArrayList<Socket> connected = new ArrayList<>();
    private ArrayList<ObjectInputStream> ioss = new ArrayList<>();
    private HashMap<Socket,ObjectInputStream> test = new HashMap<>();

    public Server () throws IOException, ClassNotFoundException {
        //create the socket server object
        server = new ServerSocket(port);
        new Thread(new Handler()).start();
        // Socket socket = server.accept();
       // connected.add(socket);
       // ObjectInputStream ois = new ObjectInputStream(connected.get(0).getInputStream());
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for the client request");
            //creating socket and waiting for client connection
            // Socket socket = server.accept();
            // connected.add(socket);
            //read from socket to ObjectInputStream object
            //  ObjectInputStream ois = new ObjectInputStream(connected.get(0).getInputStream());
            //convert ObjectInputStream object to String
            for (Socket s : test.keySet()){
                Card message = (Card) test.get(s).readObject();
                System.out.println("Message Received: " + message);
            }

            //create ObjectOutputStream object
            // ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket
            //  oos.writeObject(message);
            //close resources
            // ois.close();
            //  oos.close();
            //  socket.close();
            //terminate the server if client sends exit request
            //    if(message.equalsIgnoreCase("exit")) break;
        }
        //   System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        //  server.close();
    }

    public static void main(String args[]){
        try {
            new Server();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    class Handler implements Runnable{
        Handler(){

        }
        @Override
        public void run() {
            while(true){
                Socket socket = null;
                try {
                    socket = server.accept();
                    test.put(socket,new ObjectInputStream(socket.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                connected.add(socket);
            }
        }
    }

}