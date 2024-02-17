package pack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestClass_One {

    public static WebDriver driver = null;

    @BeforeMethod
    public void initialize() throws IOException {

        //driver exe = fonctionne
//        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
//        driver = new ChromeDriver();

        //driver manager = fonctionne
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        System.out.println("TEST CLASS ONE !!!");
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    @Test
    public void Test1() throws InterruptedException {
        System.out.println("I'm inside Test 1 ");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Test 1 title is " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        Thread.sleep(3000);
    }

    @Test
    public void Test2() throws InterruptedException {
        System.out.println("I'm inside Test 2 ");
        driver.get("https://www.youtube.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Test 2 title is " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "YouTube");
        Thread.sleep(3000);
    }

    @Test
    public void Test3() throws InterruptedException {
        System.out.println("I'm inside Test 3 ");
        driver.get("https://www.nike.com/fr/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Test 3 title is " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Nike. Just Do It. Nike FR");
        Thread.sleep(3000);
    }

}
