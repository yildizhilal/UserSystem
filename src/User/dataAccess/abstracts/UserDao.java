package User.dataAccess.abstracts;

import User.entitites.concretes.Users;

public interface UserDao {
	void SignIn(Users user);
	void LogIn(Users user);

}
