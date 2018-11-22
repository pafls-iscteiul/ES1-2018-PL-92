import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Version;
import com.restfb.types.Post;
import com.restfb.types.User;
/**
 * Método para ir buscar a timeline de um utilizador do facebook
 * @param Sem quaisquer parametros apenas precisa na inicialização do método de tokens gerado pela plataforma de developers da rede social
 * @return Retorna em String o feed de um utilizador da rede social
 */

public class Facebook {
	@SuppressWarnings("deprecation")
	private int counter5;
	public static void main(String[] args) throws FileNotFoundException {
		//1 e 2
		//		String accessToken2 = "EAAbbSpTKksgBAF4fZAn8yaeSusoPfRoNMD8pQbNF9UBYn0Q7VY0umZCtDM2f5YRcN7AjU1WW9J00tTO4fTPZAaF28J5AL6kjkwuNbf0trZBt3QgB1DwzCCbiiM8NSdAHxhtSkOKr3Ej5TW1yzOZC8HM2BniTZCIjbMxWZBLs2eYcdeytpbyaOSv4KXDWlg3K3QZD";
		//		FacebookClient fbClient2 = new DefaultFacebookClient(accessToken2, Version.VERSION_2_11); 
		//		User me2 = fbClient2.fetchObject("me", User.class);
		//		System.out.println("Facebook:");
		//		System.out.println("Id: " + me2.getId());
		//		System.out.println("Name: " + me2.getName());
		//4

		//		String accessToken4 = "EAAbbSpTKksgBAF4fZAn8yaeSusoPfRoNMD8pQbNF9UBYn0Q7VY0umZCtDM2f5YRcN7AjU1WW9J00tTO4fTPZAaF28J5AL6kjkwuNbf0trZBt3QgB1DwzCCbiiM8NSdAHxhtSkOKr3Ej5TW1yzOZC8HM2BniTZCIjbMxWZBLs2eYcdeytpbyaOSv4KXDWlg3K3QZD";
		//		FacebookClient fbClient4 = new DefaultFacebookClient(accessToken4);
		//		
		//		//Extends the time of the token
		//		AccessToken extendedAccessToken = fbClient4.obtainExtendedAccessToken("2325828974156593","9ede8f285c28e64c0ca5adc333c4a13d");
		//		System.out.println("ExtendedAccessToken: "+extendedAccessToken.getAccessToken());
		//		System.out.println("Expires: " + extendedAccessToken.getExpires());
		//		//5

		String accessToken5 ;
		accessToken5 = "EAAbbSpTKksgBAF4fZAn8yaeSusoPfRoNMD8pQbNF9UBYn0Q7VY0umZCtDM2f5YRcN7AjU1WW9J00tTO4fTPZAaF28J5AL6kjkwuNbf0trZBt3QgB1DwzCCbiiM8NSdAHxhtSkOKr3Ej5TW1yzOZC8HM2BniTZCIjbMxWZBLs2eYcdeytpbyaOSv4KXDWlg3K3QZD";	
		FacebookClient fbClient5 = new DefaultFacebookClient(accessToken5);
		//Print the posts of the time line
		Connection<Post> result = fbClient5.fetchConnection("me/feed",Post.class);
		//System.out.println("\nPosts:");

		File file = new File("C:/Users/Sofia Cordeiro/git/ES1-2018-PL-92/Tabela/src/postsFacebook.txt");
		PrintWriter escrever = new PrintWriter(file);
		
		int counter5 = 1;
		
		//int counterTotal = 0;
		for (List<Post> page : result) {
			for (Post aPost : page) {
				//print the posts with the word ISCTE
				//if (aPost.getMessage() != null && aPost.getMessage().contains("ISCTE")) {
				if (aPost.getMessage() != null && counter5<=15) {
					String x= "---- Post "+ counter5 + " ----";
					escrever.println(x);
					String a="Id: "+"fb.com/"+aPost.getId();
					escrever.println(a);
					String b="Message: "+aPost.getMessage();
					escrever.println(b);
					String c="Created: "+aPost.getCreatedTime();
					escrever.println(c);
					counter5++;
				}
				//counterTotal++;
			}
		}
		escrever.close();
		//System.out.println("-------------\number of Results: " + counter5+"/"+counterTotal);		
	}
	public int getCounter5() {
		return counter5;
	}
	public  void setCounter(int a) {
		counter5=a;
	}
}
