package rango.vote;

import rango.vote.model.Membro;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/controller")
public class RangoVoteController {

  @Autowired
  private RangoVoteRepository repo;
  @Autowired
  private RangoElectionTask task;

  @RequestMapping("/getCurrentMember")
  public @ResponseBody Membro getCurrentMember(HttpServletRequest req) throws Exception {
    return (Membro) req.getAttribute("logado");
  }

  @RequestMapping("/isVotingOpen")
  public @ResponseBody String isVotingOpen(HttpServletRequest req) throws Exception {
    return ""+task.isVotingOpen();
  }
}
