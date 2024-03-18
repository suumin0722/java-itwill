package xyz.itwill06.aop;

import java.util.List;

import lombok.Setter;


//핵심관심모듈
public class HewonServiceImpl implements HewonService {
	@Setter
	private HewonDAO hewonDAO;

	@Override
	public void addHewon(Hewon Hewon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hewon getHewon(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hewon> getHewonList() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
