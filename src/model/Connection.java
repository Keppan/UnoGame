package model;

import gameclasses.Card;
import gameclasses.CardsEnum;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Connection {
    InetAddress host;
    Socket socket;
    ObjectOutputStream oos ;
    ObjectInputStream ois;
    public Connection () {
        try {
            host = InetAddress.getLocalHost();
            socket = new Socket(host.getHostName(), 5000);
            oos = new ObjectOutputStream(socket.getOutputStream());
          //  ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void sendActiveCard(Card s) throws IOException {
      //  oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(s);
       // oos.flush();
        //oos.flush();
       // oos.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket;
        ObjectOutputStream oos;
        ObjectInputStream ois;
            //establish socket connection to server
            socket = new Socket(host.getHostName(), 5000);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            oos.writeObject(new Card(CardsEnum.Green_4));
            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            Card message = (Card) ois.readObject();
            System.out.println(message);
            //close resources
            ois.close();
            oos.close();
    }
}
