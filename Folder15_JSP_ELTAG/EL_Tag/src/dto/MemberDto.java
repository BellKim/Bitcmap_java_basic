package dto;

import com.sun.org.apache.xml.internal.utils.SerializableLocatorImpl;

public class MemberDto extends SerializableLocatorImpl {
	private String message;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MemberDto [message=" + message + "]";
	}
	
	
	
	
}//end class
