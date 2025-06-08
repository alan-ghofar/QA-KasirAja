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

public class Add_Product extends Env_target {
    @Given("user berada di dasboard page")
    public void userBeradaDiDasboardPage() {
        System.setProperty("webdriver.microsoft-edge.driver","F:\\QA Testing\\untitled\\src\\main\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
        //maximize driver
        driver.manage().window().maximize();
        //Set Url
        driver.get(Login);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/h2"))
        );
    }

    @When("user klik button produk")
    public void userKlikButtonProduk() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/a[6]/div/div/div")).click();
    }

    @And("User klik button tambah")
    public void userKlikButtonTambah() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/a")).click();
    }

    @And("user input nama produk")
    public void userInputNamaProduk() {
        driver.findElement(By.id("nama")).sendKeys("Gula");
    }

    @And("user input deskripsi produk")
    public void userInputDeskripsiProduk() {
        driver.findElement(By.id("deskripsi")).sendKeys("Gula pasir");
    }

    @And("user input harga beli produk")
    public void userInputHargaBeliProduk() {
        driver.findElement(By.id("harga beli")).sendKeys("10000");
    }

    @And("user input harga jual produk")
    public void userInputHargaJualProduk() {
        driver.findElement(By.id("harga jual")).sendKeys("10000");
    }

    @And("user input jumlah stok")
    public void userInputJumlahStok() {
        driver.findElement(By.id("stok")).sendKeys("1");
    }

    @And("user memilih jenis kategori produk")
    public void userMemilihJenisKategoriProduk() {
        driver.findElement(By.id("kategori")).click();
        driver.findElement(By.xpath("//*[@id=\"chakra-modal--body-42\"]/table/tbody/tr[1]/td")).click();
    }

    @And("user klik button simpan")
    public void userKlikButtonSimpan() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/button")).click();
    }

    @Then("user berhasil menambahkan produk")
    public void userBerhasilMenambahkanProduk() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/h2/a[2]"))
        );
        driver.quit();
    }

    @And("user empty harga jual produk")
    public void userEmptyHargaJualProduk() {
        driver.findElement(By.id("harga jual")).sendKeys("");
    }

    @And("user empty jumlah stok")
    public void userEmptyJumlahStok() {
        driver.findElement(By.id("stok")).sendKeys("");
    }

    @Then("user gagal menambahkan produk dan mendapatkan notifikasi error")
    public void userGagalMenambahkanProdukDanMendapatkanNotifikasiError() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div[1]/span"))
        );
        driver.quit();
    }
}
