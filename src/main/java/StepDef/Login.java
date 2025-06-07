package StepDef;

import config.Env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends Env_target {
    @Given("User berada di login page")
    public void userBeradaDiLoginPage() {
        System.setProperty("webdriver.microsoft-edge.driver","F:\\QA Testing\\untitled\\src\\main\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
        //maximize driver
        driver.manage().window().maximize();
        //Set Url
        driver.get(kasir_url);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/button"))
        );
    }

    @When("User memasukkan email dan password")
    public void userMemasukkanEmailDanPassword() {
        driver.findElement(By.id("email")).sendKeys("alan@gmail.com");
        driver.findElement(By.id("password")).sendKeys("alan");

    }

    @And("User klik button login")
    public void userKlikButtonLogin() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/button")).click();
    }

    @Then("User berhasil login")
    public void userBerhasilLogin() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/h3"))
        );
        driver.quit();
    }

    @When("User memasukkan email dan password salah")
    public void userMemasukkanEmailDanPasswordSalah() {
        driver.findElement(By.id("email")).sendKeys("alan@gmail.com");
        driver.findElement(By.id("password")).sendKeys("alannn");
    }

    @Then("User gagal login")
    public void userGagalLogin() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]"))
        );
        driver.quit();
    }

    @When("^User input (.*) and (.*)$")
    public void userInputEmailAndPassword(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("^User verify login (.*)$")
    public void userVerifyLoginResult(String result) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        if(result == "true"){
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div[1]/div[1]/div/dl/dd"))
            ));
        } else if (result == "false") {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]"))
            ));
        }
        driver.quit();
    }
}
