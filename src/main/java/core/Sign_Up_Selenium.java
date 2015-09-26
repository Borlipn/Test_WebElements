package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;;

public class Sign_Up_Selenium {

	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
				//WebDriver driver = new HtmlUnitDriver(); 
				//((HtmlUnitDriver) driver).setJavascriptEnabled(true);
				WebDriver driver = new FirefoxDriver();
				//WebDriver driver = new ChromeDriver();
				
				String text_case_id_01 = "TC-001.01";
				//String text_case_id_02 = "TC-001.02";
				String text_case_id_03 = "TC-001.03";
				String text_case_id_04 = "TC-001.04";
				//String text_case_id_05 = "TC-001.05";
				String url = "http://learn2test.net/qa/apps/sign_up/v1/";
				String title_sign_up_expected = "Welcome to Sign Up v1";
				String fname = "Peter";
				String lname = "Loop";
				String email = "PeterL@gmail.com";
				String phone = "415 555-1212";

				// TC-001.01

				driver.get(url);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				String title_sign_up_actual = driver.getTitle();

				if (title_sign_up_expected.equals(title_sign_up_actual)) {
					System.out.println("Test Case ID: \t\t" + text_case_id_01 + " - PASSED");
					System.out.println("Title Expected/Actual: \t" + title_sign_up_expected + "/" + title_sign_up_actual);
					System.out.println("=======================================");
				} else {
					System.out.println("Test Case ID: \t\t" + text_case_id_01 + " - FAILED");
					System.out.println("Title Expected/Actual: \t" + title_sign_up_expected + "/" + title_sign_up_actual);
					System.out.println("=======================================");
				}
			
				// TC-001.02	
				
				String csvFile_errs = "./src/main/resources/Errors_messages.csv";
				BufferedReader br_errs = null;
				String line_errs = null;
				String SplitBy_errs = ",";
			    String test_case_id_err = null;
			    String err_message_expected = null;
			    String err_message_actual = null;
			    int i=0;

			    br_errs = new BufferedReader(new FileReader(csvFile_errs));
			    
		        while ((line_errs = br_errs.readLine()) != null) {
			    		i= i + 1;
			    		String[] csv_errs = line_errs.split(SplitBy_errs);
				
						test_case_id_err = csv_errs[0];
						err_message_expected = csv_errs[1];
						err_message_actual = csv_errs[2];

						driver.findElement(By.id("id_submit_button")).click();
						err_message_actual = driver.findElement(By.id("ErrorLine")).getText();

				if (err_message_expected.equals(err_message_actual)) {
					System.out.println("Test Case ID: \t\t" + test_case_id_err + " - PASSED");
					System.out.println("Error Expected/Actual: \t" + err_message_expected + "/" + err_message_actual);
					System.out.println("=======================================");
				} else {
					System.out.println("Test Case ID: \t\t" + test_case_id_err + " - FAILED");
					System.out.println("Error Expected/Actual: \t" + err_message_expected + "/" + err_message_actual);
					System.out.println("======================================="); 	}
				 if (i == 1) {
	            	 driver.findElement(By.id("id_fname")).sendKeys(fname); 
	             } else if (i == 2) {
	 				driver.findElement(By.id("id_lname")).sendKeys(lname);
	             } else if (i == 3) {
					driver.findElement(By.id("id_email")).sendKeys(email);
	             } else if (i == 4) {
					driver.findElement(By.id("id_phone")).sendKeys(phone);
	             }}
			    br_errs.close();
			    driver.findElement(By.id("id_reset_button")).click();
			    
				
			// TC-001.03

				driver.findElement(By.id("id_fname")).sendKeys(fname);
				driver.findElement(By.id("id_lname")).sendKeys(lname);
				driver.findElement(By.id("id_email")).sendKeys(email);
				driver.findElement(By.id("id_phone")).sendKeys(phone);
				driver.findElement(By.id("id_g_radio_01")).click();
				Select sel = new Select(driver.findElement(By.tagName("select")));
		        	   sel.selectByIndex(6);
		        driver.findElement(By.id("id_checkbox")).click();
		        
