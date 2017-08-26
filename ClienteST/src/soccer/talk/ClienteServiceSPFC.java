/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer.talk;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import soccer.talk.ChatMessage;

/**
 *
 * @author PB
 */
public class ClienteServiceSPFC {
    
    private Socket socket;
    private ObjectOutputStream output;
    
    public Socket connect(){
        try {
            this.socket = new Socket("localhost", 6633);
            this.output = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClienteServiceSPFC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return socket;
    }
    
    public void enviar(ChatMessage msg){
        try {
            output.writeObject(msg);
        } catch (IOException ex) {
            Logger.getLogger(ClienteServiceSPFC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
