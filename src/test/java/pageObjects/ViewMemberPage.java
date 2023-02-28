package pageObjects;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;

public class ViewMemberPage extends UIInteractions{
	@FindBy(xpath = "//input[@id='first_name']")
	public WebElementFacade TxtFirstName;
	
	@FindBy(xpath = "//input[@id='last_name']")
	public WebElementFacade TxtLastName;
	
	@FindBy(xpath = "//input[@id='title']")
	public WebElementFacade TxtTitle;
	
	@FindBy(xpath = "//input[@id='company']")
	public WebElementFacade TxtCompany;
	
	@FindBy(xpath = "//input[@id='phone']")
	public WebElementFacade TxtPhoneNumber;
	
	@FindBy(xpath = "//input[@id='website']")
	public WebElementFacade TxtWebsite;
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElementFacade TxtEmail;
	
	@FindBy(xpath = "//input[@id='default-search']")
	public WebElementFacade TxtSearch;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElementFacade BtnSearch;
}
