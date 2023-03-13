package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/**
 * Hello world!
 */
public class TestSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mail.ru/");

        driver.findElement(By.xpath("//button[@data-click-counter='75068996']")).click();

        WebElement loginFrame = driver.findElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']"));
        driver.switchTo().frame(loginFrame);

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("username");

        driver.findElement(By.xpath("//span[text()='Ввести пароль']")).click();

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");

        driver.findElement(By.xpath("//span[text()='Войти']")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//span[@class='compose-button__wrapper']")).click();

        driver.findElement(By.xpath("//input[@tabindex='100']")).sendKeys("dokuchaev_av@tkbbank.ru");

        driver.findElement(By.xpath("//input[@tabindex='400']")).sendKeys("Тестовое задание");

        WebElement textArea = driver.findElement(By.xpath("//div[@tabindex='505']//div[1]"));
        textArea.click();
        textArea.sendKeys("Добрый день\nПростейший автотест готов\nМарзан Вадим Владимирович");

        driver.findElement(By.xpath("//input[@class='desktopInput--3cWPE']")).sendKeys("Path to file");

        driver.findElement(By.xpath("//span[text()='Отправить']")).click();
    }
}
