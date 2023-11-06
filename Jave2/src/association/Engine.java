package association;


//엔진 정보를 저장하기 위한 클래스
public class Engine {
	//필드
	private String fuelType;
	private int displacement;
	
	//기본 생성자
	public Engine() {
		// TODO Auto-generated constructor stub
	}
	
	
	//생성자
	public Engine(String fuelType, int displacement) {
		super();
		this.fuelType = fuelType;
		this.displacement = displacement;
	}

	//Setter & Getter
	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
	public void displayEngine() {
		System.out.println("엔진타입 = "+fuelType);
		System.out.println("배기량 ="+displacement);
	
	}
}
