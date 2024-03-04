package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import xyz.itwill.dto.MyMember;
import xyz.itwill.mapper.MyMemberInterfaceMapper;

public class MyMemberInterfaceDAO {
	private static MyMemberInterfaceDAO _dao;
	
	public MyMemberInterfaceDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyMemberInterfaceDAO();
	}
	
	public static MyMemberInterfaceDAO getDAO() {
		return _dao;
	}
	
	private SqlSessionFactory getSqlSessionFactory() {
		String resource="mybatis-config.xml";
		
		InputStream in=null;
		try {
			in=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	// 회원정보를 전달받아 MYMEMBER 테이블에 삽입하고 삽입행의 개수를 반환하는 메소드
		public int insertMember(MyMember member) {
			SqlSession sqlSession = getSqlSessionFactory().openSession();
			try {
				//SqlSession.getMapper(Class<T> clazz) : 매개변수에 Class 객체(메모리에 저장된
				//인터페이스 맵퍼)를 전달받아 Mapper 객체로 생성하여 반환하는 메소드
				// => 매개변수에 [XXX.class] 형식으로 인터페이스를 Class 객체로 직접 표현하여 전달
				return sqlSession.getMapper(MyMemberInterfaceMapper.class).insertMember(member);
			} finally {
				sqlSession.close();
			}

		}

		// 회원정보를 전달받아 MYMEMBER 테이블에 저장된 행을 변경하고 변경행의 개수를 반환하는 메소드
		public int updateMember(MyMember member) {
			//SqlSessionFactory.openSession(boolean autoCommit) : SqlSession 객체를 생성하여 반환하는 메소드
			// => 매개변수에 [false]를 전달하면 AutoCommit 기능을 비활성화 처리(기본)하고 [true]를
			// 전달하면 AutoCommit 기능을 활성화 처리
			SqlSession sqlSession=getSqlSessionFactory().openSession(true);
			try {
				//SqlSession.update(String elementId[, Object parameterValue]) : 매퍼에 등록된
				//update 엘리먼트의 SQL 명령(UPDATE)을 제공받아 DBMS 서버에 전달하여 실행하고
				//변경행의 개수를 반환하는 메소드
				return sqlSession.update("MyMemberXMLMapper.updateMember", member);
			} finally {
				sqlSession.close();
			}
		}

		// 아이디를 전달받아 MYMEMBER 테이블에 저장된 행을 삭제하고 삭제행의 개수를 반환하는 메소드
		public int deleteMember(String id) {
			SqlSession sqlSession=getSqlSessionFactory().openSession(true);
			try {
				//SqlSession.delete(String elementId[, Object parameterValue]) : 매퍼에 등록된
				//delete 엘리먼트의 SQL 명령(DELETE)을 제공받아 DBMS 서버에 전달하여 실행하고
				//삭제행의 개수를 반환하는 메소드
				return sqlSession.delete("MyMemberXMLMapper.deleteMember", id);
			} finally {
				sqlSession.close();
			}
		}

		// 아이디를 전달받아 MYMEMBER 테이블에 저장된 행을 검색하여 회원정보로 반환하는 메소드
		public MyMember selectMember(String id) {
			SqlSession sqlSession=getSqlSessionFactory().openSession(true);
			try {
				//SqlSession.selectOne(String elementId[, Object parameterValue]) : 매퍼에 등록된
				//select 엘리먼트의 SQL 명령(SELECT)을 제공받아 DBMS 서버에 전달하여 실행하고
				//검색결과가 저장된 Java 객체(값)를 반환하는 메소드
				// => 하나의 행만 검색하는 SELECT 명령을 DBMS 서버에 전달하여 실행할 경우 호출하는 메소드
				return sqlSession.selectOne("MyMemberXMLMapper.selectMember", id);
			} finally {
				sqlSession.close();
			}
		}
		
		// MYMEMBER 테이블에 저장된 모든 행을 검색하여 회원목록으로 반환하는 메소드
		public List<MyMember> selectMemberList() {
			SqlSession sqlSession=getSqlSessionFactory().openSession(true);
			try {
				//SqlSession.selectList(String elementId[, Object parameterValue]) : 매퍼에 등록된
				//select 엘리먼트의 SQL 명령(SELECT)을 제공받아 DBMS 서버에 전달하여 실행하고
				//검색결과가 저장된 List 객체를 반환하는 메소드
				// => 다수의 행을 검색하는 SELECT 명령을 DBMS 서버에 전달하여 실행할 경우 호출하는 메소드
				return sqlSession.selectList("MyMemberXMLMapper.selectMemberList");
			} finally {
				sqlSession.close();
			}
		}
	}
