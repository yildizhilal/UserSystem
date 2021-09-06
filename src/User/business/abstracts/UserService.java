package User.business.abstracts;

import User.entitites.concretes.Users;

public interface UserService {

	boolean MailVerification(Users user);
	boolean PasswordVerification(Users user);
	boolean NameVerification(Users user);
	void SigIn(Users user);
	void LogIn(Users user);
	void SignInGoogle(Users user);
	
}
