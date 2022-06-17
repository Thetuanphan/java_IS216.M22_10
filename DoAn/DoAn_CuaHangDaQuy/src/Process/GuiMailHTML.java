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
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author votha
 */
public class GuiMailHTML {

    /**
     * @param args the command line arguments
     * @throws javax.mail.MessagingException
     * @throws java.io.UnsupportedEncodingException
     */
     public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {

//        final String fromEmail = "nghenhacvui2022@gmail.com";
//        // Mat khai email cua ban
//        final String password = "hqxmgeorzceilvwh";
//        // dia chi email nguoi nhan
        final String fromEmail = "vothanhdo113114@yahoo.com";
        // Mat khai email cua ban
        final String password = "pifbjnmaifqjvwsd";
        // dia chi email nguoi nhan
        final String toEmail = "vothanhdo20013@gmail.com";

        final String subject = "Java Example Test";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.mail.yahoo.com"); //SMTP Host
        //props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
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
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        message.setSubject(subject);
        
        message.setSubject("Hóa Đơn Mua Hàng");
        String htmlContent = "<meta charset=\"UTF-8\"><h1>Hóa Đơn Mua Hàng</h1> <p>Xin chào khách hàng: .... </p> "
                + "<p>Bạn đã mua hàng tại Cửa hàng Đá quý ABC lúc: ....</p> "
                + "<p>Đây là hóa đơn mua hàng của quý khách </p> "
                + "<table style=\"width:100%; border: 1px solid black; \"> "
                + "<tr> <td><b>Tên sản phẩm</b>"
                + "</td> <td><b>Số lượng</b></td> "
                + "<td><b>Đơn vị</b></td> "
                + "<td><b>Đơn giá</b></td> </tr> "
                + "<tr> <td>Alfreds Futterkiste</td> "
                + "<td>Maria Anders</td> <td>Germany</td> "
                + "<td>Germany</td> </tr> <tr> "
                + "<td>Centro comercial Moctezuma</td> "
                + "<td>Francisco Chang</td> "
                + "<td>Mexico</td> <td>Germany</td> </tr> "
                + "</table> "
                + "<h2>Tổng tiền: ...</h2> "
                + "<h2>Tổng tiền giảm giá: ...</h2> "
                + "<h2>Thành tiền: ...</h2>";
        message.setContent(htmlContent, "UTF-8");
        message.setContent(htmlContent, "text/html");
        
        Transport.send(message);

        System.out.println("Gui mail thanh cong");

    }        

    
}
