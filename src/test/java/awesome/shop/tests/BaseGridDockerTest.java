package awesome.shop.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BaseGridDockerTest extends BaseConfigurationGridDockerTest {
    @Test
    public void firstTest() {
        driver.findElement(By.id("input-email")).sendKeys("nivanis@yandex.ru");
        driver.findElement(By.id("input-password")).sendKeys("testPassword");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//ul[contains(@class,'menu-right')]//a[text()='Logout']")).click();
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
    }
}
