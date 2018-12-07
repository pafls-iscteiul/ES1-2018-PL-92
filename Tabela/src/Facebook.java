import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Version;
import com.restfb.types.Post;
import com.restfb.types.User;
/**
 * M�todo para ir buscar a timeline de um utilizador do facebook
 * @param Sem quaisquer parametros apenas precisa na inicializa��o do m�todo de tokens gerado pela plataforma de developers da rede social
 * @return Retorna em String o feed de um utilizador da rede social
 */

public class Facebook {
	@SuppressWarnings("deprecation")
	private int counter5;
	
	
	public Facebook() {
		
	}
	
public ArrayList<String> downloadFeed() {
		
		ArrayList<String> d = new ArrayList<String>();
		String accessToken5 ;
		accessToken5 = "EAAhDVEHQGzEBAG2CImrY8eg2vt0a7SZCoIRIUWAMxZCOX0eMWZBS27yGJUQCdTTTlehpD7WMlPfoZCZB29jxPMckmSk5Un4CZBYVDOiBxOyC9DYpRfwfvgVWomnZB1HMRW75E1CtDX9smYhDHXsjeL7f4SVmYk3JmZAfxHc0CVtOBKQM8LoBaZAZAjto0X7mgoMBYvFemZBnRrohgZDZD";
		FacebookClient fbClient5 = new DefaultFacebookClient(accessToken5, Version.VERSION_3_2);
		Connection<Post> result = fbClient5.fetchConnection("me/feed",Post.class);
		
		int counter5 = 1;
		
		
		for (List<Post> page : result) {
			for (Post aPost : page) {
				//print the posts with the word ISCTE
				//if (aPost.getMessage() != null && aPost.getMessage().contains("ISCTE")) {
				if (aPost.getMessage() != null && counter5<=15) {
					String x= "---- Post "+ counter5 + " ----";
					d.add(x);
					String a="Id: "+"fb.com/"+aPost.getId();
					d.add(a);
					String b="Message: "+aPost.getMessage();
					d.add(b);
					String c="Created: "+aPost.getCreatedTime();
					d.add(c);
					counter5++;
				}
				//counterTotal++;
			}
		}
		
		return d;
	}

	public int getCounter5() {
		return counter5;
	}
	public  void setCounter(int a) {
		counter5=a;
	}
}