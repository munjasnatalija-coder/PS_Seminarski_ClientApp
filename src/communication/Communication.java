/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import domain.Zaposleni;
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

    private Communication() {
        
    }
    
    public static Communication getInstance(){
        if(instance == null)
            instance = new Communication();
        return instance;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Response login(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za prijavom na sistem je poslat...");
        return (Response) new Receiver(socket).receive();
    }
    
    
    
    
    
}