				driver.findElement(By.id("id_submit_button")).click();
				
		
				String fname_conf_actual = driver.findElement(By.id("id_fname_conf")).getText();
				String lname_conf_actual = driver.findElement(By.id("id_lname_conf")).getText();
				String email_conf_actual = driver.findElement(By.id("id_email_conf")).getText();
				String phone_conf_actual = driver.findElement(By.id("id_phone_conf")).getText();
								
		
				if (fname.equals(fname_conf_actual) && lname.equals(lname_conf_actual) && email.equals(email_conf_actual) && phone.equals(phone_conf_actual)) {
				System.out.println("Test Case ID: \t\t" + text_case_id_03 + " - PASSED");
				System.out.println("First Expected/Actual: \t" + fname + "/"+ fname_conf_actual);
				System.out.println("Last Expected/Actual: \t" + lname + "/" + lname_conf_actual);
				System.out.println("Email Expected/Actual: \t" + email + "/" + email_conf_actual);
				System.out.println("Phone Expected/Actual: \t" + phone + "/" + phone_conf_actual);
				System.out.println("=======================================");
						} else {
				System.out.println("Test Case ID: \t\t" + text_case_id_03 + " - FAILED");
				System.out.println("First Expected/Actual: \t" + fname + "/"+ fname_conf_actual);
				System.out.println("Last Expected/Actual: \t" + lname + "/" + lname_conf_actual);
				System.out.println("Email Expected/Actual: \t" + email + "/" + email_conf_actual);
				System.out.println("Phone Expected/Actual: \t" + phone + "/" + phone_conf_actual);
				System.out.println("=======================================");
						}
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.findElement(By.id("id_back_button")).click(); 
		
				
				// TC-001.04

				driver.findElement(By.id("id_quotes")).getText();
				String quote = driver.findElement(By.id("id_quotes")).getText();
				if (quote != null && quote.length() < 103 && quote.length() > 36) {
					System.out.println("Test Case ID: \t\t" + text_case_id_04 + " - PASSED");
					System.out.println("Quote length: " + quote.length());
					System.out.println("=======================================");
				} else {
					System.out.println("Test Case ID: \t\t" + text_case_id_04 + " - FAILED");
					System.out.println("Quote length: " + quote.length());
					System.out.println("=======================================");
				} 
				
							    
				// TC-001.05
				
			  
			String csvFile_weblink = "./src/main/resources/WebLinks.csv";
				BufferedReader br_weblink = null;
				String line_weblink = null;
				String SplitBy_weblink = ",";
			    String test_case_id = null;
			    String title_expected = null;
			    String element_id = null;
			    

			    br_weblink = new BufferedReader(new FileReader(csvFile_weblink));
				
			    while ((line_weblink = br_weblink.readLine()) != null) {

					String[] csv_weblink = line_weblink.split(SplitBy_weblink);

					test_case_id = csv_weblink[0];
					title_expected = csv_weblink[1];
					element_id = csv_weblink[2];
					
				 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				 driver.getWindowHandle();
				 driver.findElement(By.id(element_id)).click();
				
				
				 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				 ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
				 driver.switchTo().window(allTabs.get(1));
				  
				 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				 String title_actual = driver.getTitle();
				 driver.close();
				 driver.switchTo().window(allTabs.get(0));

				 if (title_expected.equals(title_actual)) {
				 	System.out.println("Test Case ID: \t\t" + test_case_id + " - PASSED");
				 	System.out.println("Title Expected/Actual: \t" + title_expected + "/" + title_actual);
				 	System.out.println("=======================================");
				 	} else {
					System.out.println("Test Case ID: \t\t" + test_case_id + " - FAILED");
					System.out.println("Title Expected/Actual: \t" + title_expected + "/" + title_actual);
					System.out.println("=======================================");
				}
			}
			    br_weblink.close(); 
			   driver.quit();
				
			
		}
	}
		// END
