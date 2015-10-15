package rango.vote.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@Table(name="administrador")
public class Administrador {

  @Id
  private long idAdministrador;
  private String emailAdministrador;

}
