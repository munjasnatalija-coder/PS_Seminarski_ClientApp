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
import domain.Kupac;
import domain.Zaposleni;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Natalija
 */
public class Controller {
    private static Controller instance;
    private Zaposleni zaposleni;

    private Controller() {
    }
    
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }
    
    public Zaposleni login(String username, String password) throws Exception{
        Zaposleni z = new Zaposleni();
        z.setUsername(username);
        z.setPassword(password);
        
        Request request = new Request(Operations.LOGIN, z);
        Response response = Communication.getInstance().login(request);
        
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
            zaposleni = (Zaposleni) response.getObject();
            return zaposleni;
        }else
            throw response.getException();
    }

    public List<Kupac> ucitajKupce() throws Exception {
        Request request = new Request(Operations.UCIATAJ_KUPCE, null);
        Response response = Communication.getInstance().ucitajKupce(request);
        
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
             List<Kupac> kupci = (List<Kupac>) response.getObject();
            return kupci;
        }else
            throw response.getException();
    }
    
}
