/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Communication;
import communication.Operations;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import domain.Zaposleni;

/**
 *
 * @author Natalija
 */
public class Controller {
    private static Controller instance;
    private Zaposleni zaposleni;

    private Controller() {
    }
    
    public static Controller getInstnace(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }
    
    public Zaposleni login(String username, String passsword) throws Exception{
        Zaposleni z = new Zaposleni();
        z.setUsername(username);
        z.setPassword(passsword);
        
        Request request = new Request(Operations.LOGIN, z);
        Response response = Communication.getInstance().login(request);
        
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
            zaposleni = (Zaposleni) response.getObject();
            return (Zaposleni) response.getObject();
        }else
            throw response.getException();
    }
    
}
