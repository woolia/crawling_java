package systemproperty;

import java.util.Properties;

public class SystemProperty {

	public static void main(String[] args) {
		
		// 기본적인 시스템 프로퍼티를 출력 
		System.out.println(System.getProperties()); 
		System.out.println("================="); 
		
		// 기존 시스템 프로퍼티에 새로운 key-value 추가 
		System.setProperty("TEST0", "TEMP"); 
		System.out.println(System.getProperties()); 
		
		// 기존 시스템 프로퍼티에 추가한 key-value 값을 확인할 수 있음 
		System.out.println("=================") ; 
		
		// 새로운 프로퍼티 인스턴스 생성 후 key-value 값 설정 
		Properties prop2 = new Properties(); 
		prop2.setProperty("TEST1", "TEMP"); 
		System.setProperties(prop2); 
		
		// 잘못된 방법. 기존 시스템 프로퍼티 정보에 새로 만든 프로퍼티 값을 덮어버림. 
		// Properties 객체를 선언하고 setProperty를 하면 System의 Property를 덯어씌우게 된다.
		// 따라서 System.getProperties() 를 하면 {TEST1=TEMP} 만 나오는 것 
		System.out.println(System.getProperties()); 
		System.out.println("================="); 
		
		// 시스템 프로퍼티에 추가. 
		System.setProperty("TEST2", "TEMP"); 
		System.out.println(System.getProperties());

	
	}

}
