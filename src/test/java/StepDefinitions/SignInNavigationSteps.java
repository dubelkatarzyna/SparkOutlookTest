package StepDefinitions;

import Base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInNavigationSteps extends BaseUtil {

    private BaseUtil base;
    private WebDriverWait wait = new WebDriverWait(base.Driver, 5);

    public SignInNavigationSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^a web browser is opened in login page$")
    public void aWebBrowserIsOpenedInLoginPage() {
        base.Driver.navigate().to("https://outlook.live.com/owa/");
        Assert.assertEquals(base.Driver.getTitle(), "Outlook – free personal email and calendar from Microsoft");
    }

    @When("^a user clicks on the sign in button$")
    public void aUserClicksOnTheSignInButton() {
        base.Driver.findElement(By.xpath("/html/body/header/div/aside/div/nav/ul/li[2]/a")).click();
        wait.until(ExpectedConditions.titleIs("Sign in to your Microsoft account"));
    }

    @Then("^sign in page opens$")
    public void signInPageOpens() {
        Assert.assertEquals(base.Driver.getTitle(), "Sign in to your Microsoft account");
    }
}
