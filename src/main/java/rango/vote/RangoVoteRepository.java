package rango.vote;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import rango.vote.model.Restaurante;

@Repository
public class RangoVoteRepository {

  @PersistenceContext
  private EntityManager em;

  public List<Restaurante>listCandidatos(String search) throws Exception {
    // XXX adicionar detalhes a esta query
    String q = "select r from Restaurante r where upper(r.nomeRestaurante) like upper(:n) ";
    return em.createQuery(q,Restaurante.class)//
      .setParameter("n","%"+search+"%").getResultList();
  }

}
