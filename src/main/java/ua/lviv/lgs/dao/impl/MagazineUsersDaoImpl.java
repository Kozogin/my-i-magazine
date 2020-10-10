package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.lgs.dao.MagazineUsersDao;
import ua.lviv.lgs.domain.MagazineUsers;
import ua.lviv.lgs.utils.ConectionUtils;

public class MagazineUsersDaoImpl implements MagazineUsersDao{
	
	private static String READ_ALL = "select * from magazine_users";
	private static String READ_BY_ID = "select * from magazine_users where id = ?";
	private static String CREATE = "insert into magazine_users(users_id, magazine_id, purchase_date) values(?,?,?)";	
	private static String DELETE = "delete from magazine_users where users_id = ? and magazine_id = ?";
	private static String DELETE_ALL_MAGAZINE = "delete from magazine_users where magazine_id = ?";
	
	private Connection connection; 
	private PreparedStatement preparedStatement;
	
	public MagazineUsersDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.connection = ConectionUtils.openConnection();
	}

	@Override
	public MagazineUsers create(MagazineUsers magazineUsers) throws SQLException {		
		try {
		preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);	
		preparedStatement.setInt(1, magazineUsers.getUserId());
		preparedStatement.setInt(2, magazineUsers.getProductId());				
		preparedStatement.setDate(3, new Date(magazineUsers.getPurchaseDate().getTime()));	
		
		preparedStatement.executeUpdate();
		
		ResultSet rs = preparedStatement.getGeneratedKeys();
		magazineUsers.setId(1);
		
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			System.out.println("Data repeat");;
		}
		return magazineUsers;
	}

	@Override
	public MagazineUsers read(Integer id) {
		MagazineUsers bucket = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id); 
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			Integer userId =  result.getInt("users_id");
			Integer productId =  result.getInt("magazine_id");
			java.util.Date purchaseDate = result.getDate("purchase_date");
			
			bucket = new MagazineUsers(id, userId, productId, purchaseDate);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bucket;
	}

	@Override
	public MagazineUsers update(MagazineUsers magazineUsers) {		
		throw new IllegalStateException("there is not update for bucket");
	}

	@Override
	public void delete(Integer userId) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_ALL_MAGAZINE);				
		preparedStatement.setInt(1, userId);			 
		preparedStatement.executeUpdate();
		
	}
	
	public void delete(Integer userId, Integer magazine_id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE);				
		preparedStatement.setInt(1, userId);
		preparedStatement.setInt(2, magazine_id);		 
		preparedStatement.executeUpdate();		
	}

	@Override
	public List<MagazineUsers> readAll() {
		List<MagazineUsers> magazineUsersRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
				while(result.next()) {
					Integer id =  result.getInt("id");
					Integer userId =  result.getInt("users_id");
					Integer productId =  result.getInt("magazine_id");
					java.util.Date purchaseDate = result.getDate("purchase_date");
					
					magazineUsersRecords.add(new MagazineUsers(id, userId, productId, purchaseDate));
				}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return magazineUsersRecords;
	}

}
