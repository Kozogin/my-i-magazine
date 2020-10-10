package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.MagazineUsersDao;
import ua.lviv.lgs.dao.impl.MagazineUsersDaoImpl;
import ua.lviv.lgs.domain.MagazineUsers;
import ua.lviv.lgs.service.MagazineUsersService;

public class MagazineUsersServiceImpl implements MagazineUsersService{
	
	private MagazineUsersDao magazineUsersDao;
	
	public MagazineUsersServiceImpl(){
		try {
			magazineUsersDao = new MagazineUsersDaoImpl();
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
	public MagazineUsers create(MagazineUsers t) throws SQLException {
		return magazineUsersDao.create(t);
	}

	@Override
	public MagazineUsers read(Integer id) {
		return magazineUsersDao.read(id);
	}

	@Override
	public MagazineUsers update(MagazineUsers t) {
		return magazineUsersDao.update(t);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		magazineUsersDao.delete(id);
	}

	@Override
	public List<MagazineUsers> readAll() {
		return magazineUsersDao.readAll();
	}

}
