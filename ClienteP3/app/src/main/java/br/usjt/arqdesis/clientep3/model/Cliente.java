package br.usjt.arqdesis.clientep3.model;

import java.io.Serializable;

/**
 * Created by asbonato on 9/18/16.
 */
public class Cliente implements Comparable, Serializable{
    private int id;
    private String nome;
    private String fone;
    private String email;

    public Cliente(){

    }

    public Cliente(int id, String nome, String fone, String email) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto(){
        String foto = email.replace('@','_');
        foto = foto.replace('.','_');
        return foto;
    }

    public String getIniciais(){
        String iniciais = nome.substring(0,1);
        iniciais += nome.substring(nome.lastIndexOf(' ')+1, nome.lastIndexOf(' ')+2);
        return iniciais;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (fone == null) {
            if (other.fone != null)
                return false;
        } else if (!fone.equals(other.fone))
            return false;
        if (id != other.id)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public int compareTo(Object o) {
        return getNome().compareTo(((Cliente)o).getNome());
    }
}
