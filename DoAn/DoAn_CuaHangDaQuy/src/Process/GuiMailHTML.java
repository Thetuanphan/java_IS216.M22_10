/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author votha
 */
public class GuiMailHTML {

    public void GuiHoaDon(String nguoiN, String noiD) throws AddressException, MessagingException, UnsupportedEncodingException {
                final String fromEmail = "cuahangdaquyabc@gmail.com";
//        // Mat khai email cua ban
        final String password = "mpomuveaaaefsjyd";
//        // dia chi email nguoi nhan
//        final String fromEmail = "vothanhdo113114@yahoo.com";
        // Mat khai email cua ban
//        final String password = "pifbjnmaifqjvwsd";
        // dia chi email nguoi nhan
        final String toEmail = nguoiN;



        Properties props = new Properties();
        //props.put("mail.smtp.host", "smtp.mail.yahoo.com"); //SMTP Host
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail, "Cửa Hàng Đá Quý ABC"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        message.setHeader("Content-Type", "text/plain; charset=utf-8");
        message.setSubject("Hóa Đơn Mua Hàng Ngày: " + java.time.LocalDate.now() + " " +java.time.LocalTime.now());
        String htmlContent = noiD;
        message.setContent(htmlContent, "text/html; charset=utf-8");

        Transport.send(message);

        System.out.println("Gui mail thanh cong");

    }
}
