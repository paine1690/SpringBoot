package psxt.mode;

import lombok.Data;

@Data
public class User {
	private int id;
	private String userName;
	private String password;
	private String email;
	private String school;
	private int role;
}
