/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer.talk;

/**
 *
 * @author PB
 */
public class ServerST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                new ServidorService();
            }
        }.start();
        
        new Thread(){
            @Override
            public void run() {
                new ServidorSCCP();
            }
        }.start();
        
        new Thread(){
            @Override
            public void run() {
                new ServidorSEP();
            }
        }.start();
        
        new Thread(){
            @Override
            public void run() {
                new ServidorSFC();
            }
        }.start();
        
        new Thread(){
            @Override
            public void run() {
                new ServidorSPFC();
            }
        }.start();
    }
    
}
