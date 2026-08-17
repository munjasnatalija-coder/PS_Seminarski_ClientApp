/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Zaposleni;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.LoginForm;
import view.MainForm;

/**
 *
 * @author Natalija
 */
public class LoginController {
    private final LoginForm forma;

    public LoginController(LoginForm forma) {
        this.forma = forma;
        addActionListener();
    }

    private void addActionListener() {
        forma.loginActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login(e);
            }

            private void login(ActionEvent e) {
                try {
                    String username= forma.getTxtUsername().getText().trim();
                    String password = String.valueOf(forma.getTxtPassword().getPassword()).trim();
                    Zaposleni ulogovani = Controller.getInstance().login(username, password);
                    JOptionPane.showMessageDialog(forma, "Prijava na sistem je uspesna", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    forma.dispose();
                    MainForm mainForm = new MainForm(ulogovani);
                    mainForm.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(forma, "Prijava na sistem nije uspela", "Neuspeh", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
    }
    
    public void pokreniFomru(){
        forma.setVisible(true);
    }
}
