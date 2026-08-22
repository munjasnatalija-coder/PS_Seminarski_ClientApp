/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import domain.Kupac;

/**
 *
 * @author Natalija
 */
public class Validator {
    public boolean validateKupac(Kupac k){
        if(k.getIme().isEmpty() || k.getPrezime().isEmpty() || k.getBrojTelefona().isEmpty() || k.getEmail().isEmpty())
            return false;
        if(k.getIme().matches(".*\\d.*") || k.getPrezime().matches(".*\\d.*"))
            return false;
        if(!k.getEmail().contains("@"))
            return false;
        return true;
    }
   
}
