import java.io.*;
public class User implements Serializable {
	
	private String Username;
	private String Password;
		
	public User(String username, String password) {
		super();
		Username = username;
		Password = password;
	}
	public String getUsername() {
		return Username;
	}
	public String getPassword() {
		return Password;
	}
	
	
}
