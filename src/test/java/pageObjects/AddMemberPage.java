package pageObjects;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import stepDescriptions.AddAndViewMemberUsingExcel;

public class AddMemberPage extends UIInteractions{
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
	
	@FindBy(xpath = "//input[@id='remember']")
	public WebElementFacade RbIAgree;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElementFacade BtnSubmit;
	
	@FindBy(xpath = "//div[@id='toast-success']")
	public WebElementFacade TxtToastMessage;
	
	@Step(AddAndViewMemberUsingExcel.INPUT_ALL_VALUES)
	public void inputValuesToAllFieldsThenClickSubmit(
			String firstName, 
			String lastName, 
			String title,
			String company,
			String phoneNumber,
			String website,
			String email
			) 
	{
		TxtFirstName.sendKeys(firstName);
		TxtLastName.sendKeys(lastName);
		TxtTitle.sendKeys(title);
		TxtCompany.sendKeys(company);
		TxtPhoneNumber.sendKeys(phoneNumber);
		TxtWebsite.sendKeys(website);
		TxtEmail.sendKeys(email);
		RbIAgree.click();
		BtnSubmit.click();
	}
	
	@Step(AddAndViewMemberUsingExcel.VERIFY_MEMBER_IS_ADDED)
	public String gettoastMessage() 
	{
		if (TxtToastMessage.isVisible())
		{
			String id = TxtToastMessage.getText();
			return id;			
		}
		else
		{
			return "";
		}		
	}
}
