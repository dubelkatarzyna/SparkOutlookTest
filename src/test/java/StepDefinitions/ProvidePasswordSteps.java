package StepDefinitions;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProvidePasswordSteps extends BaseUtil {

    private BaseUtil base;
    private WebDriverWait wait = new WebDriverWait(base.Driver, 5);

    public ProvidePasswordSteps(BaseUtil base) {
        this.base = base;
    }

    @When("^user provides password$")
    public void userProvidesPassword() {
        base.Driver.findElement(By.cssSelector("#i0118")).sendKeys("password"); //string to be updated to a real password
    }

    @And("^clicks on sign in button$")
    public void clicksOnSignInButton() {
        base.Driver.findElement(By.cssSelector("#idSIButton9")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id__3")));
    }

    @Then("^user is successfully logged in$")
    public void userIsSuccessfullyLoggedIn() {
        Assert.assertTrue(base.Driver.getTitle().contains("Mail"));
        base.Driver.close();
    }
}
