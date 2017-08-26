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
public class ClienteConta implements java.io.Serializable {

    public ClienteConta() {
    }

    public ClienteConta(String celular, String senha, String nome, String sexo, String time) {
        this.celular = celular;
        this.senha = senha;
        this.nome = nome;
        this.sexo = sexo;
        this.time = time;
    }

    private String celular;
    private String senha;
    private String sexo;
    private String nome;
    private String time;

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
