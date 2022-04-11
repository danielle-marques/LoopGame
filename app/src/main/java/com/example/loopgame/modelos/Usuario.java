package com.example.loopgame.modelos;

public class Usuario implements Cloneable{
    private int id;
    private String login;
    private String password;
    private String pontuacao;

    public Usuario(){}

    public Usuario(String login, String password){
        this.login = login;
        this.password = password;

    }

    public Usuario(int id, String login, String password){
        this.id = id;
        this.login = login;
        this.password = password;

    }

    public Usuario(int id, String login, String password, String pontuacao){
        this.id = id;
        this.login = login;
        this.password = password;
        this.pontuacao = pontuacao;
    }

    public Usuario(String login, String password, String pontuacao){
        this.login = login;
        this.password = password;
        this.pontuacao = pontuacao;
    }

    public Usuario(Usuario u){
        this.id = u.id;
        this.login = u.login;
        this.password = u.password;
        this.pontuacao = u.pontuacao;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getLogin(){
        return this.login;
    }

    public void setLogin(String l){
        this.login = l;
    }

    public String getSenha(){
        return this.password;
    }

    public void setSenha(String s){
        this.password = s;
    }

    public String getPontos(){
        return this.pontuacao;
    }

    public void setPontos(String p){

        this.pontuacao = p;
    }

    @Override
    public Object clone(){

        Usuario clone = new Usuario(this);
        return clone;
    }
}
