package rango.vote;

import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskExecutorExample {

    @Scheduled(cron="0/1 * * * * MON-FRI")
    public void foo(){
      System.out.println("Boo");
    }

}
