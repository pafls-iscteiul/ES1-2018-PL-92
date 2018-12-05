import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
* M�todo para ir buscar o home timeline do utilizador que faz login na platadorma twitter atrav�s da nossa aplica��o
* @param Sem quaisquer parametros apenas precisa na inicializa��o do m�todo de tokens gerado pela plataforma de developers da rede social
* @return Retorna em String a home timeline desse mesmo utilizador
*/
public class TwitterP {
	private int counter;
	public static void main(String[] args) throws TwitterException, FileNotFoundException {

		ConfigurationBuilder cf = new ConfigurationBuilder();

		cf.setDebugEnabled(true)
		.setOAuthConsumerKey("opHZz0MqPiFIEN2nHGQ9E4ZyF")
		.setOAuthConsumerSecret("HuDA5io6m8obRrWGkGjvwuIH8RpUcPFLsM0vI3YupVGstR4sZK")
		.setOAuthAccessToken("2623846510-PxbyFaGaOXWry5BuYBk3CO99LVXU0Yf4OBdlHx6")
		.setOAuthAccessTokenSecret("9mbw9zjBeoEVKbV2WukbUycWemkZhQ9MLdquUq0t9sOXn");

		TwitterFactory tf = new TwitterFactory(cf.build());
		Twitter twitter = tf.getInstance();
		int counter = 0;

		File file = new File("C:/Users/gabrielaamaral/git/ES1-2018-PL-92/Tabela/src/tweets.txt");
	
		PrintWriter escrever = new PrintWriter(file);

		List<Status> status = twitter.getHomeTimeline();
		for(Status st : status) {

			int a = st.getUser().getCreatedAt().getYear();
			int ano = a+1900;
			counter++;
			CharSequence cs = "RT @";
			if(st.getText().contains(cs)) { //Retweets
				String[] s = st.getText().split("@");
				String mensagem = s[1];
				System.out.println(counter + "|" + st.getUser().getCreatedAt().getDay() + "/" + st.getUser().getCreatedAt().getMonth() + "/" + ano + "|" + "@" +st.getUser().getScreenName() + "|" + mensagem);
				String x = counter + "|" + st.getUser().getCreatedAt().getDay() + "/" + st.getUser().getCreatedAt().getMonth() + "/" + ano + "|" + "@" +st.getUser().getScreenName() + "|" + mensagem;
				escrever.println(x);
			}
			if(st.getText().startsWith("RT @")==false) { //Tweets
				System.out.println(counter + "|" + st.getUser().getCreatedAt().getDay() + "/" + st.getUser().getCreatedAt().getMonth() + "/" + ano + "|" + "@" +st.getUser().getScreenName() + "|" + st.getText());
				String y = counter + "|" + st.getUser().getCreatedAt().getDay() + "/" + st.getUser().getCreatedAt().getMonth() + "/" + ano + "|" + "@" +st.getUser().getScreenName() + "|" + st.getText();
				escrever.println(y);
			}
		}
		escrever.close();
	}
	public int getCounter() {
		return counter;
	}
	public  void setCounter(int a) {
		counter=a;
	}
}











//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.List;
//
//
//import twitter4j.Status;
//import twitter4j.Twitter;
//import twitter4j.TwitterFactory;
//import twitter4j.conf.ConfigurationBuilder;
//
//public final class TwitterP  {
//	private static final String tweet = "C:/Users/Sofia Cordeiro/git-workspace/PCD p/src/tweets.txt";
//
//	public static void main(String[] args) {
//		BufferedWriter bw = null;
//		FileWriter fw = null;
//
//		try {
//			ConfigurationBuilder cb = new ConfigurationBuilder();
//			cb.setDebugEnabled(true)
//			.setOAuthConsumerKey("XQX3B9NabTpt22XPA1wVnU0rr")
//			.setOAuthConsumerSecret("JRgpovYSY2oIc3YgRQlFbUT1B4UVFlPMFnuUSHQImVR0Krl9Wh")
//			.setOAuthAccessToken("2623846510-UhtiJQUOJA8gBUC6j9YHaUqs6JZPjlJi1942gT3")
//			.setOAuthAccessTokenSecret("gSRrFiMvkgKm3Hc29zcqu4fSt6s08EBJahaqXjdWPgQ9n");
//			
//			TwitterFactory tf = new TwitterFactory(cb.build());
//			Twitter twitter = tf.getInstance();        		
//			List<Status> statuses = twitter.getHomeTimeline();
//
//			int counter=0;
//			int counterTotal = 0;
//			for (Status status : statuses) {
//				// Filters only tweets from user "catarina"
//				if (status.getUser().getName() != null ){
//						//&& status.getUser().getName().contains("Drake")) {
//
//					System.out.println(status.getUser().getName() + ":" + status.getText());
//					
//					String a = new String (status.getUser().getName() + ":" + status.getText());
//					System.out.println(a);
//					
//					fw = new FileWriter(tweet);
//					
//					bw = new BufferedWriter(fw);
//					bw.write(a);
//					
//					
//					counter++;
//				}
//				counterTotal++;
//			}
//			System.out.println("-------------\nN� of Results: " + counter+"/"+counterTotal);
//		} catch (Exception e) { 
//			System.out.println(e.getMessage()); 
//			e.printStackTrace();
//		}
//		finally {
//
//			try {
//
//				if (bw != null)
//					bw.close();
//
//				if (fw != null)
//					fw.close();
//
//			} catch (IOException ex) {
//
//				ex.printStackTrace();
//
//			}
//		}
//	}
//
//
//
//}
