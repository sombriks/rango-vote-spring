package rango.vote.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="restaurante")
public class Restaurante {

  @Id
  private long idRestaurante;
  private String nomeRestaurante;

  public long getIdRestaurante(){
    return idRestaurante;
  }

  public void setIdRestaurante(long idRestaurante){
    this.idRestaurante=idRestaurante;
  }

  public String getNomeRestaurante(){
    return nomeRestaurante;
  }

  public void setNomeRestaurante(String nomeRestaurante){
    this.nomeRestaurante=nomeRestaurante;
  }
}
