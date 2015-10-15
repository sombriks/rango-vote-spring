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
@Table(name="vw_resultado_votacao")
public class ResultadoVotacao implements Serializable {

  private static final long serialVersionUID = 999664253605L;

  @Id
  @Temporal(value=TemporalType.DATE)
  private Date dtVoto;
  @Id
  @ManyToOne
  @JoinColumn(name="idrestaurante")
  private Restaurante restaurante;
  private long totVotos;
}
