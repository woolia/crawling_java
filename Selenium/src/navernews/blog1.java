package navernews;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class blog1 {

	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // ����̹� ID
	public static final String WEB_DRIVER_PATH = "C:\\Java\\tools\\chromedriver_win32\\chromedriver.exe"; // ����̹� ���
	
	
	public static void main(String[] args) throws InterruptedException {
		
		// ����̹� ����
		try {
			System.setProperty(WEB_DRIVER_ID,WEB_DRIVER_PATH); 
			/*
			 * �ý��� ������Ƽ
			 * - �ڹٴ� JVM������ �����Ѵ�. �⵿�� �Ǹ鼭 �ý��� ���� �� ����� ������ �ý��� ������Ƽ�� ��Ƴ��� �̸� ����/����� �� �ְ� �� �� �ִ�.
			 * �ٸ� �ý��ۿ� ���õ� ������ ���� ������ �������̸� ��ȸ �뵵�� ����ϰų� �߰��ؼ� ����ϴµ� �����ؼ� ����ؾ� �Ѵ�.
			 */
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		// ũ�� ������ ���� ��ü ����
		ChromeOptions options = new ChromeOptions();
		// �������� ���� ������ �ʰ� ���������� ����.
		// �������� ���� �ÿ��� ���� ũ�� â�� �����ǰ�, � ������ ����Ǵ��� Ȯ���� �� �ִ�.
		/* �����߻� �� �ذ� : selenium jar ������ Build Path ���� ModulePath �� �ƴ϶� ClassPath�� �����ؾ� �Ѵ�.*/
		
		//options.addArguments("-headless");
		//options.addArguments("no-sandbox");
		// ������ ������ �ɼ��� ���� ����̹� ��ü�� ����
		// �ɼ��� �������� �ʾ��� ���� ������ �����ϴ�.
		// WebDriver ��ü�� �� �ϳ��� ������ â�̶�� �����Ѵ�.
		
		WebDriver driver = new ChromeDriver(options);
		
		// �̵��� ���ϴ� URL
		String url = "https://www.naver.com";
		
		// WebDriver �� �ش� URL �� �̵��Ѵ�.
		driver.get(url);
		
		// ������ �̵��� ����� �ε�ð��� ��ٸ���.
		// HTTP ����ӵ����� �ڹ��� ������ �ӵ��� �� ������ ������ ���������� 1�ʸ� ����Ѵ�.
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		// class="nav" �� ��� �±׸� ���� WebElement ����Ʈ�� �޾ƿ´�.
		// WebElement �� html�� �±׸� ������ Ŭ�����̴�.
		
		List<WebElement> el1 = driver.findElements(By.className("nav"));
		
		
		for(int i=0; i<el1.size(); i++) {
			// nav Ŭ������ ��ü �� "����" ��� �ؽ�Ʈ�� ���� WebElement �� Ŭ���Ѵ�.
			if(el1.get(i).getText().equals("����")) {
				el1.get(i).click();
				break;
			}
		}
		
		// 1�� ���
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		// ��ư�� Ŭ���ؼ� �������� ����â���� �̵����� ��
		// �̵��� ���� â�� IT/���� ���� �������� �����´�.
		
		// IT/���д����� ���� div
		WebElement el2 = driver.findElement(By.id("section_it"));
		
		// div �ӿ��� strong �±׸� ���� ��� element�� �޾ƿ´�.
		List<WebElement> el3 = el2.findElements(By.tagName("strong"));
		
		int count =0;
		
		for(int i = 0; i< el3.size(); i++) {
			// ������ ������ ��� ����Ѵ�.
			System.out.println(++count + "�� ���� : " + el3.get(i).getText());
		}
		
		try {
			// ����̹��� null�� �ƴϸ�
			if(driver != null) {
				// ����̹� ���� ����
				driver.close();
				// ���μ��� ����
				driver.quit();
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage()); 
		}
	}
}


// ChromeOptions ���� addArguments("headless"); �ɼ��� �����ϸ� 
/*
 * WARNING: Connection reset java.net.SocketException: Connection reset
 * ����� �߻��Ѵ�. 
 * �ٵ� ������ ��� ���� ����ϰ� ��Ÿ��. �ӵ������� ������ headless ������ �־�� �ϴµ� ����� ������
 * �׷��ٰ� ����� �ȵǴ� �͵� �ƴ϶�....
 */