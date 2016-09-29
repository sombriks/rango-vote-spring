package rango.vote;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/META-INF/test-applicationContext.xml")
public class ShouldSendMailTest {

  //@Autowired
  private MailService mail;

  @Test
  public void sendMeSomeTest() throws Exception {
    // List<String> emails = new ArrayList<>();
    // emails.add("sombriks@gmail.com");
    // String subject = "teste";
    // String text = "teste";
    // mail.doSend(subject,text,emails);
    //Só para testar
  }

}
