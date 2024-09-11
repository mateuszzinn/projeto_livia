package org.example.utils.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class GmailEmailSender {

    public static void enviarEmail(String emailRemetente, String codigoCupom, int percentualDeDesconto){
        try {
            // Cria o objeto de e-mail
            Email email = new SimpleEmail();

            // Configura o servidor SMTP do Gmail
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465); // Ou 587 se estiver usando TLS

            // Autenticação
            email.setAuthenticator(new DefaultAuthenticator("lima.mateus@academico.ifpb.edu.br", "Mateuscyster2002!"));
            email.setSSLOnConnect(true); // Usa SSL

            // Define remetente e destinatário
            email.setFrom("lima.mateus@academico.ifpb.edu.br");
            email.setSubject("CUPOM DE DESCONTO LIBERADO");
            email.setMsg("Utilize o cupom " + codigoCupom + " para ganhar um desconto de " + percentualDeDesconto + "% " + "em suas compras");
            email.addTo(emailRemetente);

            // Envia o e-mail
            email.send();
            System.out.println("E-mail enviado com sucesso!");

        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        enviarEmail("mateuslima2002.ml@gmail.com", "RF213", 8);
    }
}