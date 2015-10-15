package rango.vote.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@Table(name="restaurante")
public class Restaurante {

  @Id
  private long idRestaurante;
  private String nomeRestaurante;

}
