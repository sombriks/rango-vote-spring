package rango.vote;

import java.util.List;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;

import rango.vote.model.ResultadoVotacao;
import rango.vote.model.Restaurante;
import rango.vote.to.VotingStatus;
import rango.vote.model.Membro;
import rango.vote.model.Voto;

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

  @RequestMapping("/listMembros")
  public @ResponseBody List<Membro>listMembros() throws Exception {
    return repo.listMembros();
  }

  @RequestMapping("/login")
  public @ResponseBody Membro login(@RequestBody Membro membro,
    HttpServletRequest req,HttpServletResponse response) throws Exception {
    Membro m = repo.login(membro);
    if(m != null){
      m.setHashSenhaMembro("");
      req.getSession().setAttribute("logado",m);
      return m;
    }else{
      response.setStatus(404);
      return membro;
    }
  }

  @RequestMapping(value="/vote",produces="text/plain")
  public @ResponseBody String vote(@RequestBody Voto voto,HttpServletResponse response) throws Exception {
    Date d = new Date(System.currentTimeMillis());
    if(task.isVotingOpen()){
      voto.setDtVoto(d);
      repo.vote(voto);
      return "OK";
    }else{
      response.setStatus(404);
      return "voteclosed";
    }
  }

  @RequestMapping("/listResultadoVotacao")
  public @ResponseBody List<ResultadoVotacao>listResultadoVotacao() throws Exception {
    return repo.listResultadoVotacao(new Date(System.currentTimeMillis()));
  }
}
