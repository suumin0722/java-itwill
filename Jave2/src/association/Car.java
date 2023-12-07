package association;



//클래스와 클래스의 관계
// => UML(Unified Modeling Language)를 사용하여 클래스 다이어그램(Class Diagram)으로 표현
//1. 일반화(Generalization) 관계 : 상속 관계 - X is a Y
// => 클래스를 선언할 때 기존 클래스를 제공받아 작성하기 위한 관계
// => 사원 클래스와 관리자 클래스의 관계 - 관리자는 사원이다.(O), 사원은 관리자다.(X)
//2. 실체화(Realization) 관계 : 상속 관계
// => 인터페이스를 제공받아 새로운 클래스를 작성하기 위한 관계
// => 인터페이스 : 현실에 존재하는 대상을 클래스보다 추상적으로 표현하기 위한 자료형
// => 도형 인터페이스와 삼각형 클래스의 관계
//3.연관(Association) 관계 : 포함 관계 = X has a Y
// => 클래스 내부에 객체를 저장하는 필드를 작성하여 만들어지는 관계
// => 의사와 환자와의 관계
// => 직접 연관 관계(Directed Association) : 한 방향으로만 관계가 설정되어 기능을 제공하는 관계
//4.집합 연관 관계(Aggregation) : 포함 관계로 설정된 객체의 생명주기가 다른 포함 관계
// => 프린터와 컴퓨터와의 관계
//5.복합 연관 관계(Composition) : 포함 관계로 설정된 객체의 생명주기가 다른 포함 관계
// => 게임과 캐릭터와의 관계
//6.의존 관계(Dependency) : 포함 관계로 설정된 클래스가 변경되어도 현재 클래스에 영향을 주지 않는 관계
// => TV와 리모컨의 관계


//자동차 정보(모델명, 생산년도, 엔진정보를 저장하기 위한 클래스

public class Car {
	//필드
	private String modelName;
	private int productionYear;
	//엔진정보를 저장하기 위한 필드 - Engine 클래스를 사용하여 필드 작성
	// => 필드에는 생성자 또는 Setter 메소드를 사용하여 Engine 객체를 제공받아 저장 - 포함 관계 구현 
	private Engine carEngine;
	
	//생성자
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	public Car(String modelName, int productionYear, Engine carEngine) {
		super();
		this.modelName = modelName;
		this.productionYear = productionYear;
		this.carEngine = carEngine;
	}

	//세터게터 메소드
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public Engine getCarEngine() {
		return carEngine;
	}

	public void setCarEngine(Engine carEngine) {
		this.carEngine = carEngine;
	}
	
	//자동차 정보를 표현한 필드값을 출력하는 메소드
	public void displayCar() {
		System.out.println("모델명 = "+modelName);
		System.out.println("생산년도 = "+productionYear);
		//필드에 저장된 객체의 메모리 주소 출력
		//System.out.println("엔진정보 = "+carEngine);
		
		//필드에 저장된 Engine 객체를 이용하여 메소드 호출해 Engine 객체의 필드값을 반환받아 출력
		// => 포함 관계로 만들어진 클래스의 메소드를 객체를 저장한 필드로 호출하여 필요한 기능 구현
		// => 포함 관계가 만들어져 있지 않은 상태로 메소드를 호출할 경우 NullPointerException 발생
		System.out.println("엔진정보(연료타입) = "+carEngine.getFuelType());
		System.out.println("엔진정보(배기량) = "+carEngine.getDisplacement());
		
		
	}
	
}




















