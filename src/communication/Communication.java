/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import domain.Zaposleni;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Natalija
 */
public class Communication {
    private Socket socket;
    private static Communication instance;
    private Sender sender;
    private Receiver receiver;

    private Communication() throws IOException {
        socket = new Socket("localhost",9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }
    
    public static Communication getInstance() throws IOException{
        if(instance == null)
            instance = new Communication();
        return instance;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Response login(Request request) throws Exception {
        sender.send(request);
        System.out.println("Zahtev za prijavom na sistem je poslat...");
        return (Response) receiver.receive();
    }

    public Response ucitajKupce(Request request) throws Exception {
        sender.send(request);
        System.out.println("Zahtev za ucitavanje kupaca je poslat");
        return (Response) receiver.receive();
    }
    
}
