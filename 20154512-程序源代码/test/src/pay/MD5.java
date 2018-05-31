package pay;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5 {
public static String encryption(String plain) {
String re_md5 = new String();
try {
MessageDigest md = MessageDigest.getInstance("MD5");
md.update(plain.getBytes());
byte b[] = md.digest();

int i;

StringBuffer buf = new StringBuffer("");
for (int offset = 0; offset < b.length; offset++) {
i = b[offset];
if (i < 0)
i += 256;
if (i < 16)
buf.append("0");
buf.append(Integer.toHexString(i));
}

re_md5 = buf.toString();

} catch (NoSuchAlgorithmException e) {
e.printStackTrace();
}
return re_md5;
}
public static boolean checkPayKey(PaySaPi paySaPi) {
	String key = "";
	if (paySaPi.getOrderid()!=null) {
		key += paySaPi.getOrderid();
	}
	if (paySaPi.getOrderuid()!=null) {
		key += paySaPi.getOrderuid();
	}
	if (paySaPi.getPaysapi_id()!=null) {
		key += paySaPi.getPaysapi_id();
	}
	if (paySaPi.getPrice()!=null) {
		key += paySaPi.getPrice();
	}
	if (paySaPi.getRealprice()!=null) {
		key += paySaPi.getRealprice();
	}
	key += "bf1e63aa4a7cdc1f4b8886c1782909b7";
	return paySaPi.getKey().equals(MD5.encryption(key));
}
}