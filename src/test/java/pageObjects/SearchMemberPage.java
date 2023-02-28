package pageObjects;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;

public class SearchMemberPage extends UIInteractions{
	@FindBy(xpath = "//input[@id='default-search']")
	public WebElementFacade TxtSearch;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElementFacade BtnSearch;
	
	@FindBy(xpath = "//table")
	public WebElementFacade TableOfMember;
}
