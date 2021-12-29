package navernews;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class blog1 {

	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
	public static final String WEB_DRIVER_PATH = "C:\\Java\\tools\\chromedriver_win32\\chromedriver.exe"; // 드라이버 경로
	
	
	public static void main(String[] args) throws InterruptedException {
		
		// 드라이버 설정
		try {
			System.setProperty(WEB_DRIVER_ID,WEB_DRIVER_PATH); 
			/*
			 * 시스템 프로퍼티
			 * - 자바는 JVM위에서 수행한다. 기동이 되면서 시스템 정보 및 사용자 정보를 시스템 프로퍼티에 담아놓고 이를 수정/사용할 수 있게 할 수 있다.
			 * 다만 시스템에 관련된 정보가 많기 때문에 가급적이면 조회 용도로 사용하거나 추가해서 사용하는데 주의해서 사용해야 한다.
			 */
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		// 크롬 설정을 담은 객체 생성
		ChromeOptions options = new ChromeOptions();
		// 브라우저가 눈에 보이지 않고 내부적으로 돈다.
		// 설정하지 않을 시에는 실제 크롬 창이 생성되고, 어떤 순서로 진행되는지 확인할 수 있다.
		/* 에러발생 및 해결 : selenium jar 파일을 Build Path 에서 ModulePath 가 아니라 ClassPath에 설정해야 한다.*/
		
		//options.addArguments("-headless");
		//options.addArguments("no-sandbox");
		// 위에서 설정한 옵션을 담은 드라이버 객체를 생성
		// 옵션을 설정하지 않았을 때는 생략이 가능하다.
		// WebDriver 객체가 곧 하나의 브라우저 창이라고 생각한다.
		
		WebDriver driver = new ChromeDriver(options);
		
		// 이동을 원하는 URL
		String url = "https://www.naver.com";
		
		// WebDriver 를 해당 URL 로 이동한다.
		driver.get(url);
		
		// 브라우저 이동시 생기는 로드시간을 기다린다.
		// HTTP 응답속도보다 자바의 컴파일 속도가 더 빠르기 때문에 임의적으로 1초를 대기한다.
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		// class="nav" 인 모든 태그를 가진 WebElement 리스트를 받아온다.
		// WebElement 는 html의 태그를 가지는 클래스이다.
		
		List<WebElement> el1 = driver.findElements(By.className("nav"));
		
		
		for(int i=0; i<el1.size(); i++) {
			// nav 클래스의 객체 중 "뉴스" 라는 텍스트를 가진 WebElement 를 클릭한다.
			if(el1.get(i).getText().equals("뉴스")) {
				el1.get(i).click();
				break;
			}
		}
		
		// 1초 대기
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		// 버튼을 클릭해서 브라우저는 뉴스창으로 이동했을 것
		// 이동한 뉴스 창의 IT/과학 뉴스 헤드라인을 가져온다.
		
		// IT/과학뉴스를 담은 div
		WebElement el2 = driver.findElement(By.id("section_it"));
		
		// div 속에서 strong 태그를 가진 모든 element를 받아온다.
		List<WebElement> el3 = el2.findElements(By.tagName("strong"));
		
		int count =0;
		
		for(int i = 0; i< el3.size(); i++) {
			// 뉴스의 제목을 모두 출력한다.
			System.out.println(++count + "번 뉴스 : " + el3.get(i).getText());
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
}


// ChromeOptions 에서 addArguments("headless"); 옵션을 설정하면 
/*
 * WARNING: Connection reset java.net.SocketException: Connection reset
 * 경고문이 발생한다. 
 * 근데 없으면 경고문 없이 깔끔하게 나타남. 속도면으로 봤을때 headless 설정을 넣어야 하는데 경고문이 걱정됨
 * 그렇다고 출력이 안되는 것도 아니라서....
 */