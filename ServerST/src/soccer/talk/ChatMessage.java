/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer.talk;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author PB
 */
public class ChatMessage implements Serializable{
    
    private String nome;
    private String text;
    private String time;
    private String nomePrivado;
    private Set<String> setOnline = new HashSet<String>();
    private Action action;
    private boolean privado = false;

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public String getNomePrivado() {
        return nomePrivado;
    }

    public void setNomePrivado(String nomePrivado) {
        this.nomePrivado = nomePrivado;
    }

    public Set<String> getSetOnline() {
        return setOnline;
    }

    public void setSetOnline(Set<String> setOnline) {
        this.setOnline = setOnline;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
    
    
    
    public enum Action {
        CONNECT, DISCONNECT, SEND_PRIVATE, SEND_ALL, USERS_ONLINE
    }
    
}
