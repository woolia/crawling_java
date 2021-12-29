package Melon;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


// ����� ����Ʈ�� �ֱ�

public class MelonBot2 {

	private WebDriver driver;
	private List<WebElement> elements;
	private String url;
	private List<String> list = new ArrayList<String>();
	
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "C:\\Java\\tools\\chromedriver_win32\\chromedriver.exe";		
	
	public MelonBot2(){
		
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		
		driver = new ChromeDriver(options);
		
		url = "https://www.melon.com/chart/index.htm";
	}
	
	public void activate() throws InterruptedException {
		// ellipsis rank01
		driver.get(url);
		
		 Thread.sleep(1000);
		 
		 // �� ����� �Ľ�
		 //elements = driver.findElements(By.className("ellipsis rank01"));
		 /* �̷��� class�̸��� ���������� By.className���� ã���� ���ٰ� �Ѵ� ��ó : https://www.lambdatest.com/blog/selenium-java-tutorial-class-name-locator-in-selenium/
		  * �׷��� Xpath���� ��ü �Ѵٰ� �� 
		  * */
		 
		//*[@id="lst50"]/td[6]/div/div/div[1]/span/a : ó����
		//*[@id="lst50"]/td[6]/div/div/div[1]/span/a : �ι�°��
		//*[@id="lst50"]/td[6]/div/div/div[1]/span/a : 50��°��
		//*[@id="lst100"]/td[6]/div/div/div[1]/span/a : 51��°��
		//*[@id="lst100"]/td[6]/div/div/div[1]/span/a : 100��°��
		 
		 /* 
		  * �������� Xpath�� �Ҷ� copy�� �ϸ� [@id="lst50"]/td[6]/div/div/div[1]/span/a �̷��� �����µ�
		  * �̶� [] �տ� � �±׷� ��������� ���ؾ� �Ѵ�.
		  * ex) �� �±׵��� <tr class="lst50"></tr> �̹Ƿ� 
		  * //tr[@id="lst50"]/td[6]/div/div/div[1]/span/a 
		  * //tr[@id="lst100"]/td[6]/div/div/div[1]/span/a
		  * �̷��� ���
		  * */
		 
		 // 1. id = "lst50" 50���� �ȿ� ��Ʈ ���
		 elements = driver.findElements(By.xpath("//tr[@id=\"lst50\"]/td[6]/div/div/div[1]/span/a"));
		 for (WebElement webElement : elements) {
			 System.out.println("�� : "+ webElement.getText());
			 list.add(webElement.getText());
		 }
		 
		 // 2. id = "lst100" 100���� �� 51~100 ��Ʈ�� ���
		 elements = driver.findElements(By.xpath("//tr[@id=\"lst100\"]/td[6]/div/div/div[1]/span/a"));
		 for (WebElement webElement : elements) {
			 System.out.println("�� : "+ webElement.getText());
			 list.add(webElement.getText());
		 }
		 
		 
		 try {
			 if(driver != null) {
				 driver.close();
				 driver.quit();
			 }
		 }catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		MelonBot2 bot = new MelonBot2();
		bot.activate();
		
		
		System.out.println("ù��° �� : "+ bot.list.get(0));
		System.out.println("100��° �� : "+ bot.list.get(99));
	}

}
