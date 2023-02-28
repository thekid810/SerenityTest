package testcases;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pageObjects.AddMemberPage;
import pageObjects.HomePage;
import utilities.ExcelReader;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@ExtendWith(SerenityJUnit5Extension.class)
class AddAndViewMemberUsingExcel {

    @Managed(driver = "chrome")
    WebDriver driver;

    // Initialize the page objects
    @Steps
    HomePage homePage;
    
    @Steps
    AddMemberPage addMemberPage;

    String id;
    @BeforeEach
    void setUp() {
    	// Enter URL
        homePage.navigateToHomePage();       
    }
    
    @ParameterizedTest
    @MethodSource("getData")
    @Title("Add member and View Member's informations")
    void addAndViewMember(String firstName, String lastName, String title, String company, String phoneNumber, String website, String email) {
    	// Click on Add Member
        homePage.clickAddMemberTab();
    	
    	// Enter all values then click Submit
        addMemberPage.inputValuesToAllFieldsThenClickSubmit(firstName, lastName, title, company, phoneNumber, website, email);
        String toastMessage = addMemberPage.gettoastMessage();
        if (toastMessage != "")
        {
        	int index = toastMessage.indexOf("ID: ");
            id = toastMessage.substring(index+4);
        }
        assertThat(toastMessage).isNotEmpty();
    }
    
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
    
    public static List<Object[]> getData() throws IOException {
        return ExcelReader.getAllData("src/test/resources/testdata/informations.xlsx", "TestData");
    }
}