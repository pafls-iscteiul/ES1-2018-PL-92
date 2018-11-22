
import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Version;
import com.restfb.types.Post;
import com.restfb.types.User;

public class FacebookP {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//1 e 2
		String accessToken2 = "EAAD6FDNEHcwBADTjVbxQU28Peizjk8D1IT9nakBG3XfrPuZACcBe4tXR7Q354AtD8dJgh0xZCuxQYlpZBpWhIC1AHGjgzVjwCW8wKEVdVPWUxYR3q70OeZBTg56vGWQaWvpLNEicyL8xncXwaL1zZBFauPLDEdlvPlC81BoYwj9E5kBSzix1AMtD3A4XIQDfQBRHd8nwbcAZDZD";
		FacebookClient fbClient2 = new DefaultFacebookClient(accessToken2, Version.VERSION_2_11); //pus versao
		User me2 = fbClient2.fetchObject("me", User.class);
		System.out.println("Facebook:");
		System.out.println("Id: " + me2.getId());
		System.out.println("Name: " + me2.getName());
		//4
		
		String accessToken4 = "EAAD6FDNEHcwBADTjVbxQU28Peizjk8D1IT9nakBG3XfrPuZACcBe4tXR7Q354AtD8dJgh0xZCuxQYlpZBpWhIC1AHGjgzVjwCW8wKEVdVPWUxYR3q70OeZBTg56vGWQaWvpLNEicyL8xncXwaL1zZBFauPLDEdlvPlC81BoYwj9E5kBSzix1AMtD3A4XIQDfQBRHd8nwbcAZDZD";
		FacebookClient fbClient4 = new DefaultFacebookClient(accessToken4);
		
		//Extends the time of the token
		AccessToken extendedAccessToken = fbClient4.obtainExtendedAccessToken("2325828974156593","9ede8f285c28e64c0ca5adc333c4a13d");
		System.out.println("ExtendedAccessToken: "+extendedAccessToken.getAccessToken());
		System.out.println("Expires: " + extendedAccessToken.getExpires());
		//5
		
		String accessToken5 ;
		accessToken5 = "EAAD6FDNEHcwBADTjVbxQU28Peizjk8D1IT9nakBG3XfrPuZACcBe4tXR7Q354AtD8dJgh0xZCuxQYlpZBpWhIC1AHGjgzVjwCW8wKEVdVPWUxYR3q70OeZBTg56vGWQaWvpLNEicyL8xncXwaL1zZBFauPLDEdlvPlC81BoYwj9E5kBSzix1AMtD3A4XIQDfQBRHd8nwbcAZDZD";	
		FacebookClient fbClient5 = new DefaultFacebookClient(accessToken5);

		//Print the posts of the time line
		Connection<Post> result = fbClient5.fetchConnection("me/feed",Post.class);
		System.out.println("\nPosts:");
		
		
		int counter5 = 0;
		int counterTotal = 0;
		for (List<Post> page : result) {
			for (Post aPost : page) {
				//print the posts with the word ISCTE
				if (aPost.getMessage() != null && aPost.getMessage().contains("ISCTE")) {
					System.out.println("---- Post "+ counter5 + " ----");
					System.out.println("Id: "+"fb.com/"+aPost.getId());
					System.out.println("Message: "+aPost.getMessage());
					System.out.println("Created: "+aPost.getCreatedTime());
					counter5++;
				}
				counterTotal++;
			}
		}
		System.out.println("-------------\number of Results: " + counter5+"/"+counterTotal);		
	}
}
