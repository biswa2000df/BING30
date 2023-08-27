package Microsoft;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.codoid.products.exception.FilloException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BingAutomate30 extends test2 {

	public static void main(String[] args) throws InterruptedException, AWTException, FilloException {

//		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.bing.com/");

		Thread.sleep(2000);
		
//		driver.findElement(By.xpath("//*[text()='Sign in']")).click();

		List<String> al = m1();

		String Email;
		String Password;

		for (int i = 0; i < al.size(); i = i + 2) {
			
			try{
				Thread.sleep(2000);
				WebElement firstsignin=driver.findElement(By.xpath("//*[text()='Sign in']"));
				if(firstsignin.isDisplayed())
					firstsignin.click();
			}
			
			catch (Exception e) {
				Thread.sleep(2000);
				WebElement lastsignin=driver.findElement(By.xpath("//*[@value='Sign in']"));
				if(lastsignin.isDisplayed())
					lastsignin.click();
				Thread.sleep(2000);
				
			}
			
			
			
			Email = al.get(i);
			Password = al.get(i + 1);
			System.out.println(al.size());
			System.out.println(Email);
			System.out.println(Password);

			System.out.println(driver.getTitle());

			Thread.sleep(1000);

			driver.findElement(By.name("loginfmt")).sendKeys(Email);

			Thread.sleep(2000);

			driver.findElement(By.id("idSIButton9")).click();

			Thread.sleep(3000);

			driver.findElement(By.name("passwd")).sendKeys(Password);

			Thread.sleep(2000);

			driver.findElement(By.id("idSIButton9")).click();

			Thread.sleep(2000);

			driver.findElement(By.id("idSIButton9")).click();

			Thread.sleep(10000);

			String parent = driver.getWindowHandle();

			System.out.println(driver.getTitle());

			driver.findElement(By.id("rh_meter")).click(); /// click on reward button

			Thread.sleep(3000);

			driver.switchTo().frame(driver.findElement(By.id("bepfm")));

			Thread.sleep(5000);

			WebElement ele = driver.findElement(By.xpath("//*[@class='mfo_c_es']"));

			String Totalpoint = ele.getText();


			String coin90;
			try {

				coin90 = Totalpoint.substring(3, 5);
			} catch (Exception e) {
				coin90 = Totalpoint.substring(2, 4);
				
			}

//		System.out.println(coin30);
			
	

			Robot r = new Robot();

			String coin9090 = "90/90";

			if (coin9090.equalsIgnoreCase(Totalpoint)) {

				System.out.println("Ohh it is already completed lets do another task....");

			} else {
				driver.switchTo().defaultContent();

				for (int j = 0; j < 30; j++) {
					Thread.sleep(2000);

					driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys("k");

					r.keyPress(KeyEvent.VK_ENTER);

					r.keyRelease(KeyEvent.VK_ENTER);
				}
				Thread.sleep(3000);

				driver.findElement(By.id("rh_meter")).click(); /// click on reward button

				Thread.sleep(1000);

				driver.switchTo().frame(driver.findElement(By.id("bepfm")));

				Thread.sleep(2000);

			}

			Thread.sleep(1000);

			System.out.println(driver.getTitle());

			String coinErn;

			List<WebElement> taskSize = driver.findElements(By.xpath("//*[@class='point_cont']"));
			System.out.println(taskSize.size());

			for (int k = 1; k <= taskSize.size(); k++) {

				try {
					Thread.sleep(1000);
					WebElement ele1 = driver.findElement(By.xpath("//*[@class='point_cont']"));

					coinErn = ele1.getText();

					ele1.click();// coin upre click kariba
					System.out.println("You earn " + k + " row " + coinErn + " point...");

				} catch (Exception e) {
					Thread.sleep(1000);

					WebElement ele1 = driver.findElement(By.xpath("//*[@class='point_cont']"));

					coinErn = ele1.getText();

					ele1.click();//
					System.out.println("You earn " + k + " row " + coinErn + " point...");

				}

				
				
				Thread.sleep(15000);

				Set<String> child = driver.getWindowHandles();

				String Aft_clk = driver.getTitle();

				System.out.println(Aft_clk);

				if ("Bing".equalsIgnoreCase(Aft_clk)) {

					for (String s : child) {
						driver.switchTo().window(parent);
					}

				}

//			System.out.println("You earn " + coinErn + " point...");
				else {
					driver.navigate().back();

					Thread.sleep(3000);

					driver.findElement(By.id("rh_meter")).click(); /// click on reward button

				}

				Thread.sleep(3000);

				driver.switchTo().frame(driver.findElement(By.id("bepfm")));

				Thread.sleep(2000);

//			taskSize=driver.findElements(By.xpath("//*[@class='point_cont']"));
//			i=taskSize.size();

			}
			driver.switchTo().defaultContent();
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id='id_n']")).click();
			
			driver.findElement(By.xpath("//*[@id='id_n']")).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			
			Thread.sleep(2000);
			
		
		}
		
		
		System.out.println("completed=================");

		driver.quit();

	}

}
