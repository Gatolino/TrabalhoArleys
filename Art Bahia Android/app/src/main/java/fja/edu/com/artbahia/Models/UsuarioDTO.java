package fja.edu.com.artbahia.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO {
    public int Id;
    public String Login;
    public String Senha;
    public String Nome;
    public boolean IsArtista;

    public UsuarioDTO(){

    }

    public UsuarioDTO(int id, String login, String senha, String nome,  boolean isArtista){
        this.Id = id;
        this.Login = login;
        this.Senha = senha;
        this.Nome = nome;
        this.IsArtista = isArtista;
    }
}