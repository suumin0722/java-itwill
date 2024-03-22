package xyz.itwill07.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import lombok.Setter;

//SpringDAO ����� ����Ͽ� DAO Ŭ���� �ۼ� - spring-jdbc ���̺귯���� ������Ʈ�� ���� ó��
// => Template Method Pattern�� ����� JdbcTemplate ��ü�� �޼ҵ带 ȣ���Ͽ� DAO Ŭ������ �޼ҵ� �ۼ� 
//Template Method Pattern : �޼ҵ忡 �ʿ��� ��ɵ��� �̸� �����Ͽ� ���� ��� ������ �����ϴ� ������ ���� 
// => ���ø� �޼ҵ��� �Ű������� �ʿ��� ���� �����Ͽ� JDBC ��� ���� 

public class StudentDAOImpl implements StudentDAO {
	//JdbcTemplate ��ü�� �����ϱ� ���� �ʵ� ����
	// => Spring Bean Configuration File���� StudentDAOImpl Ŭ������ Spring Bean���� ����� ��
	//������ �����̳ʷκ��� JdbcTemplate ��ü�� �����޾� ������ ���� - Setter Injection
	@Setter
	private JdbcTemplate jdbcTemplate;  
	
	//�л������� ���޹޾� STUDENT ���̺� ������ �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	@Override
	public int insertStudent(Student student) {
		String sql="insert into student values(?,?,?,?,?)";
		//JdbcTemplate.update(String sql, Object ... args) : SQL ���(INSET, UPDATE, DELETE)��
		//DBMS ������ �����Ͽ� �����ϴ� �޼ҵ� - �������� ����(int) ��ȯ
		// => �޼ҵ� �Ű��������� ����� SQL ��ɰ� InParameter(?)�� ���޵Ǿ� ���� ����
		//���ʴ�� �����Ͽ� ����
		// => SQL ����� InParameter(?) ������ŭ �ݵ�� args �Ű������� ���� ���� 
		return jdbcTemplate.update(sql, student.getNo(), student.getName()
				, student.getPhone(), student.getAddress(), student.getBirthday());
	}

	//�л������� ���޹޾� STUDENT ���̺� ����� ���� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	@Override
	public int updateStudent(Student student) {
		String sql="update student set name=?, phone=?, address=?, birthday=? where no=?";
		return jdbcTemplate.update(sql, student.getName(), student.getPhone()
				, student.getAddress(), student.getBirthday(), student.getNo());
	}

	//�л���ȣ�� ���޹޾� STUDENT ���̺� ����� ���� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	@Override
	public int deleteStudent(int no) {
		return jdbcTemplate.update("delete from student where no=?", no);
	}

	//�л���ȣ�� ���޹޾� STUDENT ���̺� ����� ���� �˻��Ͽ� Java ��ü(DTO)�� ��ȯ�ϴ� �޼ҵ�
	@Override
	public Student selectStudent(int no) {
		try {
			String sql="select no, name, phone, address, birthday from student where no=?";
			//jdbcTemplate.queryForObject(String sql, RowMapper<T> rowMapper, Object ... args)
			// => SQL ���(SELECT)�� DBMS ������ �����Ͽ� �����ϴ� �޼ҵ�
			// => �������� �˻������ DTO ��ü�� ��ȯ�ϱ� ���� ����ϴ� �޼ҵ�
			// => �Ű��������� ����� SQL ��ɰ� �˻����� Java ��ü�� ��ȯ�ϱ� ���� ������ �����ϴ�
			//RowMapper ��ü, InParameter(?)�� ���޵Ǿ� ���� ���� ���ʴ�� �����Ͽ� ����
			
			//RowMapper ��ü : RowMapper �������̽��� ��ӹ��� �ڽ�Ŭ������ ������ ��ü
			// => �˻����� �÷����� DTO ��ü�� �ʵ忡 �����ϱ� ���� ���������� ����
			//RowMapper �������̽��� ��ӹ��� �͸��� ����Ŭ������ ����Ͽ� RowMapper ��ü �����Ͽ� ��� 
			// => �������̽� ���׸����� �˻������� ������ DTO ��ü�� �ڷ���(Ŭ����)�� ����
			// => RowMapper �������̽��� �߻�޼ҵ带 �������̵� �����Ͽ� �������� �ۼ�
			/*
			return jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
				@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					//�˻����� �÷����� DTO ��ü�� �ʵ忡 ����ǵ��� ���� ����
					return Student.builder()
							.no(rs.getInt("no"))
							.name(rs.getString("name"))
							.phone(rs.getString("phone"))
							.address(rs.getString("address"))
							.birthday(rs.getString("birthday"))
							.build();
				}
			}, no);
			*/
			//RowMapper �������̽��� ��ӹ��� ����Ŭ������ RowMapper ��ü �����Ͽ� ��� - ��Ȱ�� 
			return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), no);
		} catch (EmptyResultDataAccessException e) {
			//EmptyResultDataAccessException : queryForObject() �޼ҵ�� ���޵ɾ� �����
			//SELECT ��ɿ� ���� �˻����� ���� ��� �߻��Ǵ� ����
			return null;
		}	
	}

	//STUDENT ���̺� ����� ��� ���� �˻��Ͽ� Java ��ü(List)�� ��ȯ�ϴ� �޼ҵ�
	@Override
	public List<Student> selectStudentList() {
		String sql="select no, name, phone, address, birthday from student order by no";
		//jdbcTemplate.query(String sql, RowMapper<T> rowMapper, Object ... args)
		// => SQL ���(SELECT)�� DBMS ������ �����Ͽ� �����ϴ� �޼ҵ�
		// => �ټ����� �˻������ List ��ü�� ��ȯ�ϱ� ���� ����ϴ� �޼ҵ� 
		// => RowMapper ��ü�� �ϳ��� �˻����� DTO ��ü�� �����Ͽ� List ��ü�� ��ҷ� �߰�
		/*
		return jdbcTemplate.query(sql, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Student.builder()
						.no(rs.getInt("no"))
						.name(rs.getString("name"))
						.phone(rs.getString("phone"))
						.address(rs.getString("address"))
						.birthday(rs.getString("birthday"))
						.build();
			}
		});
		*/
		return jdbcTemplate.query(sql, new StudentRowMapper());
	}
	
	public class StudentRowMapper implements RowMapper<Student> {
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			return Student.builder()
					.no(rs.getInt("no"))
					.name(rs.getString("name"))
					.phone(rs.getString("phone"))
					.address(rs.getString("address"))
					.birthday(rs.getString("birthday"))
					.build();
		}
	}
}