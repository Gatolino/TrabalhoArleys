package fja.edu.com.artbahia.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObraDTO {
    public int Id;
    public String Titulo;
    public int IdUsuario;
    public int Tipo;
    public int Curtidas;

    public ObraDTO(){

    }

    public ObraDTO(int id, String titulo, int idUsuario, int tipo, int curtidas){
        this.Id = id;
        this.Titulo = titulo;
        this.IdUsuario = idUsuario;
        this.Tipo = tipo;
        this.Curtidas = curtidas;
    }
}