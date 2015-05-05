
public class Start {

	public static void main(String[] args) {
		 //System.out.println("Hello, world");

		 
		 
		String url="http://localhost:10083/v2/bizvouchers/getlist?nosign=1";
		HttpUtil.HttpPost(url);
	}

}
