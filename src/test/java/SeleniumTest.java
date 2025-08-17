import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SeleniumTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        
        System.setProperty("webdriver.edge.driver", "driver/msedgedriver");//linux_64

        // Get file
        File file = new File("src/main/ButtonClicker.html");
        String path = "file://" + file.getAbsolutePath();

        
        EdgeOptions options = new EdgeOptions();
        options.addArguments("headless");
        webDriver = new EdgeDriver(options);

        // Open the HTML file
        webDriver.get(path);
    }

    @Test
    public void testButton1() {
        // check the initial state of the text:
        WebElement displayElement = webDriver.findElement(By.id("text1"));
        assertEquals("click the button ...", displayElement.getText());

        // Find button 1 and click it
        WebElement button1 = webDriver.findElement(By.id("button1"));
        button1.click();

        assertEquals("button 1 clicked", displayElement.getText());
    }

    @Test
    public void testButton2() {
        // check the initial state of the text:
        WebElement displayElement = webDriver.findElement(By.id("text2"));
        assertEquals("now click this button ...", displayElement.getText());

        // Find button 2 and click it
        WebElement button2 = webDriver.findElement(By.id("button2"));
        button2.click();

        assertEquals("button 2 clicked", displayElement.getText());
    }

    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }
}
