import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class Assignment7 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","..\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		driver.get("https://AutomationPractice/");
		
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		List<WebElement> HeadingValues=driver.findElements(By.cssSelector(".table-display th:nth-child(2)"));
		
		List<WebElement> Values=driver.findElements(By.cssSelector(".table-display td:nth-child(2)"));
		
		int Total=HeadingValues.size()+Values.size();
         System.out.println(Total);
         Assert.assertEquals(Total,11);
         
         
         List<WebElement> ColumnValues = driver.findElements(By.cssSelector(".table-display th"));
         int ColumnTotal=ColumnValues.size();
         System.out.println(ColumnTotal);
         Assert.assertEquals(ColumnTotal,3);
         String[] Product=new String[ColumnTotal];
         for(int i=1;i<=Values.size();i++) {

        	 if(i==1) {
        		 for(int j=1;j<=ColumnTotal;j++) {
        			 Product[j-1]=driver.findElement(By.cssSelector(".table-display td:nth-child("+j+")")).getText();
        		 }
        		break; 
        	 }
         }
         for(int j=0;j<ColumnTotal;j++) {
        	 System.out.println(Product[j]);
        	 
         }


	}

}
