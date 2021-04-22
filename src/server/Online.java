package server;

import gameclasses.Card;

import java.rmi.*;
public interface Online extends Remote{
    void getCard(Card s)throws RemoteException;

}
