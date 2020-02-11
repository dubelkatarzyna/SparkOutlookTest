package StepDefinitions;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProvideUserLoginSteps extends BaseUtil {

    private BaseUtil base;
    private WebDriverWait wait = new WebDriverWait(base.Driver, 5);

    public ProvideUserLoginSteps(BaseUtil base) {
        this.base = base;
    }

    @When("^user provides username$")
    public void userProvidesUsername() {
        base.Driver.findElement(By.cssSelector("#i0116")).sendKeys("username"); //string to be updated to a real value
    }

    @And("^clicks on next button$")
    public void clicksOnNextButton() {
        base.Driver.findElement(By.cssSelector("#idSIButton9")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#idA_PWD_ForgotPassword")));
    }

    @Then("^password page opens$")
    public void passwordPageOpens() {
        Assert.assertTrue(base.Driver.getPageSource().contains("Enter password"));
    }
}
