/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.LoginForm;

/**
 *
 * @author Natalija
 */
public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.connect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void connect() throws IOException {
        Socket socket = new Socket("localhost", 9000);
        System.out.println("Klijent se povezao!");
        communication.Communication.getInstance().setSocket(socket);
        LoginForm forma = new LoginForm();
        new controller.LoginController(forma);
        forma.setVisible(true);
        
    }
    
}
