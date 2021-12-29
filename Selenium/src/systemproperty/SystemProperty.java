package systemproperty;

import java.util.Properties;

public class SystemProperty {

	public static void main(String[] args) {
		
		// �⺻���� �ý��� ������Ƽ�� ��� 
		System.out.println(System.getProperties()); 
		System.out.println("================="); 
		
		// ���� �ý��� ������Ƽ�� ���ο� key-value �߰� 
		System.setProperty("TEST0", "TEMP"); 
		System.out.println(System.getProperties()); 
		
		// ���� �ý��� ������Ƽ�� �߰��� key-value ���� Ȯ���� �� ���� 
		System.out.println("=================") ; 
		
		// ���ο� ������Ƽ �ν��Ͻ� ���� �� key-value �� ���� 
		Properties prop2 = new Properties(); 
		prop2.setProperty("TEST1", "TEMP"); 
		System.setProperties(prop2); 
		
		// �߸��� ���. ���� �ý��� ������Ƽ ������ ���� ���� ������Ƽ ���� �������. 
		// Properties ��ü�� �����ϰ� setProperty�� �ϸ� System�� Property�� �F���� �ȴ�.
		// ���� System.getProperties() �� �ϸ� {TEST1=TEMP} �� ������ �� 
		System.out.println(System.getProperties()); 
		System.out.println("================="); 
		
		// �ý��� ������Ƽ�� �߰�. 
		System.setProperty("TEST2", "TEMP"); 
		System.out.println(System.getProperties());

	
	}

}
