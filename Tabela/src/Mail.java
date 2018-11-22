

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.swing.JOptionPane;

import com.sun.mail.pop3.POP3Store;

public class Mail {

	public static void main(String[] args) throws FileNotFoundException {


		String mail = "";
		String password = "";
		do {
			mail = JOptionPane.showInputDialog(null,"Insert Mail");
			password = JOptionPane.showInputDialog(null,"Insert Password");
		}while(mail == null || mail.equals(" "));

		String mailPop3Host = "outlook.office365.com";
		String mailStoreType = "pop3";

		File file = new File("C:/Users/Sofia Cordeiro/git/ES1-2018-PL-92/Tabela/src/mail.txt");
		PrintWriter escrever = new PrintWriter(file);

		//receiveEmail(mailPop3Host, mailStoreType, mail, password);

		try {

			Properties properties = new Properties();
			properties.put("mail.pop3.host", mailPop3Host);
			properties.setProperty("mail.pop3.ssl.enable", "false");
			properties.setProperty("mail.pop3.starttls.enable", "true");
			properties.setProperty("mail.pop3.starttls.required", "true");

			Session emailSession = Session.getDefaultInstance(properties);

			POP3Store emailStore = (POP3Store) emailSession.getStore(mailStoreType);
			emailStore.connect(mail, password);

			Folder emailFolder = emailStore.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			Message[] messages = emailFolder.getMessages();
			//for (int i = 0; i < messages.length; i++) {
			for (int i = 0; i < 30; i++) {
				Message message = messages[i];


				String x="==============================";
				escrever.println(x);
				String a="Email #" + (i + 1);
				escrever.println(a);
				String b="Subject: " + message.getSubject();
				escrever.println(b);
				String c="From: " + message.getFrom()[0];
				escrever.println(c);
				String d="Text: " + message.getContent().toString();
				escrever.println(d);

			}	
			emailFolder.close(false);
			emailStore.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		escrever.close();
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

