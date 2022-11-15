package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//email, password, forgot password, login
public class KhanAcademyLoginPage {
	@FindBy(xpath="//input[@type='text']")private WebElement email;
	@FindBy(xpath="//input[@type='password']")private WebElement pass;
	@FindBy(xpath="//a[text()='Forgot password?']")private WebElement forgot;
	@FindBy (xpath="//button[@type='submit']")private WebElement login;
	@FindBy(xpath="//a[text()='Create an account']")private WebElement createNew;
	
	//Constructor
	
	public KhanAcademyLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String emailId, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(emailId);
	}
	public void enterPassword(String password) {
		pass.sendKeys(password);
	}
	public void  clickOnForgot() {
		forgot.click();
	}
	public void clickOnSubmit() {
		login.click();
	}
	public void createNewAccount() {
		createNew.click();
	}
	

}
