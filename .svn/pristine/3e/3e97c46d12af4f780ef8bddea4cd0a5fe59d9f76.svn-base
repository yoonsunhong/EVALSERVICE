package retail.seed;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * @author moon
 * @version 1.0, 2017. 10. 10
 */


@SuppressWarnings("restriction")
public class SeedTest {

	public static void main(String[] args) throws Exception {
		String text = "유레카 암호화 테스트 SEED 128";
		
		//KEY는 반드시 16byte로 맞추어야 한다. SEED암호화 법칙
		String key = "ureka_20_project";
		StringBuilder trace = new StringBuilder();
		
		trace.append("Plain Text :: [").append(text).append("]");
		System.out.println(trace.toString());
		
		SeedCipher seed = new SeedCipher();
		//암호화
		String encryptText = Base64.encode(seed.encrypt(text, key.getBytes(), "UTF-8"));

		trace = new StringBuilder();
		trace.append("Encrypt Text (Base64 Encoding) :: [").append(encryptText).append("]");
		System.out.println(trace.toString());
		
		//복호화
		byte[] encryptbytes = Base64.decode(encryptText);
		String decryptText = seed.decryptAsString(encryptbytes, key.getBytes(), "UTF-8");
		
		trace = new StringBuilder();
		trace.append("Decrypt Text :: [").append(decryptText).append("]");
		System.out.println(trace.toString());
	}
}
