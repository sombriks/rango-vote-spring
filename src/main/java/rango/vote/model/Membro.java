package rango.vote.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Entity
@Table(name="membro")
public class Membro {

  @Id
  private long idMembro;
  private String emailMembro;
  private String hashSenhaMembro;
  @ManyToOne
  @JoinColumn(name="idequipe")
  private Equipe equipe;

}
