import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;


import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
//import org.apache.log4j.PropertyConfigurator;


/**
 * M�todo para ir buscar o home timeline do utilizador que faz login na platadorma twitter atrav�s da nossa aplica��o
 * @param Sem quaisquer parametros apenas precisa na inicializa��o do m�todo de tokens gerado pela plataforma de developers da rede social
 * @return Retorna em String a home timeline desse mesmo utilizador
 */
public class TwitterP {
	private int counter;
	ArrayList<String> d = new ArrayList<String>();
	//private static Logger LOG = Logger.getLogger(TwitterP.class);
	
	public TwitterP() {
	}
	

	public ArrayList<String> downloadTweets() throws TwitterException {
		
		try {
			
			int counter = 0;
			ConfigurationBuilder cf = new ConfigurationBuilder();
			
			
			
			cf.setDebugEnabled(true)
			.setOAuthConsumerKey("QWQYmP0PRDWqQTGbuxS0Jobej")
			.setOAuthConsumerSecret("K1IhaH982iaAGVB0VmZGXdBmby1j5U1liNOD9S6xzlVfAWUCvS ")
			.setOAuthAccessToken("2623846510-CohSYBK0eoHUQP88fqPMJRvu3foa9rMDeovrE8n ")
			.setOAuthAccessTokenSecret("Zy2RH1C1TmOXTvMB3NWJCHi0xaKQVBRjOE0D2pzAMJgSI ");
			TwitterFactory tf = new TwitterFactory(cf.build());
			Twitter twitter = tf.getInstance();


			List<Status> status = twitter.getHomeTimeline();
			for (Status st : status) {

				int a = st.getUser().getCreatedAt().getYear();
				int ano = a+1900;
				counter++;
				String y = counter + "|" + st.getUser().getCreatedAt().getDay() + "/" + st.getUser().getCreatedAt().getMonth() + "/" + ano + "|" + "@" +st.getUser().getScreenName() + "|" + st.getText();
				d.add(y);
				System.out.println(y);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return d;
	}

	public int getCounter() {
		return counter;
	}
	public  void setCounter(int a) {
		counter=a;
	}

	public static void main(String[] args) throws TwitterException{
		TwitterP a = new TwitterP();
		a.downloadTweets();
	}
}











