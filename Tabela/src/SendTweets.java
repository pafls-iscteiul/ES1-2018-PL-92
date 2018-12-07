
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;



public class SendTweets {
	//private static Logger LOG = Logger.getLogger(SendTweets.class);

	public void PostingToTwitter(String message) throws TwitterException{

		ConfigurationBuilder cf = new ConfigurationBuilder();

		cf.setDebugEnabled(true)
		.setOAuthConsumerKey("QWQYmP0PRDWqQTGbuxS0Jobej")
		.setOAuthConsumerSecret("K1IhaH982iaAGVB0VmZGXdBmby1j5U1liNOD9S6xzlVfAWUCvS ")
		.setOAuthAccessToken("2623846510-CohSYBK0eoHUQP88fqPMJRvu3foa9rMDeovrE8n ")
		.setOAuthAccessTokenSecret("Zy2RH1C1TmOXTvMB3NWJCHi0xaKQVBRjOE0D2pzAMJgSI ");

		TwitterFactory tf = new TwitterFactory(cf.build());
		Twitter twitter = tf.getInstance();

		twitter.updateStatus(message);
		
		
	}
}