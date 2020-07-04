package exampe1;

import base.*;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstAndroidTest extends BaseAppiumTest {

    @Test
    public void testTwoNumbersSum() {
        MobileElement numberOne = driver.findElementById(IDGenerator.idFor("digit_1"));
        MobileElement point = driver.findElementByAccessibilityId("point");
        MobileElement numberTwo = driver.findElementById(IDGenerator.idFor("digit_2"));
        MobileElement plus = driver.findElementByAccessibilityId("plus");
        MobileElement numberThree = driver.findElementById(IDGenerator.idFor("digit_3"));
        MobileElement result = driver.findElementById(IDGenerator.idFor("result"));

        numberOne.click();
        point.click();
        numberTwo.click();
        plus.click();
        numberThree.click();
        point.click();
        numberTwo.click();
        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(),"4.4");
        MobileElement equals = driver.findElementByAccessibilityId("equals");
        equals.click();
        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(),"4.4");

    }

    @Test
    public void testTwoNumbersSumVersion2() {
        MobileElementWrapper numberOne = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_1")));
        MobileElementWrapper point = new MobileElementWrapper(driver.findElementByAccessibilityId("point"));
        MobileElementWrapper numberTwo = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_2")));
        MobileElementWrapper plus = new MobileElementWrapper(driver.findElementByAccessibilityId("plus"));
        MobileElementWrapper numberThree = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_3")));
        MobileElementWrapper result = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("result")));
        MobileElementWrapper equals = new MobileElementWrapper(driver.findElementByAccessibilityId("equals"));

        numberOne.click();
        point.click();
        numberTwo.click();
        plus.click();
        numberThree.click();
        point.click();
        numberTwo.click();
        result.isDisplayed().checkTextEquals("4.4");
        equals.isEnabled().click();
        result.isDisplayed().checkTextEquals("4.4");

    }

    @Test
    public void testDeletionChars() {
        MobileElementWrapper numberThree = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_3")));
        MobileElementWrapper numberFour = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_4")));
        MobileElementWrapper numberFive = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_5")));
        MobileElementWrapper delete = new MobileElementWrapper(driver.findElementByAccessibilityId("delete"));
        MobileElementWrapper result = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("result")));

        numberThree.click();
        numberFour.click();
        numberFive.click();
        delete.click().click().click();
        result.checkTextEquals("");
    }
    @Test
    public void testDivision(){
        MobileElementWrapper numberSeven = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_7")));
        MobileElementWrapper numberEight = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_8")));
        MobileElementWrapper divide = new MobileElementWrapper(driver.findElementByAccessibilityId("divide"));
        MobileElementWrapper numberThree = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_3")));
        MobileElementWrapper numberSix = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_6")));
        MobileElementWrapper equals = new MobileElementWrapper(driver.findElementByAccessibilityId("equals"));
        MobileElementWrapper result = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("result")));
        MobileElementWrapper plus = new MobileElementWrapper((driver.findElementByAccessibilityId("plus")));
        MobileElementWrapper numberTwo = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_2")));

        numberSeven.click();
        numberEight.click();
        divide.click();
        numberThree.click();
        numberSix.click();
        equals.click();
        result.isDisplayed().checkTextEquals("2.1666666666666");
        plus.click();
        numberTwo.click();
        numberThree.click();
        equals.click();
        result.isDisplayed().checkTextEquals("25.166666666666");

    }
    @Test

    public void testDivision2(){
        MobileElementWrapper numberSeven = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_7")));
        MobileElementWrapper numberZero = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_0")));
        MobileElementWrapper divide = new MobileElementWrapper(driver.findElementByAccessibilityId("divide"));
        MobileElementWrapper numberOne = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_1")));
        MobileElementWrapper numberFive = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_5")));
        MobileElementWrapper equals = new MobileElementWrapper(driver.findElementByAccessibilityId("equals"));
        MobileElementWrapper result = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("result")));
        MobileElementWrapper delete = new MobileElementWrapper(driver.findElementByAccessibilityId("delete"));

        numberSeven.click();
        numberZero.click();
        divide.click();
        numberOne.click();
        numberFive.click();
        equals.click();
        delete.isNotDisplayed();
        MobileElementWrapper clear = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("clr")));
        clear.click();
        result.isDisplayed().checkTextEquals("");



    }
    @Test

    public void testPercents(){

        MobileElementWrapper numberTwo = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_2")));
        MobileElementWrapper numberFive = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_5")));
        MobileElementWrapper equals = new MobileElementWrapper(driver.findElementByAccessibilityId("equals"));
        MobileElementWrapper advancedPad = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("pad_advanced")));
        MobileElementWrapper result = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("result")));

        numberTwo.click();
        numberFive.click();
        advancedPad.click();
        MobileElementWrapper percentage = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("op_pct")));
        percentage.click();
        driver.navigate().back();
        equals.click();
        result.isDisplayed().checkTextEquals("0.25");

    }
    @Test

    public void testOpenSourceLicenses(){

        MobileElementWrapper toolBar = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("toolbar")));
        MobileElementWrapper moreOptions = new MobileElementWrapper(driver.findElementByAccessibilityId("More options"));
        toolBar.click();
        moreOptions.click();
        MobileElementWrapper openSourceLicensesButton = new MobileElementWrapper(driver.findElement(By.xpath("//android.widget.TextView[@text='Open source licenses']")));
