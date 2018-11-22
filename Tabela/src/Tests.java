import org.junit.Test;

public class Tests {

	@Test
public void test1() {
		Facebook f = new Facebook();
		
		f.setCounter(5);
		int a = f.getCounter5();
		
		assert(a)!=0;
		
		
	}
	@Test
	public void test2() {
			TwitterP f = new TwitterP();
			
			f.setCounter(5);
			int a = f.getCounter();
			
			assert(a)!=0;
			
			
			
		}
	@Test
	public void test3() {
			Mail f = new Mail();
			
			f.setMsgPretendidas(30);
			int a = f.getMsgPretendidas();
			
			assert(a)!=0;
			
			
			
		}	
}
