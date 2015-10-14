package rango.vote;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class RangoVoteRepository {

  @PersistenceContext
  private EntityManager em;

}
