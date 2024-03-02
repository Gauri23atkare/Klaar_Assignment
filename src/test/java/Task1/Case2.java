package Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import lombok.experimental.FieldNameConstants;

public class Case2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver","D:\\Eclipse-Workspace\\Klaar_Assignment\\Driver\\chromedriver.exe");
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
					Thread.sleep(5000);
					
					//Step 2: Navigate to userList page
					driver.findElement(By.linkText("User List")).click();
					Thread.sleep(5000);
					
					//Custom field
					driver.findElement(By.xpath("(//div[@class='ant-tabs-tab-btn'])[3]")).click();
					Thread.sleep(5000);
					//Add Field
					 driver.findElement(By.xpath("//button[@class='ant-btn tw-mr-4 ant-btn-primary']")).click();
					 Thread.sleep(5000);
					 //Step 3:Enter name and select field type in date
					WebElement fieldname = driver.findElement(By.xpath("(//input[@placeholder='Enter field name...'])[1]"));
					fieldname.sendKeys("Filetest");
					 Thread.sleep(5000);
					// Step 4:
					 WebElement Listfield = driver.findElement(By.xpath("//nz-select[@formcontrolname='fieldType']"));
					  Listfield.click();
					  driver.findElement(By.xpath("//*[@title='Date']")).click();
				        //Step 5: save the field
				        driver.findElement(By.xpath("//button[@data-cy=\"modal-submit-button\"]")).click();
				       // Step6:Verify that custom field on custom field page
				        String Customfile = driver.findElement(By.xpath("//tr[1]//td[2]")).getText();
				         System.out.println(Customfile);
//				         WebElement editbtn=driver.findElement(By.xpath("//div[@class='tw-cursor-pointer tw-ml-2 ant-col']"));
//						 editbtn.click();
//						 Thread.sleep(5000);
//						 fieldname.clear();
//						 Thread.sleep(5000);
//						 fieldname.sendKeys("03/03/2024");
				         
				       //Step:7 Add a new custom field of type List with 3 list options.
				         driver.findElement(By.xpath("//button[@class='ant-btn tw-mr-4 ant-btn-primary']")).click();
				         Thread.sleep(5000);
				         driver.findElement(By.xpath("(//input[@placeholder='Enter field name...'])[1]")).sendKeys("List_name");
						 Thread.sleep(5000);
						 WebElement Listfield1= driver.findElement(By.xpath("//nz-select[@formcontrolname='fieldType']"));
						 Listfield1.click();
						 driver.findElement(By.xpath("//*[@title='List']")).click();
						WebElement AddItem = driver.findElement(By.xpath("//button[@class='ant-btn tw-rounded-lg tw-text-purple4']"));
						
						 driver.findElement(By.xpath("//input[@placeholder='Option List']")).sendKeys("L1");
						 AddItem.click();
						 driver.findElement(By.xpath("//input[@placeholder='Option List']")).sendKeys("L2");
						 AddItem.click();
						 driver.findElement(By.xpath("//input[@placeholder='Option List']")).sendKeys("L3");
						 //submit
						 driver.findElement(By.xpath("//button[@data-cy='modal-submit-button']")).click();
						 //Step 8 & 9: Select List item for custom field
						 Listfield1.getText();
						 System.out.println("Custom Listfiled is diaplaying.."+Listfield1);
						
						 //Step 10 :Toggle the switch of custom field
			       WebElement toggleSwitch = driver.findElement(By.xpath("//button[@class='ant-switch ant-switch-checked']"));
			       // Check the initial state of the toggle switch
			       boolean isSwitchOn = toggleSwitch.isDisplayed();
		            System.out.println("Toggle Switch is initially " + (isSwitchOn ? "ON" : "OFF"));
		            
		            // Toggle the switch (if it's initially off, turn it on, and vice versa)
		            toggleSwitch.click();

		            // Verify the updated state of the toggle switch
		            isSwitchOn = toggleSwitch.isSelected();
		            System.out.println("Toggle Switch is now " + (isSwitchOn ? "ON" : "OFF"));
                   //Step 11: Delete the custom field
		            WebElement deleteCustomfield = driver.findElement(By.xpath("//span[@class='anticon tw-text-red-500 tw-cursor-pointer tw-ml-2 anticon-delete']"));
                      deleteCustomfield.click();
	}

}
