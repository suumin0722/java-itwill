package inheritance;

//학생정보(학생번호, 이름, 수강과정)를 저장하기 위한 클래스	
// => 학생번호와 학생이름 관련 속성과 행위는 AcademyPerson 클래스를 상속받아 사용
public class AcademyStudent extends AcademyPerson {
	//필드
	private String course;

	public AcademyStudent() {
		// TODO Auto-generated constructor stub
	}

	public AcademyStudent(int number, String name, String course) {
		super(number, name);
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	@Override//부모 메소드에 있는 번호,이름 을 숨기고 자식 메소드를 호출하게끔 오버라이딩
	public void display() {
		System.out.println("학생번호 = "+getNumber());
		System.out.println("학생이름 = "+getName());
		System.out.println("수강과정 = "+course);
	}
	
}
