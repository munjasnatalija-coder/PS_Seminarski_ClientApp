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
import domain.Mesto;
import domain.Zaposleni;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Response response = new Response();
        try {        
            Request request = new Request(Operations.LOGIN, z);
            response = Communication.getInstance().send(request,"prijava");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
            z = (Zaposleni) response.getObject();
            System.out.println("USPESNO PRIJAVA KONTROLER");
            return z;
        }else{
            System.out.println("GRESKA PRIJAVA KONTROLER");
            throw response.getException();
        }
    }

    public List<Kupac> ucitajKupce() throws Exception {
        Request request = new Request(Operations.UCIATAJ_KUPCE, null);
        Response response = Communication.getInstance().send(request, "ucitaj kupce");
        
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
             List<Kupac> kupci = (List<Kupac>) response.getObject();
            return kupci;
        }else
            throw response.getException();
    }

    public void ubaciSmenu(LocalDateTime pocetakSmene, LocalDateTime krajSmene) throws Exception {
        Map<String, LocalDateTime> smene = new HashMap<>();
        smene.put("pocetakSmene", pocetakSmene);
        smene.put("krajSmene", krajSmene);
        Request request = new Request(Operations.UBACI_SMENU, smene);
        
        Response response = Communication.getInstance().send(request, "ubaci smenu");
        if(response.getResponseType().equals(ResponseType.SUCCESS)){ 
            System.out.println("kontroler klijent uspesno ubaci smenu response");
        }else{
            throw response.getException();
        }
    }
   
    public List<Mesto> ucitajMesta() throws Exception {
        Request request = new Request(Operations.UCITAJ_MESTA, null);
        Response response = Communication.getInstance().send(request, "ucitaj mesta");
        List<Mesto> mesta = (List<Mesto>) response.getObject();
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
            return (List<Mesto>) response.getObject();
        }else{
            throw response.getException();
        }
    }

    public void kreirajKupca(Kupac kupac) throws Exception {
        Request request = new Request(Operations.KREIRAJ_KUPCA, kupac);
        Response response = Communication.getInstance().send(request, "kreiraj kupca");
        if(response.getResponseType().equals(ResponseType.SUCCESS)){ 
            System.out.println("Kontroler klijent uspesno kreiraj kupca.");
        }else{
            throw response.getException();
        }
    }

    public void promeniKupca(Kupac kupac) throws Exception {
        Request request = new Request(Operations.PROMENI_KUPCA, kupac);
        Response response = Communication.getInstance().send(request, "promeni kupca");
        if(response.getResponseType().equals(ResponseType.SUCCESS)){ 
            System.out.println("Kontroler klijent uspesno kreiraj kupca.");
        }else{
            throw response.getException();
        }
    }
    
}
