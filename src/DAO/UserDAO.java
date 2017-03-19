package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.bind.ValidationException;

import model.User;
import model.User.Gender;
import model.User.Rights;

public class UserDAO {
	private static UserDAO instance;
	private static final HashMap<String, User> allUsers = new HashMap<>();//username - > user

	private UserDAO(){
		
	}

	public static synchronized UserDAO getInstance(){
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	public synchronized boolean validLogin(String user, String pass) throws SQLException {
		if(getAllUsers().containsKey(user)){
			boolean isValid = getAllUsers().get(user).getPass().equals(pass);
			return isValid;
		}
		return false;
	}

	public boolean existsInDB(User user){
		if (allUsers.keySet().contains(user.getUsername())) {
			return true;
		}for (Iterator iterator = allUsers.values().iterator(); iterator.hasNext();) {
			User u = (User) iterator.next();
			if (u.getEmail().equals(user.getEmail())) {
				return true;
			}
		}
		return false;
	}

	public HashMap<String, User> getAllUsers() throws SQLException{
		if(allUsers.isEmpty()){
			String sql = "SELECT user_id, username, password, gender FROM users;";
			PreparedStatement st = Demo.getInstance().getConnection().prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while(res.next()){
				User u = new User( res.getString("username"),res.getString("password"),parseGender(res.getString("gender")));
				u.setUserID(res.getInt("user_id"));
				allUsers.put(u.getUsername(), u);
			}
		}
		System.out.println(allUsers+ "===============================================");
		return allUsers;
	}

	public User.Gender parseGender(String gender){
		if (gender=="F") {
			return User.Gender.F;
		}else if (gender=="M") {
			return User.Gender.M;
		}
		return null;
	}
	
	public static User getUser(long id) throws ValidationException, SQLException{
		User u = null;
		String sql = "SELECT user_id, nickname, password, email, real_name, birthday, signature, avatar, registration_date, gender, rights, country_id FROM users WHERE user_id = " + id + ";";
		Statement st = DBManager.getInstance().getConnection().createStatement();
		ResultSet res = null;
		try {
			res = st.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("cant get user");
		}
		//Create user with right rights :)
		if(res.next()){
			Rights r = Rights.MEMBER;;
			if(res.getString("rights") == "admin"){
				r = Rights.ADMIN;
			}
			if(res.getString("rights") == "moderator"){
				r = Rights.MODERATOR;
			}
			//and right gender
			if (res.getString("gender") == "M"){
				u = new User(res.getString("nickname"), res.getString("password"), res.getString("email"), Gender.M, r);
			}else{
				u =  new User(res.getString("nickname"), res.getString("password"), res.getString("email"), Gender.F, r);
			}
			u.setUserID(res.getLong("user_id"));
		}
		//set all other stuff
		return u;
	}
}
