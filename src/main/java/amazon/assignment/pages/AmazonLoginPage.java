package amazon.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.assignment.util.WebBasePage;

public class AmazonLoginPage extends WebBasePage{
	private WebDriver webDriver=null;
	private String testName="";
	private final By LABELTEXT=By.xpath("//label[@for='ap_email']");
	private final By SIGNINBOX=By.xpath("//input[@id='ap_email']");
	
	public AmazonLoginPage(WebDriver webDriver, String testName) {
		this.webDriver=webDriver;
		this.testName=testName;
		waitForPageLoad();
	}
	
	/**
	 * method to verify Sign in Label
	 * @return
	 */
	public  boolean  verifySigninText()  {
		try
		{
			String text = webDriver.findElement(LABELTEXT).getText().trim();
			if(text.equalsIgnoreCase("E-mail address or mobile phone number"))
			{
				return true;
			}else {
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	/**
	 * method to verify Sign in Box
	 * @return
	 */
	public  boolean  verifySigninBox()  {
		try
		{
			return 	webDriver.findElement(SIGNINBOX).isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public void waitForPageLoad() {
		try {
			WebDriverWait wait=new WebDriverWait(webDriver,40);
			wait.until(ExpectedConditions.presenceOfElementLocated(SIGNINBOX));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
