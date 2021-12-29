package Melon;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


// 제목들 리스트에 넣기

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
		 
		 // 곡 제목들 파싱
		 //elements = driver.findElements(By.className("ellipsis rank01"));
		 /* 이렇게 class이름이 떨어질때는 By.className으로 찾을수 없다고 한다 출처 : https://www.lambdatest.com/blog/selenium-java-tutorial-class-name-locator-in-selenium/
		  * 그래서 Xpath값을 대체 한다고 함 
		  * */
		 
		//*[@id="lst50"]/td[6]/div/div/div[1]/span/a : 처음꺼
		//*[@id="lst50"]/td[6]/div/div/div[1]/span/a : 두번째꺼
		//*[@id="lst50"]/td[6]/div/div/div[1]/span/a : 50번째꺼
		//*[@id="lst100"]/td[6]/div/div/div[1]/span/a : 51번째꺼
		//*[@id="lst100"]/td[6]/div/div/div[1]/span/a : 100번째꺼
		 
		 /* 
		  * 주의할점 Xpath를 할때 copy를 하면 [@id="lst50"]/td[6]/div/div/div[1]/span/a 이렇게 나오는데
		  * 이때 [] 앞에 어떤 태그로 감싸줬는지 말해야 한다.
		  * ex) 위 태그들은 <tr class="lst50"></tr> 이므로 
		  * //tr[@id="lst50"]/td[6]/div/div/div[1]/span/a 
		  * //tr[@id="lst100"]/td[6]/div/div/div[1]/span/a
		  * 이렇게 사용
		  * */
		 
		 // 1. id = "lst50" 50위권 안에 차트 곡들
		 elements = driver.findElements(By.xpath("//tr[@id=\"lst50\"]/td[6]/div/div/div[1]/span/a"));
		 for (WebElement webElement : elements) {
			 System.out.println("값 : "+ webElement.getText());
			 list.add(webElement.getText());
		 }
		 
		 // 2. id = "lst100" 100위권 즉 51~100 차트의 곡들
		 elements = driver.findElements(By.xpath("//tr[@id=\"lst100\"]/td[6]/div/div/div[1]/span/a"));
		 for (WebElement webElement : elements) {
			 System.out.println("값 : "+ webElement.getText());
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
		
		
		System.out.println("첫번째 곡 : "+ bot.list.get(0));
		System.out.println("100번째 곡 : "+ bot.list.get(99));
	}

}
