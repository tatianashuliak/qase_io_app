package qaseapp.ui.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import qaseapp.ui.driver.DriverSingleton;
import qaseapp.ui.utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    @BeforeClass
    public void startBrowser() {
        driver = DriverSingleton.getInstance().getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.getInstance().closeDriver();
    }
}
