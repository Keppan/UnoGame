package server;

import gameclasses.Card;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Online {

    public Server() {}

    public static void main(String args[]) {

        try {
            Server obj = new Server();
            Online stub = (Online) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(5000);
            registry.bind("UnoServer", stub);

            System.err.println("server.Server ready");
        } catch (Exception e) {
            System.err.println("server.Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void getCard(Card s) throws RemoteException {
        System.out.println(s);
    }
}