//        if (platform.equals("Android")) {
//            openSourceLicensesButton = new MobileElementWrapper(driver.findElement(By.xpath("//android.widget.TextView[@text='Open source licenses']")));
//        } else {
//            openSourceLicensesButton = new MobileElementWrapper(driver.findElement(By.xpath("//ios.somepackage.TextWidget[@text='Open source licenses']")));
//        }
        openSourceLicensesButton.click();
        MobileElementWrapper openSourceLicensesTitle = new MobileElementWrapper(driver.findElementByAccessibilityId("Notices for files:"));
        MobileElementWrapper openSourceLicensesText = new MobileElementWrapper(driver.findElementsByClassName("android.view.View").get(1));
        openSourceLicensesTitle.isDisplayed();
        openSourceLicensesText.isDisplayed();

    }

    @Test

    public void testOperationSavedInHistory(){
        MobileElementWrapper numberTwo = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_2")));
        MobileElementWrapper plus = new MobileElementWrapper((driver.findElementByAccessibilityId("plus")));
        MobileElementWrapper numberThree = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_3")));
        MobileElementWrapper equals = new MobileElementWrapper(driver.findElementByAccessibilityId("equals"));
        MobileElementWrapper moreOptions = new MobileElementWrapper(driver.findElementByAccessibilityId("More options"));
        numberTwo.click();
        plus.click();
        numberThree.click();
        equals.click();
        moreOptions.click();
        MobileElementWrapper history = new MobileElementWrapper(driver.findElementsByClassName("android.widget.LinearLayout").get(0));
        history.click();
        MobileElementWrapper recentOperation = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("history_formula")));
        MobileElementWrapper recentResult = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("history_result")));
        recentOperation.isDisplayed().checkTextEquals("2+3");
        recentResult.isDisplayed().checkTextEquals("5");

    }
    @Test
    public void testingHistoryNavigation(){
        MobileElementWrapper moreOptions = new MobileElementWrapper(driver.findElementByAccessibilityId("More options"));
        moreOptions.click();
        MobileElementWrapper history = new MobileElementWrapper(driver.findElementsByClassName("android.widget.LinearLayout").get(0));
        history.click();
        MobileElementWrapper historyBackButton = new MobileElementWrapper(driver.findElementByAccessibilityId("Navigate up"));
        historyBackButton.click();
        MobileElementWrapper numericPad = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("pad_numeric")));
        numericPad.isDisplayed();

    }
    @Test
    public void testingClearHistory(){
        MobileElementWrapper numberTwo = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_2")));
        MobileElementWrapper plus = new MobileElementWrapper((driver.findElementByAccessibilityId("plus")));
        MobileElementWrapper numberThree = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("digit_3")));
        MobileElementWrapper equals = new MobileElementWrapper(driver.findElementByAccessibilityId("equals"));
        MobileElementWrapper moreOptions = new MobileElementWrapper(driver.findElementByAccessibilityId("More options"));
        numberTwo.click();
        plus.click();
        numberThree.click();
        equals.click();
        moreOptions.click();
        MobileElementWrapper history = new MobileElementWrapper(driver.findElement(By.xpath(XPathGenerator.toXPathWithText("History"))));
        history.click();
        MobileElementWrapper recentOperation = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("history_formula")));
        MobileElementWrapper recentResult = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("history_result")));
        recentOperation.isDisplayed().checkTextEquals("2+3");
        recentResult.isDisplayed().checkTextEquals("5");

        MobileElementWrapper moreOptions2 = new MobileElementWrapper(driver.findElement(By.xpath(XPathGenerator.toXPathWithContentDesc("More options"))));
//        MobileElementWrapper moreOptions2 = new MobileElementWrapper(driver.findElement(By.xpath("//*[@content-desc='More options'])")));
        moreOptions2.click();
        MobileElementWrapper clearButton = new MobileElementWrapper(driver.findElementById("android:id/title"));
        clearButton.click();
        MobileElementWrapper confirmClear = new MobileElementWrapper(driver.findElementById("android:id/button1"));
        confirmClear.click();
        moreOptions = new MobileElementWrapper(driver.findElementByAccessibilityId("More options"));
        moreOptions.click();
//        history = new MobileElementWrapper(driver.findElement(By.xpath("//android.widget.TextView[@text='History']")));
        history = new MobileElementWrapper(driver.findElement(By.xpath(XPathGenerator.toXPathWithText("History"))));
        history.click();
 //       MobileElementWrapper noHistoryText = new MobileElementWrapper(driver.findElement(By.xpath("//android.widget.TextView[@text='No History']")));
        MobileElementWrapper noHistoryText = new MobileElementWrapper(driver.findElement(By.xpath(XPathGenerator.toXPathWithText("No History"))));
        noHistoryText.isDisplayed();


    }
    @Test

    public void testToolBarSlide(){
        TouchWrapper.slide(driver,100,100,100,500);

        MobileElementWrapper toolBar = new MobileElementWrapper(driver.findElementById(IDGenerator.idFor("toolbar")));
    }

}
