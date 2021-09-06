package User;

import User.business.abstracts.UserService;
import User.business.concretes.UserManager;
import User.core.jGoogleManagerAdapter;
import User.dataAccess.abstracts.UserDao;
import User.dataAccess.concretes.UserActionsDao;
import User.entitites.concretes.Users;

public class Main {

	public static void main(String[] args) {
	
		UserService userService= new UserManager(new UserActionsDao(),new jGoogleManagerAdapter());
		Users hilal=new Users(1,"Hilal","Deniz","hilal@gmail.com","hilalyl");

		Users utkan=new Users(2,"Utkan","Deniz","utkan@gmail.com","utkandn");
		userService.SigIn(hilal);
		userService.SignInGoogle(utkan);
		
	}

}
