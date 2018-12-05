import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
 * M�todo para ir buscar todos os e mails
 * 
 * @param Sem quaisquer parametros apenas precisa na inicializa��o do m�todo que
 *            tipo de servi�o de webmail o utilizador que est� a fazer login
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

	public void checkEmail() throws FileNotFoundException {

		File file = new File("mail.txt");
		escrever = new PrintWriter(file);
		try {
			// Set property values
			Properties propvals = new Properties();
			propvals.put("mail.pop3.host", pophost);
			propvals.put("mail.pop3.port", "995");
			propvals.put("mail.pop3.starttls.enable", "true");
			Session emailSessionObj = Session.getDefaultInstance(propvals);
			// Create POP3 store object and connect with the server
			Store storeObj = emailSessionObj.getStore("pop3s");
			storeObj.connect(pophost, uname, pwd);
			// Create folder object and open it in read-only mode
			Folder emailFolderObj = storeObj.getFolder("INBOX");
			emailFolderObj.open(Folder.READ_ONLY);
			// Fetch messages from the folder and print in a loop
			Message[] messageobjs = emailFolderObj.getMessages();

			msgPretendidas = 30;
			for (int i = 0; i < msgPretendidas; i++) {
				Message message = messageobjs[i];
				String x = "==============================";
				escrever.println(x);
				String a = "Email #" + (i + 1);
				escrever.println(a);
				String b = "Subject: " + message.getSubject();
				escrever.println(b);
				String c = "From: " + message.getFrom()[0];
				escrever.println(c);
				String d = "Text: " + Jsoup.parse(message.getContent().toString()).text();
				escrever.println(d);

			}
			emailFolderObj.close(false);
			storeObj.close();
			escrever.close();

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

	}

	public void sendEmails(String message, String destination) {
		// Declare recipient's & sender's e-mail id.
		String destmailid = destination;
		String sendrmailid = "gsssa@iscte-iul.pt";
		// Mention user name and password as per your configuration
		final String uname = "";
		final String pwd = "";
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
			System.out.println("Your email sent successfully....");
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

//	public static void receiveEmail(String pop3Host, String storeType, String user, String password) {
//
//		try {
//			Properties properties = new Properties();
//			properties.put("mail.pop3.host", pop3Host);
//			properties.setProperty("mail.pop3.ssl.enable", "false");
//			properties.setProperty("mail.pop3.starttls.enable", "true");
//			properties.setProperty("mail.pop3.starttls.required", "true");
//			
//			File file = new File("C:/Users/Sofia Cordeiro/git/ES1-2018-PL-92/Tabela/src/mail.txt");
//			PrintWriter escrever = new PrintWriter(file);
//
//			Session emailSession = Session.getDefaultInstance(properties);
//
//			POP3Store emailStore = (POP3Store) emailSession.getStore(storeType);
//			emailStore.connect(user, password);
//
//			Folder emailFolder = emailStore.getFolder("INBOX");
//			emailFolder.open(Folder.READ_ONLY);
//
//			Message[] messages = emailFolder.getMessages();
//			for (int i = 0; i < messages.length; i++) {
//				Message message = messages[i];
//				//System.out.println("==============================");
////				System.out.println("Email #" + (i + 1));
////				System.out.println("Subject: " + message.getSubject());
////				System.out.println("From: " + message.getFrom()[0]);
////				System.out.println("Text: " + message.getContent().toString());
//				String x="==============================";
//				escrever.println(x);
//				String a="Email #" + (i + 1);
//				escrever.println(a);
//				String b="Subject: " + message.getSubject();
//				escrever.println(b);
//				String c="From: " + message.getFrom()[0];
//				escrever.println(c);
//				String d="Text: " + message.getContent().toString();
//				escrever.println(d);
//				
//			}
//			escrever.close();
//			emailFolder.close(false);
//			emailStore.close();
//		} catch (NoSuchProviderException e) {
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
