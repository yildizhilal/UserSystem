package User.core;

import User.entitites.concretes.Users;
import User.jGoogle.jGoogleManager;

public class jGoogleManagerAdapter implements GoogleService {

	@Override
	public void SignIn(Users user) {
		// TODO Auto-generated method stub
		jGoogleManager googleManager=new jGoogleManager();
		googleManager.SignIn(user);
	}

}
