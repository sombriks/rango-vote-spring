package rango.vote.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="administrador")
public class Administrador {

  @Id
  private long idAdministrador;

}
