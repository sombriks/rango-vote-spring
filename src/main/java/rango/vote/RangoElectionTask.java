package rango.vote;

import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  This task verifies if the voting is open
*/
@Component
public class RangoElectionTask {

  final Logger logger = LoggerFactory.getLogger(RangoElectionTask.class);

  private boolean votingOpen;

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
}
