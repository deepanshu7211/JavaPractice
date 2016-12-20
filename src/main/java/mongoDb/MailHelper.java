package mongoDb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by deepanshu.saxena on 23/08/16.
 */
public class MailHelper {
    private static final Logger logger = LoggerFactory.getLogger(MailHelper.class);

    public static boolean sendMail(String subject, String body, String recipients) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.host", "mail.nm.flipkart.com"); //new

        Session session = Session.getInstance(props);

        try {

            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipients));
            try {
                message.setFrom(new InternetAddress("cs-reports@flipkart.com", "CS-REPORTS"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            message.setSubject(subject);
            message.setContent(body, "text/html; charset=utf-8");
            Transport.send(message);
            logger.info("\n\n************ Mail sent to : " + recipients + " *************\n\n");
            return true;
        } catch (AddressException addressException) {
            logger.error(addressException.getMessage(), addressException);
            return false;
        } catch (MessagingException messageException) {
            logger.error(messageException.getMessage(), messageException);
            return false;
        }
    }
}
