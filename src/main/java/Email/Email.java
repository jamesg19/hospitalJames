/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author james
 */
public class Email {
    
    
    public void Email(String destino, String Mensaje, String Asunto) {
        try {
            //obtiene propiedades del sistema
            //defino el correo y la contrasena 
            final String username = "hospitalcunoc2020@gmail.com";
            final String password = "USAC2020";
            //conexion hacia google
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {

                //Define el mensaje y su estructura 
                // y se introduce el destinatario a donde se envia el correo
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setSubject(Asunto);
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
                message.setText(Mensaje);
                // Y por ultimo envia el mensaje a su destino
                Transport.send(message);
            } catch (Exception e) {
            }
        } catch(Exception e){
            
        }

    }

}
    
    

