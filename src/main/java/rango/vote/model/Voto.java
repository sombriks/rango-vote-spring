package rango.vote.model;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="voto")
public class Voto implements Serializable {

  private static final long serialVersionUID = 2806425360666625L;

  @Id
  @Temporal(value=TemporalType.DATE)
  private Date dtVoto;
  @Id
  @ManyToOne
  @JoinColumn(name="idmembro")
  private Membro membro;
  @ManyToOne
  @JoinColumn(name="idrestaurante")
  private Restaurante restaurante;

}
