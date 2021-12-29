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
		
		// 1. WebDriver 경로 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		// 시스템 환경에 WEB_DRIVER_ID 와 WEB_DRIVER_PATH 순서대로 넣는다.
		
		// 2. WebDriver 옵션 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		
		driver = new ChromeDriver(options);	
		
		url = "https://www.naver.com";
	}
	
	public void activateBot() {
		try {
			
			// 3. 페이징 로딩 대기 시간
			driver.get(url);
			Thread.sleep(2000); 
			
			// 4. 로그인 버튼 클릭
			element = driver.findElement(By.className("link_login"));
			element.click(); // click() 메서드를 통해 "link_login" 이라는 클래스 이름을 가진 태그를 클릭할 수 있다.
			
			Thread.sleep(1000); // 1초 대기
			
			// ID 입력
			element = driver.findElement(By.id("id"));
			element.sendKeys("zecrar"); // sendKeys 를 통해 해당 텍스트를 입력
			
			// 비밀번호 입력
			element = driver.findElement(By.id("pw"));
			element.sendKeys("dishfkw915");
			
			// 전송
			element = driver.findElement(By.className("btn_login"));
			element.submit();
			//element.click();
			
			// click() 과 submit() 출처 : https://stackoverflow.com/questions/17530104/selenium-webdriver-submit-vs-click
			// click() 도 해도 submit() 을 해도 상관없다고 함
			// 해당 네이버 로그인 페이지에서 로그인 버튼은 <button type="submit"> 으로 되어있어 사실상 <input type="submit"> 과 다름없다
			// submit() 은 form 태그 안에 submit 동작이 있으면  submit() 함수를 사용할 수 있다고함
			// 따라서 그냥 사용자가 선택하기 나름
			
			// element.click() 해도 똑같이 동작
			
			Thread.sleep(5000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			// 드라이버가 null이 아니면
			if(driver != null) {
				// 드라이버 연결 종료
				driver.close();
				// 프로세스 종료
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

// 여기서도 똑같이 Connection reset Warning 이 뜬다. 