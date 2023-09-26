package guidGeneration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.utilities.Base;




public class GUIDGeneration extends Base {

 

	public static String generateGUID() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:\\Users\\Sunil.SKumbar\\eclipse-workspace\\Cucumberwithapi\\driver\\chromedriver.exe");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://guidgenerator.com/online-guid-generator.aspx");
		driver.findElement(By.xpath("//input[@name='btnGenerate']")).click();
		String text = driver.findElement(By.xpath("//textarea[@id='txtResults']")).getText();
		System.out.println(text);
		driver.close();
		return text;
	}

 

}


