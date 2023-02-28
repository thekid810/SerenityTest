package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import stepDescriptions.AddAndViewMemberUsingExcel;
import org.openqa.selenium.support.FindBy;

public class HomePage extends UIInteractions{
	
	@FindBy(xpath = "//a[text()='Add Member']")
    public WebElementFacade AddMemberTab;
	
	@FindBy(xpath = "//a[text()='Search Member']")
	public WebElementFacade SearchMemberTab;
	
	@FindBy(xpath = "//a[text()='View Member']")
	public WebElementFacade ViewMemberTab;
	
	@FindBy(xpath = "//a[text()='Home']")
	public WebElementFacade HomeTab;	
	
	@Step(AddAndViewMemberUsingExcel.NAVIGATE_TO_HOME_PAGE)
	public void navigateToHomePage() {
	    open();
	}
	
	@Step(AddAndViewMemberUsingExcel.CLICK_ADD_MEMBER_TAB)
	public void clickAddMemberTab() {
		AddMemberTab.click();
	}
}
