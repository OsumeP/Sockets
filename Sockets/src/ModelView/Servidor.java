/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Juan David Patarroyo
 */
public class Servidor implements Runnable{
    
    private int puerto;
    private JTextArea area1;
    private JTextArea area2;
    
    public Servidor(int puerto){
        this.puerto = puerto;
    }
    public void Area1(JTextArea area){
        this.area1 = area;
    }

     
    @Override
    public void run(){
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            
            while (true){
                Socket sc = servidor.accept();
                
                DataInputStream in = new DataInputStream(sc.getInputStream());
                
                String mensaje = in.readUTF();
                this.area1.append(mensaje);
                
                sc.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
