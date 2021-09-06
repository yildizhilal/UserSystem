package User.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import User.business.abstracts.UserService;
import User.core.GoogleService;
import User.dataAccess.abstracts.UserDao;
import User.dataAccess.concretes.UserActionsDao;
import User.entitites.concretes.Users;

public class UserManager implements UserService {

	List<String> mailList=new ArrayList<String>();
	
	private UserDao userDao;
	private GoogleService googleService;
	
	public UserManager(UserDao userDao,GoogleService googleService) {
		super();
		this.userDao = userDao;
		this.googleService=googleService;
	}

	@Override
	public boolean MailVerification(Users user) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getMail());
		if(matcher.matches()==true && mailList.contains(user.getMail())==false)
		{
			mailList.add(user.getMail());
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean PasswordVerification(Users user) {
		String regex = "[0-9a-zA-Z]{6,}";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getPassword());
		if(matcher.matches()==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean NameVerification(Users user) {
		String regex = "[0-9a-zA-Z]{6,}";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getFirstName());
	    Matcher matcherLastName = pattern.matcher(user.getLastName());
		if(matcher.matches()==true && matcherLastName.matches()==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void SigIn(Users user) {
		if(MailVerification(user)==true && PasswordVerification(user)==true)
		{
			this.userDao.SignIn(user);
		}
		else
		{
			System.out.println("E-mail veya password hatali.");
		}
		
	}

	@Override
	public void LogIn(Users user) {
		if(MailVerification(user)==true && PasswordVerification(user)==true)
		{
			this.userDao.LogIn(user);
		}
		else
		{
			System.out.println("E-mail veya password hatali.");
		}
		
	}

	@Override
	public void SignInGoogle(Users user) {
		this.googleService.SignIn(user);
		
	}



}
