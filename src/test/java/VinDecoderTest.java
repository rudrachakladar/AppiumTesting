import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class VinDecoderTest {
    public AndroidDriver driver;
    @BeforeClass
    public void Vindecoder() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("/Users/rudranilchakladar/AndroidStudioProjects/Vindecoder_app/app/build/outputs/apk/debug/app-debug.apk");
        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @Test
    public void testOne() throws InterruptedException {
        String expectedValue="VIN: JNKCA21A4XT770979\nVehicle Type: PASSENGER CAR\nPlant City: YOKOSUKA CITY\nPlant Company Name: Oppama Plant\nPlant Country: JAPAN\nPlant State: KANAGAWA\nMake: INFINITI\n";
     driver.findElement(AppiumBy.id("com.example.vindecoder_app:id/vinEditText")).sendKeys("JNKCA21A4XT770979");
     driver.findElement(AppiumBy.id("com.example.vindecoder_app:id/submitBtn")).click();
     Thread.sleep(5000);
     String actualValue=driver.findElement(AppiumBy.id("com.example.vindecoder_app:id/vinValue")).getText();
     System.out.println(actualValue);
        Assert.assertEquals(actualValue,"JNKCA21A4XT770979");
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
