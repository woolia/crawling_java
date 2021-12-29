package naverlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NaverLogin {

	private WebDriver driver;
	private WebElement element;
	private	String url; 
	
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "C:\\Java\\tools\\chromedriver_win32\\chromedriver.exe";
	
	
	public NaverLogin() {
		
		// 1. WebDriver ��� ����
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		// �ý��� ȯ�濡 WEB_DRIVER_ID �� WEB_DRIVER_PATH ������� �ִ´�.
		
		// 2. WebDriver �ɼ� ����
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		
		driver = new ChromeDriver(options);	
		
		url = "https://www.naver.com";
	}
	
	public void activateBot() {
		try {
			
			// 3. ����¡ �ε� ��� �ð�
			driver.get(url);
			Thread.sleep(2000); 
			
			// 4. �α��� ��ư Ŭ��
			element = driver.findElement(By.className("link_login"));
			element.click(); // click() �޼��带 ���� "link_login" �̶�� Ŭ���� �̸��� ���� �±׸� Ŭ���� �� �ִ�.
			
			Thread.sleep(1000); // 1�� ���
			
			// ID �Է�
			element = driver.findElement(By.id("id"));
			element.sendKeys("zecrar"); // sendKeys �� ���� �ش� �ؽ�Ʈ�� �Է�
			
			// ��й�ȣ �Է�
			element = driver.findElement(By.id("pw"));
			element.sendKeys("dishfkw915");
			
			// ����
			element = driver.findElement(By.className("btn_login"));
			element.submit();
			//element.click();
			
			// click() �� submit() ��ó : https://stackoverflow.com/questions/17530104/selenium-webdriver-submit-vs-click
			// click() �� �ص� submit() �� �ص� ������ٰ� ��
			// �ش� ���̹� �α��� ���������� �α��� ��ư�� <button type="submit"> ���� �Ǿ��־� ��ǻ� <input type="submit"> �� �ٸ�����
			// submit() �� form �±� �ȿ� submit ������ ������  submit() �Լ��� ����� �� �ִٰ���
			// ���� �׳� ����ڰ� �����ϱ� ����
			
			// element.click() �ص� �Ȱ��� ����
			
			Thread.sleep(5000);
		}catch (Exception e) {
			e.printStackTrace();
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NaverLogin bot1 = new NaverLogin();
		bot1.activateBot();
	}

}

// ���⼭�� �Ȱ��� Connection reset Warning �� ���. 