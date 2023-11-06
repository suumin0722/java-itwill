package xyz.itwill.other;

import xyz.itwill.access.ProtectedMember;

public class ProtectedMemberOtherInheritanceUse extends ProtectedMember {
	public void run() {
		//부모클래스(ProtectedMeber)에게 물려받은 필드와 메소드 사용
		number=100;
		display();
	}
}
