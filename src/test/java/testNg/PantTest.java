package testNg;

import org.example.core.data.DataProviderMethods;
import org.example.core.listeners.RetryListener;
import org.example.pages.LoginPage;
import org.example.pages.PantPage;
import org.testng.annotations.Test;

import java.awt.*;

public class PantTest extends BaseTest{
    @Test(dataProvider = "dataForLoginTest", dataProviderClass = DataProviderMethods.class,
            retryAnalyzer = RetryListener.class)
    public void canPant(String title, String size, String color){
       PantPage pantPage = new PantPage(driver);
        pantPage.open();
        pantPage.setTitle(title);
        pantPage.setSize(size);
        pantPage.setColor(color);
        pantPage.getElSizeError().click();
        pantPage.getElColorError().click();
    }
}
