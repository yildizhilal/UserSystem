package User.jGoogle;

import User.entitites.concretes.Users;

public class jGoogleManager {
	
	public void SignIn(Users user)
	{
		System.out.println(user.getFirstName()+" sisteme Google ile uye oldu.");
	}
	

}
