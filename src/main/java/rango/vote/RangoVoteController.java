package rango.vote;

import java.util.List;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;

import rango.vote.to.VotingStatus;
import rango.vote.model.Membro;
import rango.vote.model.Restaurante;

@Controller
@RequestMapping("/controller")
public class RangoVoteController {

  @Autowired
  private RangoVoteRepository repo;
  @Autowired
  private RangoElectionTask task;

  @RequestMapping("/getCurrentMember")
  public @ResponseBody Membro getCurrentMember(HttpServletRequest req) throws Exception {
    return (Membro) req.getSession().getAttribute("logado");
  }

  @RequestMapping("/isVotingOpen")
  public @ResponseBody String isVotingOpen() throws Exception {
    return ""+task.isVotingOpen();
  }

  @RequestMapping("/getVotingStatus")
  public @ResponseBody VotingStatus getVotingStatus(HttpServletRequest req) throws Exception {
    Membro m = (Membro) req.getSession().getAttribute("logado");
    VotingStatus vs = new VotingStatus();
    vs.setMembro(m);
    vs.setVotingOpen(task.isVotingOpen());
    vs.setDia(new Date(System.currentTimeMillis()));
    return vs;
  }

  @RequestMapping("/listCandidatos")
  public @ResponseBody List<Restaurante>listCandidatos(@RequestParam("q") String q) throws Exception {
    return repo.listCandidatos(q);
  }

}
