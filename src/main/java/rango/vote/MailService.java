package rango.vote;

import java.util.List;
import java.util.stream.Collectors;

import javax.mail.Message;
import javax.mail.Address;
import javax.mail.Message.RecipientType;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import rango.vote.model.ResultadoVotacao;

import lombok.SneakyThrows;
/**
 * It does the dirty part about send emails around there
 */
@Component
public class MailService {

  @Autowired
  @Qualifier("mailSender")
  private JavaMailSender sender;

  /*
    O construtor de InternetAddress joga exceção,
    logo precisamos desse wrapper aqui
   */
  @SneakyThrows
  public InternetAddress checkedAddress(String mail){
    return new InternetAddress(mail);
  }

  public void doSend(String subject,String text,List<String> emails) throws Exception {
    if(emails!=null && emails.size()>0){
      Address[]recipients = emails.stream()//
        .map(a -> checkedAddress(a))//
        .collect(Collectors.toList())//
        .toArray(new Address[0]);
      MimeMessage mess = sender.createMimeMessage();
      mess.setSubject(subject);
      mess.setText(text);
      mess.addRecipients(RecipientType.TO,recipients);
      sender.send(mess);
    }
    //else silent end
  }

}
