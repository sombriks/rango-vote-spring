package rango.vote.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="membro")
public class Membro {

  @Id
  private long idMembro;
}
