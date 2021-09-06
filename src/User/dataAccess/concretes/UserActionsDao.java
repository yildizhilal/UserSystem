package User.dataAccess.concretes;

import User.dataAccess.abstracts.UserDao;
import User.entitites.concretes.Users;

public class UserActionsDao implements UserDao{

	@Override
	public void SignIn(Users user) {
		System.out.println(user.getMail()+" adresine dogrulama maili gonderildi. Dogrulama saglandi.");
	}

	@Override
	public void LogIn(Users user) {
		System.out.println(user.getMail()+" sisteme giris yapti.");
	}

}
