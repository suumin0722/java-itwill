package xyz.itwill06.aop;

import java.util.List;

//�ٽɰ��ɸ��(Core Concern Module) : �ٽɰ����ڵ��� �޼ҵ尡 �ۼ��� Ŭ���� 
public class HewonDAOImpl implements HewonDAO {
	@Override
	public int insertHewon(Hewon hewon) {
		System.out.println("*** HewonDAOImpl Ŭ������ insertHewon(Hewon hewon) �޼ҵ� ȣ��*** ");
		return 0;
	}

	@Override
	public Hewon selectHewon(int num) {
		System.out.println("*** HewonDAOImpl Ŭ������ selectHewon(int num) �޼ҵ� ȣ��*** ");
		return null;
	}

	@Override
	public List<Hewon> selectHewonList() {
		System.out.println("*** HewonDAOImpl Ŭ������ selectHewonList() �޼ҵ� ȣ��*** ");
		return null;
	}

}
