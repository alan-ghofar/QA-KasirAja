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
import com.github.javafaker.Faker;

import java.time.Duration;
import java.util.Random;

public class Register extends Env_target {
    @Given("User berada di registrasi page")
    public void userBeradaDiRegistrasiPage() {
        System.setProperty("webdriver.microsoft-edge.driver","F:\\QA Testing\\untitled\\src\\main\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
        //maximize driver
        driver.manage().window().maximize();
        //Set Url
        driver.get(register_url);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]"))
        );
    }

    @When("user input nama toko")
    public void userInputNamaToko() {
        Random random = new Random();
        int useRandom = random.nextInt(100);
        driver.findElement(By.id("name")).sendKeys(""+ random);
    }

    @And("User input email")
    public void userInputEmail() {
        Faker  faker= new Faker();
        String email = faker.internet().emailAddress();
        driver.findElement(By.id("email")).sendKeys(email+"");
    }

    @And("User input password")
    public void userInputPassword() {
        Random random = new Random();
        int useRandom = random.nextInt(100);
        driver.findElement(By.id("password")).sendKeys(random+"");
    }

    @And("User klik button daftar")
    public void userKlikButtonDaftar() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/button")).click();
    }

    @Then("User berhasil registrasi")
    public void userBerhasilRegistrasi() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/button"))
        );
        driver.quit();

    }
}
