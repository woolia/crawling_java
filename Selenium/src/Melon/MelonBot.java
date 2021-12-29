package Melon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MelonBot {

	private WebDriver driver;
	private WebElement element;
	private List<WebElement> elements;
	private String url;
	
	//public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	//public static String WEB_DRIVER_PATH = "C:\\Java\\tools\\chromedriver_win32\\chromedriver.exe";

	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "C:\\Java\\tools\\chromedriver_win32\\chromedriver.exe";
	
	public MelonBot() {
		// WebDriver ��� ����
				System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
				
				// WebDriver �ɼ� ����
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-popup-blocking");
				
				driver = new ChromeDriver(options);
				
				url = "https://www.melon.com/chart/index.htm"; // ��� 100�� ��Ʈ
				
	}
	
	public void activateBot() {
		try {
			driver.get(url);
			// driver �� url �� �� �ش� url �� �̵�
			
			Thread.sleep(2000);
			
			// �� ���� �Ľ�
			element = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[3]/form/div/table/tbody/tr[1]/td[6]/div/div/div[1]/span/a"));
			String title = element.getText();
			
			// ���ƿ� �� �Ľ�
			element = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[3]/form/div/table/tbody/tr[1]/td[8]/div/button/span[2]"));
			String cntLike = element.getText();
			
			System.out.println("1�� �뷡�� ["+ title +"]�Դϴ�.");
			System.out.println("���ƿ� ���� ["+ cntLike +"]�Դϴ�.");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			driver.close();
			driver.quit();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		MelonBot bot = new MelonBot();
		bot.activateBot();
	}
}
