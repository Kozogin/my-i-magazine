package ua.lviv.lgs.service;

import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.shared.AbstractCRUD;

public interface MagazineService extends AbstractCRUD <Magazine>{
	
	Magazine readByIsbn(String isbn);
	/*Magazine updateByIsbn(Magazine magazine);
	void deleteByIsbn(String isbn);*/

}
