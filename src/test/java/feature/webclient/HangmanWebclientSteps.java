package feature.webclient;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloWebclientSteps {
    WebDriver driver = new ChromeDriver();

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }

    @Given("^I am on the (\\w+) page$")
    public void i_am_on_the_hangman_page(String pageName) throws Throwable {
        driver.get("http://localhost:8080/" + pageName + ".html");
    }")
    
    @When("^I enter \"([^\"]*)\"$")
    public void i_enter(String newGuess) throws Throwable {
        driver.findElement(By.id("newGuesses")).sendKeys(newGuess);
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see whether the input is correct$") 
    public void i_see_whether_the_input_is_correct_or_wrong() throws Throwable {      
            //(new WebDriverWait(driver, 10))

            int size = ((driver.findElement(By.id("pattern"))).getText()).length();
            String element = driver.findElement(By.id("pattern")).getText();
            String element2 = driver.findElement(By.id("newGuesses")).getText();
            boolean found = false;
            for(int i =0; i < size; i++){
                if(element[i] == element2){
                    found = true;
                    //break;
                }
            }
            assertThat(found, equalsTo(true));
            //.until(ExpectedConditions.textToBe(By.id("greet."), greeting));
    }
}
