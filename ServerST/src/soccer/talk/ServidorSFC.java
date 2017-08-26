/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer.talk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import soccer.talk.ChatMessage;
import soccer.talk.ChatMessage.Action;

/**
 *
 * @author PB
 */
public class ServidorSFC {

    private ServerSocket serverSocket;
    private Socket socket;
    private Map<String, ObjectOutputStream> mapOnline = new HashMap<String, ObjectOutputStream>();

    public ServidorSFC() {
        try {
            serverSocket = new ServerSocket(4321);
            System.out.println("Servidor Santos Futebol Clube Online!!!");
            while (true) {
                socket = serverSocket.accept();
                new Thread(new ListenerSocket(socket)).start();
            }

        } catch (IOException ex) {
            Logger.getLogger(ServidorSFC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class ListenerSocket implements Runnable {

        private ObjectOutputStream output;
        private ObjectInputStream input;

        public ListenerSocket(Socket socket) {
            try {
                this.output = new ObjectOutputStream(socket.getOutputStream());
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ServidorSFC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            ChatMessage msg = null;
            try {
                while ((msg = (ChatMessage) input.readObject()) != null) {
                    Action action = msg.getAction();

                    if (action.equals(Action.CONNECT)) {
                        boolean v = connect(msg, output);
                        if (v) {
                            mapOnline.put(msg.getNome(), output);
                            msg.setText("Conectou-se!");
                            msg.setAction(Action.SEND_ALL);
                            sendAll(msg);
                            sendOnline();
                        }
                    } else if (action.equals(Action.DISCONNECT)) {
                        disconnect(msg, output);
                        sendOnline();
                        return;
                    } else if (action.equals(Action.SEND_PRIVATE)) {
                        sendPrivate(msg);
                    } else if (action.equals(Action.SEND_ALL)) {
                        sendAll(msg);
                    }
                }
            } catch (IOException ex) {
                disconnect(msg, output);
                sendOnline();
                System.out.println(msg.getNome() + " deixou o chat!");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServidorSFC.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private boolean connect(ChatMessage msg, ObjectOutputStream output) {
        if (mapOnline.size() == 0) {
            msg.setText("YES");
            send(msg, output);
            return true;
        }

        if (mapOnline.containsKey(msg.getNome())) {
            msg.setText("NO");
            send(msg, output);
            return false;
        } else {
            msg.setText("YES");
            send(msg, output);
            return true;
        }
    }

    private void disconnect(ChatMessage msg, ObjectOutputStream output) {
        mapOnline.remove(msg.getNome());
        msg.setText(msg.getNome() + " deixou o chat!");
        msg.setAction(Action.SEND_PRIVATE);
        sendAll(msg);
        System.out.println("User " + msg.getNome() + " saiu da sala!");

    }

    private void send(ChatMessage msg, ObjectOutputStream output) {
        try {
            output.writeObject(msg);
        } catch (IOException ex) {
            Logger.getLogger(ServidorSFC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void sendPrivate(ChatMessage msg) {
        for (Map.Entry<String, ObjectOutputStream> x : mapOnline.entrySet()) {
            if (x.getKey().equals(msg.getNomePrivado())) {
                try {
                    x.getValue().writeObject(msg);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorSFC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void sendAll(ChatMessage msg) {
        for (Map.Entry<String, ObjectOutputStream> x : mapOnline.entrySet()) {
            
            if (!x.getKey().equals(msg.getNome())) {
                msg.setAction(Action.SEND_PRIVATE);
                try {
                    x.getValue().writeObject(msg);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorSFC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    private void sendOnline() {
        Set<String> set = new HashSet<String>();
        for (Map.Entry<String, ObjectOutputStream> x : mapOnline.entrySet()) {
            set.add(x.getKey());
        }
        ChatMessage msg = new ChatMessage();
        msg.setAction(Action.USERS_ONLINE);
        msg.setSetOnline(set);

        for (Map.Entry<String, ObjectOutputStream> x : mapOnline.entrySet()) {
            msg.setNome(x.getKey());
            try {
                x.getValue().writeObject(msg);
            } catch (IOException ex) {
                Logger.getLogger(ServidorSFC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public static void main(String[] args) {
        new ServidorSFC();
    }
    
    
}
