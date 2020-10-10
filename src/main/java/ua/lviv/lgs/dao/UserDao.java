package ua.lviv.lgs.dao;

import java.sql.SQLException;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD <User>{
	
	User readByEmail(String email);
	User updateByEmail(User user);
	void deleteByEmail(String email) throws SQLException;

}
