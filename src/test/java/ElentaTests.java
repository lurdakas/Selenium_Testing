import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ElentaTests {

    public static WebDriver driver;

    @Ignore
    @Test
    public void openWebsite() {
        driver.get("https://elenta.lt/registracija");
        List<WebElement> errorelements = driver.findElements(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        Assert.assertEquals(errorelements.size(), 1);


        WebElement errorelement;
        try {
            errorelement = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
            Assert.assertEquals(errorelement.getText(), "Įveskite vartotojo vardą.");
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://elenta.lt/registracija");
    }

    @Test
    public void openRegistrationPage() {
        driver.get("https://elenta.lt/registracija");
    }

    public void acceptCookies() {
        driver.get("https://elenta.lt");
        driver.findElement(By.className("fc-cta-consent")).click();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }

    @Test
    public void test1correctRegistration() {
        driver.get("https://elenta.lt/registracija");
        WebElement usernameField = driver.findElement(By.id("UserName"));
        usernameField.sendKeys("==(o..o)==");
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("Teessttttttt@tesst.test");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("testas123");
        WebElement password2Field = driver.findElement(By.id("Password2"));
        password2Field.sendKeys("testas123");

        driver.findElement(By.className("bigNavBtn2")).click();
    }


    @Test
    public void test2uploadingPost() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("submit-new-ad-nav-button")).click();
        driver.findElement(By.className("subcategory-title-choose")).click();
        driver.findElement(By.className("subcategory-title-choose")).click();
        WebElement textBox = driver.findElement(By.id("title"));
        textBox.sendKeys("Ferrari");
        WebElement textBox2 = driver.findElement(By.className("processed"));
        textBox2.sendKeys("Experience unmatched performance with this pristine Ferrari, boasting a roaring V8 engine and sleek aerodynamic design. Own a piece of Italian luxury, meticulously maintained and ready to exhilarate on every drive.");
        WebElement phoneNo = driver.findElement(By.id("phone"));
        phoneNo.sendKeys("37062356112");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("inputfile")).sendKeys("/Users/lurdakasileviciute/Desktop/Ferrari/ferrari.jpg");
        driver.findElement(By.id("forward-button")).click();
        driver.findElement(By.id("forward-button")).click();

    }





    @AfterClass
    public void tearDown() {

    }

    @Ignore
    @Test
    public void garbagebin() throws InterruptedException {
        driver.get("https://www.elenta.lt");

        WebElement mygtukas = driver.findElement(By.className("fc-cta-consent"));
        mygtukas.click();
    }
}


