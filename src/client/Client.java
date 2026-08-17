/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import controller.LoginController;
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
        LoginForm forma = new LoginForm();
        LoginController lc = new LoginController(forma);
        lc.pokreniFomru();
    }

    
    
}
