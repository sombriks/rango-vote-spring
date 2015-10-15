package rango.vote.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@Table(name="equipe")
public class Equipe {

  @Id
  private long idEquipe;
  private String nomeEquipe;
}
