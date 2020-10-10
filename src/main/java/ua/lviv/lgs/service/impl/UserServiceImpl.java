package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.dao.impl.UserDaoImpl;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	public UserServiceImpl(){
		try {
			userDao = new UserDaoImpl();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User create(User user) throws SQLException {
		return userDao.create(user);
	}

	@Override
	public User read(Integer id) {
		return userDao.read(id);
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		userDao.delete(id);
	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}

	@Override
	public User readByEmail(String email) {
		return userDao.readByEmail(email);
	}

	@Override
	public User updateByEmail(User user) {
		return userDao.updateByEmail(user);
	}

	@Override
	public void deleteByEmail(String email) {
		try {
			userDao.deleteByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
