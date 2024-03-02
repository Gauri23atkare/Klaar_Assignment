package Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Case1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver","D:\\Eclipse-Workspace\\Klaar_Assignment\\Driver\\chromedriver.exe");
		  // Open the Chrome browser
			WebDriver driver = new ChromeDriver();
			//Maximize the window
			driver.manage().window().maximize();
			//Step 1: Log in using user credentials
			
			driver.get("https://dev.klaarhq.com/");
			//Click on Login
			driver.findElement(By.xpath("//div[@data-cy='login-with-klaar-button']")).click();
			//username
			driver.findElement(By.xpath("//input[@data-cy='login-email-text-field']")).sendKeys("deepa.nayak@gamma.klaar.team");
			//password
			driver.findElement(By.xpath("//input[@data-cy='login-password-text-field']")).sendKeys("Klaar2021");
			//Login Button
			driver.findElement(By.xpath("//button[@id='login-btn']")).click();
			Thread.sleep(5000);
			// Step 2: Navigate to the Settings module
			
				driver.findElement(By.xpath("//button[@data-cy='settings-nav-menu-button']//li[1]")).click();
				Thread.sleep(3000);
				 driver.findElement(By.xpath("//a[@href='/settings/workspace/details']")).click(); 
				 String expectedTitle = "Workspace";
			        String actualTitle = driver.getTitle();
			        if (actualTitle.equals(expectedTitle)) {
			            System.out.println("Page title is correct: " + expectedTitle);
			        } else {
			            System.out.println("Page title is incorrect. Expected: " + expectedTitle + ", Actual: " + actualTitle);
			        }
			        //Step 4: Validate the appearance and functionality of the workspace settings page.
			        Thread.sleep(5000);
			        driver.findElement(By.xpath("//input[@data-cy='settings-workspace-name-field']")).clear();
			     driver.findElement(By.xpath("//input[@data-cy='settings-workspace-name-field']")).sendKeys("Gauri.Atkare");
			        Thread.sleep(5000);
	            driver.findElement(By.xpath("//button[@data-cy='settings-workspace-save-changes-button']")).click();
	            //Step 5: Add new workspace logo
	            Thread.sleep(5000);
	            WebElement uploadLogo = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-lg ng-star-inserted']"));
	            uploadLogo.click();
	            Thread.sleep(5000);
	            uploadLogo.sendKeys("C:\\Users\\DELL\\Downloads\\Linkdein_Logo.png");
	            Thread.sleep(5000);
	            WebElement newLogo = driver.findElement(By.xpath("//img[@alt='Workspace Logo']"));
	            if(newLogo.isDisplayed()) {
	                System.out.println("Logo updated successfully.");
	            } else {
	                System.out.println("Failed to update logo.");
	            }
	                    
	            
	            WebElement deleteButton = driver.findElement(By.xpath("//button[@data-cy='settings-workspace-logo-delete-button']"));
	            deleteButton.click();
	            
	            WebElement deleteButton1 = driver.findElement(By.xpath("//button[@data-cy='settings-workspace-logo-confirm-delete-button']"));
	            deleteButton1.click();
	            
	            driver.quit();
	            
	}

}
