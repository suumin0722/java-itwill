package inheritance;


//직원(직원번호, 이름, 근무부서)정보를 저장하기 위한 클래스
//=> 직원번호와 직원이름 관련 속성과 행위는 AcademyPerson 클래스를 상속받아 사용
public class AcademyStaff extends AcademyPerson {
	private String department;

	public AcademyStaff() {
		// TODO Auto-generated constructor stub
	}

	public AcademyStaff(int number, String name, String department) {
		super(number, name);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public void display() {
		System.out.println("직원번호 = "+getNumber());
		System.out.println("직원이름 = "+getName());
		System.out.println("근무부서 = "+department);
	}
}
