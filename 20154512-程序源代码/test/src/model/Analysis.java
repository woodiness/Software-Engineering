package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Analysis {
	private String cardreader_Id;
	private String cardreader_name;
	private float percent_frequency;
	private float percent_money;
	private float number;
	private float money;
	private String suggestion;
	public String getsuggestion() {
		return suggestion;
	}

	public void set_suggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public void OnePlus(float money) {
		this.number+=1;
		this.money+=money;
	}
	public String getcardreader_Id() {
		return cardreader_Id;
	}

	public void set_cardreader_Id(String cardreader_Id) {
		this.cardreader_Id = cardreader_Id;
	}
	public String cardreader_name() {
		return cardreader_name;
	}

	public void set_cardreader_name(String cardreader_name) {
		this.cardreader_name = cardreader_name;
	}

	public float percent_frequency() {
		return  percent_frequency;
	}

	public void set_percent_frequency(float percent_frequency) {
		this.percent_frequency = percent_frequency;
	}

	public float percent_money() {
		return percent_money;
	}

	public void set_percent_money(float percent_money) {
		this.percent_money = percent_money;
	}

	public float number() {
		return number;
	}

	public void set_number(float number) {
		this.number = number;
	}
	public float money() {
		return money;
	}

	public void set_money(float money) {
		this.money = money;
	}
    public String encryption(String plainText) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
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

}
