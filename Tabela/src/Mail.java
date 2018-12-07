import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jsoup.Jsoup;

/**
 * M�todo para ir buscar todos os e mails
 * 
 * @param Sem quaisquer parametros apenas precisa na inicializa��o do m�todo que
 *            tipo de servi�o de webmail o utilizador que est� a fazer login
 *            usa,o seu mail e a sua password
 * @return Retorna em String todos os e mails na caixa de entrada no utilizador
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jsoup.Jsoup;

/**
 * M?todo para ir buscar todos os e mails
 * 
 * @param Sem quaisquer parametros apenas precisa na inicializa??o do m?todo que
 *            tipo de servi?o de webmail o utilizador que est? a fazer login
 *            usa,o seu mail e a sua password
 * @return Retorna em String todos os e mails na caixa de entrada no utilizador
 */
public class Mail {
	static int msgPretendidas;
	String pophost = "outlook.office365.com";
	String smtphost = "smtp.office365.com";
	String mailStrProt = "pop3";
	String uname = "";
	String pwd = "";
	private PrintWriter escrever;
	ArrayList<String> d = new ArrayList<String>();

	public Mail() {
	}

	public ArrayList<String>  downloadEmails() throws FileNotFoundException {


		try {
			// Set property values
			//			Properties propvals = new Properties();
			//			propvals.put("mail.pop3.host", pophost);
			//			propvals.put("mail.pop3.port", "995");
			//			propvals.put("mail.pop3.starttls.enable", "true");
			//			Session emailSessionObj = Session.getDefaultInstance(propvals);
			//			// Create POP3 store object and connect with the server
			//			Store storeObj = emailSessionObj.getStore("pop3s");
			//			storeObj.connect(pophost, uname, pwd);

//final...
			 String uname = "assrc@iscte-iul.pt";
			 String pwd = "Sherlock221b";
			
			 // Set properties and their values
			Properties propvls = new Properties();

			propvls.put("mail.pop3.host", pophost);
			propvls.put("mail.pop3.starttls.enable", "true");
			propvls.put("mail.pop3.port", "995");
			
			Session emailSessionObj = Session.getDefaultInstance(propvls);
			Store storeObj = emailSessionObj.getStore("pop3s");
			storeObj.connect(pophost, uname, pwd);


			Folder emailFolderObj = storeObj.getFolder("INBOX");
			emailFolderObj.open(Folder.READ_ONLY);

			// Fetch messages from the folder and print in a loop
			Message[] messageobjs = emailFolderObj.getMessages();

			msgPretendidas = 30;
			for (int i = 0; i < msgPretendidas; i++) {
				Message message = messageobjs[i];
				String x = "==============================";
				d.add(x);
				String a = "Email #" + (i + 1);
				d.add(a);
				String b = "Subject: " + message.getSubject();
				d.add(b);
				String c = "From: " + message.getFrom()[0];
				d.add(c);
				String dd = "Text: " + Jsoup.parse(message.getContent().toString()).text();
				d.add(dd);

			}
			emailFolderObj.close(false);
			storeObj.close();

		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return d;
	}

	
	public void sendEmails(String message) {	
		// Declare recipient's & sender's e-mail id.
		String destmailid = "ES1-2018-PL-92@outlook.com";
		String sendrmailid = "assrc@iscte-iul.pt";
		// Mention user name and password as per your configuration
		final String uname = "assrc@iscte-iul.pt";
		final String pwd = "Sherlock221b";
		// Set properties and their values
		Properties propvls = new Properties();
		propvls.put("mail.smtp.auth", "true");
		propvls.put("mail.smtp.starttls.enable", "true");
		propvls.put("mail.smtp.host", smtphost);
		propvls.put("mail.smtp.port", "587");
		// Create a Session object & authenticate uid and pwd
		Session sessionobj = Session.getInstance(propvls, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(uname, pwd);
			}
		});

		try {
			// Create MimeMessage object & set values
			Message messageobj = new MimeMessage(sessionobj);
			messageobj.setFrom(new InternetAddress(sendrmailid));
			messageobj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destmailid));
			messageobj.setText(message);
			// Now send the message
			Transport.send(messageobj);
		} catch (MessagingException exp) {
			throw new RuntimeException(exp);
		}
	}

	public void setMsgPretendidas(int msgPretendidas) {
		this.msgPretendidas = msgPretendidas;
	}

	public int getMsgPretendidas() {
		return msgPretendidas;
	}

}