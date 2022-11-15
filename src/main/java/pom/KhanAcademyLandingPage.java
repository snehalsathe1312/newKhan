package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//login, donate, courses
public class KhanAcademyLandingPage {
	@FindBy(xpath="//a[@id='login-or-signup']")private WebElement login;
	@FindBy(xpath="//a[@data-test-id='header-donate-link']")private WebElement donate;
	@FindBy(xpath="//a[text()='Sign up']")private WebElement signUp;
	@FindBy(xpath="//span[@data-test-id='learn-menu-button']")private WebElement courses;
	@FindBy(xpath="//span[text()='Search']")private WebElement search;
	
	//Constructor
	
	public KhanAcademyLandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickOnLogin() {
		login.click();
	}
	public void clickOnDonate() {
		donate.click();
	}
	public void clickOnSignUp() {
		signUp.click();
	}
	public void cliclOnCourses() {
		courses.click();
	}
	public void clickOnSearch() {
		search.click();
	}
	

}
