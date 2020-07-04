package base;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;

public class MobileElementWrapper {

    private MobileElement element;

    public MobileElementWrapper(MobileElement element) {
        this.element = element;

    }

    public MobileElementWrapper click() {
        element.click();
        return this;
    }

    public MobileElementWrapper isDisplayed() {
        Assert.assertTrue(element.isDisplayed());
        return this;
    }
    public MobileElementWrapper checkTextEquals(String expected) {
        Assert.assertEquals(element.getText(),expected);
        return this;
    }

    public MobileElementWrapper isEnabled() {
        Assert.assertTrue(element.isEnabled());
        return this;
    }

    public MobileElementWrapper isNotDisplayed() {
        try {
            Assert.assertFalse(element.isDisplayed());
        } catch (StaleElementReferenceException ex) {
            Assert.assertFalse(true);
        }
        return this;
    }

    public MobileElementWrapper checkHtmlTextEquals(String expected) {
        Assert.assertEquals(element.getAttribute("text"), expected);
        return this;
    }

    public MobileElementWrapper typeText(String text) {
        element.sendKeys(text);
        return this;
    }
}
