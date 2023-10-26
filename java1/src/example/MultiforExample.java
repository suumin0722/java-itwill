package example;

public class MultiforExample {
	public static void main(String[] args) {
		//★★★★★
		//☆★★★★
		//☆☆★★★
		//☆☆☆★★
		//☆☆☆☆★
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(i-j<=0) {
					System.out.print("★");
				} else {
					System.out.print("☆");
				}
			}
			System.out.println();
		}
		System.out.println("===============================================================");
		//☆☆☆☆★
		//☆☆☆★★★
		//☆☆★★★★★
		//☆★★★★★★★
		//★★★★★★★★★
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=9; j++) {
				if(i+j<=5) {
					System.out.print("☆");
				} else if(i-j<=-5) {
					System.out.print(" ");
				} else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
		System.out.println("===============================================================");
		//★☆☆☆★
		//☆★☆★☆
		//☆☆★☆☆
		//☆★☆★☆
		//★☆☆☆★
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(i-j==0 || i+j==6) {
					System.out.print("★");
				} else {
					System.out.print("☆");
				}
			}
			System.out.println();
		}
		System.out.println("===============================================================");
	}
}






