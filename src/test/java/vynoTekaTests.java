import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class vynoTekaTests {

public static WebDriver driver;
public static WebDriverWait wait;



    public void testacceptCookies() {

        driver.get("https://vynoteka.lt/");
        driver.findElement(By.className("c-button--blue")).click();

    }

    public void test1ageAcceptance() {

        driver.get("https://vynoteka.lt/");
        driver.findElement(By.className("modal__content")).findElement(By.className("full-w")).click();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        test1ageAcceptance();
        testacceptCookies();

    }


    @Test
    public void test2emailAcceptance() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement ageAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"omnisend-form-63ff1f31b40d6530aba59a6d-form-close-icon\"]")));
        ageAcceptButton.click();



    }

    @Test
    public void test3emailAcceptance() throws InterruptedException {


        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement popUp;
        WebElement closeButton;


        popUp = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[4]/div/div/div/button")));
        closeButton = popUp.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/button"));
        closeButton.click();

    }

//
    @Test
    public void test4searchingUpBeverage() throws InterruptedException {

        WebElement search = driver.findElement(By.className("form-control"));
        search.sendKeys("Alus");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement ageAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("text-uppercase")));
//        ageAcceptButton.click();


    }
}
