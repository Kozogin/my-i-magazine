package ua.lviv.lgs.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import ua.lviv.lgs.dao.MagazineDao;
import ua.lviv.lgs.dao.impl.MagazineDaoImpl;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.service.MagazineService;

public class MagazineServiceImpl implements MagazineService{
	
	public static MagazineService magazineServiceImpl;
	private MagazineDao magazineDao;
	
	private MagazineServiceImpl(){
		magazineDao = new MagazineDaoImpl();
	}
	
	public static MagazineService getMagazineService() {		
		if(magazineServiceImpl == null) {
			magazineServiceImpl = new MagazineServiceImpl();
		}		
		return magazineServiceImpl;		
	}

	@Override
	public Magazine create(Magazine magazine){
		return magazineDao.create(magazine);
	}

	@Override
	public Magazine read(Integer id) {		
		return magazineDao.read(id);
	}

	@Override
	public Magazine update(Magazine magazine) {		
		return magazineDao.update(magazine);
	}

	@Override
	public void delete(Integer id) {
		magazineDao.delete(id);
	}

	@Override
	public List<Magazine> readAll() {		
		return magazineDao.readAll();
	}
	
	

	@Override
	public Magazine readByIsbn(String isbn) {		
		return magazineDao.readByIsbn(isbn);
	}

	@Override
	public Map<Integer, Magazine> readAllMap() {
		/*List<Magazine> magazine = readAll();	*/	
		return readAll().stream().collect(Collectors.toMap(Magazine::getId, Function.identity()));
	}

	

}
