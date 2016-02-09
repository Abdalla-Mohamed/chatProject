/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.mail.service;

/**
 *
 * @author bakar
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailerService {

    public int sendMail(String from, String to, String cc, String bcc, String subject, String message) {

        try {
            Session session = getSession();
            Message mailMessage = new MimeMessage(session);
            mailMessage.setFrom(new InternetAddress(from));

            setRecipients(mailMessage, to, cc, bcc);

            mailMessage.setSubject(subject);

            mailMessage.setSentDate(new Date());
            mailMessage.setText(message);
            mailMessage.saveChanges();
            Transport.send(mailMessage);

        } catch (Exception e) {
            return 0;


        }
        return 1;

    }

    /**
     * Gets the session.
     *
     * @return the session
     */
    private Session getSession() {

        String port = "587";
        final String userName = "jets";//put hs username here
        final String password = "iti36";//put hs pwd here 

        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.user", userName);
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        return session;
    }

    private void setRecipients(Message mailMessage, String to, String cc, String bcc) throws Exception {

        if (mailMessage != null) {
            try {
                if (to != null) {
                    List<InternetAddress> toList = new ArrayList<>();
                    StringTokenizer tokenizer = new StringTokenizer(to, ",");
                    while (tokenizer.hasMoreTokens()) {
                        toList.add(new InternetAddress(tokenizer.nextToken()));
                    }
                    mailMessage.setRecipients(Message.RecipientType.TO,
                            (InternetAddress[]) toList
                            .toArray(new InternetAddress[0]));
                }
                // set CC recipients
                if (cc != null) {
                    List<InternetAddress> ccList = new ArrayList<InternetAddress>();
                    StringTokenizer tokenizer = new StringTokenizer(cc, ",");
                    while (tokenizer.hasMoreTokens()) {
                        ccList.add(new InternetAddress(tokenizer.nextToken()));
                    }
                    mailMessage.setRecipients(Message.RecipientType.CC,
                            (InternetAddress[]) ccList
                            .toArray(new InternetAddress[0]));
                }

                // set BCC recipients
                if (bcc != null) {
                    List<InternetAddress> bccList = new ArrayList<InternetAddress>();
                    StringTokenizer tokenizer = new StringTokenizer(bcc, ",");
                    while (tokenizer.hasMoreTokens()) {
                        bccList.add(new InternetAddress(tokenizer.nextToken()));
                    }
                    mailMessage.setRecipients(Message.RecipientType.BCC,
                            (InternetAddress[]) bccList
                            .toArray(new InternetAddress[0]));
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
