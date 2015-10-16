package rango.vote;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rango.vote.model.ResultadoVotacao;
import rango.vote.model.Restaurante;
import rango.vote.model.Membro;
import rango.vote.model.Voto;

@Repository
public class RangoVoteRepository {

  @PersistenceContext
  private EntityManager em;

  public List<Restaurante>listCandidatos(String search) throws Exception {
    // XXX adicionar detalhes a esta query
    String q = "select r from Restaurante r where upper(r.nomeRestaurante) like upper(:n)";
    return em.createQuery(q,Restaurante.class)//
      .setParameter("n","%"+search+"%").getResultList();
  }

  public List<Membro>listMembros() throws Exception {
    return em.createQuery("select m from Membro m",Membro.class).getResultList();
  }

  public Membro login(Membro membro) throws Exception {
    if(membro==null)
      return null;
    String email = membro.getEmailMembro();
    String hash = membro.getHashSenhaMembro();
    String q = "select m from Membro m where m.emailMembro = :email and m.hashSenhaMembro = :hash";
    return em.createQuery(q,Membro.class)//
      .setParameter("email",email).setParameter("hash",hash).getSingleResult();
  }

  @Transactional
  public void vote(Voto voto) throws Exception {
    em.persist(voto);
  }

  public List<ResultadoVotacao>listResultadoVotacao(Date dtResultado) throws Exception {
    String q = "select r from ResultadoVotacao r where r.dtVoto = :dtResultado";
    return em.createQuery(q,ResultadoVotacao.class)//
      .setParameter("dtResultado",dtResultado).getResultList();
  }

  public List<String>listMemberMail() throws Exception {
    String q = "select m.emailMembro from Membro m";
    return em.createQuery(q,String.class).getResultList();
  }
}
