package rango.vote;

import java.util.List;
import java.sql.Time;
import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import rango.vote.model.ResultadoVotacao;

/**
  This task verifies if the voting is open
*/
@Component
public class RangoElectionTask {

  final Logger logger = LoggerFactory.getLogger(RangoElectionTask.class);

  private boolean votingOpen;

  @Autowired
  private RangoVoteRepository repo;

  @Autowired
  private MailService mail;

  public boolean isVotingOpen(){
    return votingOpen;
  }

  public boolean doVerify(Date day,Time now,Time start,Time end){
    return now.after(start) && now.before(end);
  }

  @Scheduled(cron="0/3 * * * * MON-FRI")
  public void verify(){
    Date day = new Date(System.currentTimeMillis());
    Time now = new Time(System.currentTimeMillis());
    Time start = Time.valueOf("09:00:00");
    Time end = Time.valueOf("11:30:00");
    votingOpen = doVerify(day,now,start,end);
    logger.info("Voting for {} is {}",day,votingOpen ? "Open" : "Closed");
  }

  @Scheduled(cron="* 30 9 * * MON-FRI")
  public void notifyOpenVoting() throws Exception {
    logger.info("Voting now open");
    Date day = new Date(System.currentTimeMillis());
    String subject = day+" - Rango Vote - votação aberta";
    String text = "Visite o site do Rango Vote e dê seu voto!";
    List<String>emails=repo.listMemberMail();
    mail.doSend(subject,text,emails);
  }

  @Scheduled(cron="* 30 11 * * MON-FRI")
  public void notifyCloseVoting() throws Exception {
    logger.info("Voting now closed");
    Date day = new Date(System.currentTimeMillis());
    String subject = day+" - Rango Vote - votação encerrada";
    String text = "Não houve votação expressiva hoje...";
    List<ResultadoVotacao>list=repo.listResultadoVotacao(day);
    if(list!=null && list.size()>0){
      ResultadoVotacao winner = list.get(0);
      String nomeRestaurante = winner.getRestaurante().getNomeRestaurante();
      text = "Hoje o almoço é no "+nomeRestaurante;
    }
    List<String>emails=repo.listMemberMail();
    mail.doSend(subject,text,emails);
  }
}
