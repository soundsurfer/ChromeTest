import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {

    @Test
    public void chromeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Валентин\\Downloads\\chromedriver_win32\\" +
                "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com");
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("eaccun353");
        driver.findElement(By.xpath("//div[2]/div/div/div/content/span")).click();

        Thread.sleep(1500);

        driver.findElement(By.xpath("//div/input")).sendKeys("hidriver12345");
        driver.findElement(By.xpath("//div/div/content/span")).click();

        Thread.sleep(1500);

        WebElement loggedUserIn = driver.findElement(By.xpath("//c-wiz/div/div/div/div[3]"));
        Assert.assertEquals(loggedUserIn.getText(), "На этой странице вы можете изменить настройки аккаунта " +
                "и защитить свои данные");

        Thread.sleep(1500);
        driver.close();
        //eaccun353, pass: hidriver12345
    }
    @Test
    public void chromeTestNegative() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Валентин\\Downloads\\chromedriver_win32\\" +
                "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com");
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("eaccun353");
        driver.findElement(By.xpath("//div[2]/div/div/div/content/span")).click();

        Thread.sleep(5500);
        driver.findElement(By.xpath("//div/input")).sendKeys("hidriver12344");
        driver.findElement(By.xpath("//div/div/content/span")).click();
        Thread.sleep(1500);

        WebElement negativePass = driver.findElement(By.xpath("//div[2]/div[2]"));
        Assert.assertEquals(negativePass.getText(), "Добро пожаловать!\n" +
                "eaccun353@gmail.com\n" +
                "Введите пароль\n" +
                "Неверный пароль. Повторите попытку или нажмите на ссылку \"Забыли пароль?\", чтобы сбросить его.\n" +
                "Далее\n" +
                "Забыли пароль?.");
        Thread.sleep(1500);
        driver.close();
    }
}
