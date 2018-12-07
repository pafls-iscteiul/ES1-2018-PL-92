
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import com.restfb.types.GraphResponse;
import com.restfb.types.Post;

public class SendPost {
	String post;
	//String accessToken5= "EAAbbSpTKksgBAIZA506KiDfJyaxWUufYgMn58TZC95ceZCT7oRRBDIio30HHUU32S3EYvOyRgDCc9GVJYOwZBUnp9r4c73xLZAx6kdRLeAhjuHntF7QiPjNPsZBTr5cD6C3M6107Nirw3pbwTMugBZBXVjGPgeetraarDMe1YxFfOCpoOJ9g3vYKEr2dTJGCvwZD";
	String accessToken5= "EAAhDVEHQGzEBAEytg1q6aX0UMvkYHxBsMqQYREvw1xUopeVXRCMa2fixv5d8ZBXkfOOyM5KA4e5QrZCzfkBdAVZCGOprdAss4gZBt2s2TSFAvCjeswStGvZCp9ZCtMWHymL7lJcTrJoTr97SHZBG2daDh84ckNqJ3TCAYs1R6S9zz3PdzqL3KMjqY2JRQ4NyaaOvEShREZAvNgZDZD";
	public void PostingToFacebook(String post) {

		this.post=post;
		FacebookClient fbClient5 = new DefaultFacebookClient(accessToken5);
		Connection<Post> result = fbClient5.fetchConnection("me/feed",Post.class);
		
		GraphResponse publishMessageResponse = fbClient5.publish("me/feed", GraphResponse.class, Parameter.with("message", post));
		fbClient5.publish("me/feed", FacebookType.class, Parameter.with("message", post));

	}
	
}