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

    public Response send(Request request, String name) throws Exception{
        sender.send(request);
        System.out.println("Uspesno poslat zahtev ["+name+"] ..");
        return (Response) receiver.receive();
    }
}
