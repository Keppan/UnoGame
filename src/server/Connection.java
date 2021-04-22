package server;

import gameclasses.Card;
import gameclasses.CardsEnum;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Connection implements Runnable {

    public Connection(){
        try {
            Registry registry = LocateRegistry.getRegistry(5000);
            Online stub = (Online) registry.lookup("UnoServer");
            stub.getCard(new Card(CardsEnum.Yellow_0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        new Connection();
    }
}
