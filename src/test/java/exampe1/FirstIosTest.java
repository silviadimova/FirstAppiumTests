package exampe1;

import base.BaseAppiumTest;
import base.MobileElementWrapper;
import base.TouchWrapper;
import base.XPathGenerator;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FirstIosTest extends BaseAppiumTest {

    @Test
    public void testSearchContactExists() {
        MobileElementWrapper search = new MobileElementWrapper(driver.findElementByAccessibilityId("Search"));
        search.typeText("Jo");
        MobileElementWrapper searchResult = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("John Appleseed")));
        searchResult.click();

    }
    @Test
    public void testAddNewContact() {
        MobileElementWrapper add = new MobileElementWrapper(driver.findElementByAccessibilityId("Add"));
        add.click();
        MobileElementWrapper firstName = new MobileElementWrapper(driver.findElementByAccessibilityId("First name"));
        MobileElementWrapper lastName = new MobileElementWrapper(driver.findElementByAccessibilityId("Last name"));
        MobileElementWrapper company = new MobileElementWrapper(driver.findElementByAccessibilityId("Company"));
        firstName.typeText("John");
        lastName.typeText("Farrow");
        company.typeText("BGFF");
        MobileElementWrapper done = new MobileElementWrapper(driver.findElementByAccessibilityId("Done"));
        done.click();

        MobileElementWrapper contactsBackNavigation = new MobileElementWrapper(driver
                .findElementByAccessibilityId("CNContactView")
                .findElement(By.xpath(XPathGenerator.toXPathWithText("Contacts")))
        );
        contactsBackNavigation.click();
        MobileElementWrapper savedContact = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("John Farrow")));
        savedContact.click();

        MobileElementWrapper savedName = new MobileElementWrapper(driver.findElement(By.xpath(XPathGenerator.toXPathWithText("John Farrow"))));
        MobileElementWrapper savedCompany = new MobileElementWrapper(driver.findElementByAccessibilityId("BGFF"));
        savedName.isDisplayed();
        savedCompany.isDisplayed();

        MobileElementWrapper edit = new MobileElementWrapper(driver.findElementByAccessibilityId("Edit"));
        edit.click();
        TouchWrapper.slideDownXTimes(driver, 2);
        MobileElementWrapper delete = new MobileElementWrapper(driver.findElementByAccessibilityId("Delete Contact"));
        delete.click();

        MobileElementWrapper deletePopUpButton = new MobileElementWrapper(driver.findElementByAccessibilityId("Delete Contact"));
        deletePopUpButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(XPathGenerator.toXPathWithText("John Farrow")),"John Farrow"));

    }
    @Test
    public void testSearchByKeyWordFromNotes(){
        MobileElementWrapper search = new MobileElementWrapper(driver.findElementByAccessibilityId("Search"));
        search.typeText("Baseball");
        MobileElementWrapper suggestedContact = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("David Taylor")));
        suggestedContact.click();
        MobileElementWrapper contactPhoto = new MobileElementWrapper(driver.findElementByAccessibilityId("Missing photo for David Taylor"));
        MobileElementWrapper contactName = new MobileElementWrapper(driver.findElementByAccessibilityId("David Taylor"));
        MobileElementWrapper searchBackButton = new MobileElementWrapper(driver.findElementByAccessibilityId("Search"));
        contactPhoto.isDisplayed();
        contactName.isDisplayed();
        searchBackButton.click();
        MobileElementWrapper cancelButton = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("Cancel")));
        cancelButton.click();
        cancelButton.click();
        MobileElementWrapper contactsList = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("Contacts")));
        contactsList.isDisplayed();




    }
    @Test
    public void testShareContact(){
        MobileElementWrapper didiMamyContact = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("Didi Mamy")));
        didiMamyContact.click();
        MobileElementWrapper shareContact = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("Share Contact")));
        shareContact.click();
        MobileElementWrapper messages = new MobileElementWrapper(driver.findElementByAccessibilityId("Messages"));
        MobileElementWrapper more = new MobileElementWrapper(driver.findElementByAccessibilityId("More"));
        MobileElementWrapper closePopUp = new MobileElementWrapper(driver.findElementByAccessibilityId("Close"));
        messages.isDisplayed();
        more.isDisplayed();
        closePopUp.click();
        MobileElementWrapper savedContactDetails = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("Didi Mamy")));
        savedContactDetails.isDisplayed();
    }
    @Test
    public void testAddToEmergencyContacts(){
        MobileElementWrapper AnnaHaroContact = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("Anna Haro")));
        AnnaHaroContact.click();
        TouchWrapper.slideDownXTimes(driver, 1);
        MobileElementWrapper addToEmergencyContactsButton = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("Add to Emergency Contacts")));
        addToEmergencyContactsButton.click();
        MobileElementWrapper sisterRelationshipOption = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("sister")));
        sisterRelationshipOption.click();
        MobileElementWrapper medicalIdScreen = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("Medical ID")));
        medicalIdScreen.isDisplayed();

    }

    @Test
    public void testSaveAsEmergencyContact() {
        MobileElementWrapper KateBellContact = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("Kate Bell")));
        KateBellContact.click();
        TouchWrapper.slideDownXTimes(driver,1);
        MobileElementWrapper addToEmergencyContactsButton = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("Add to Emergency Contacts")));
        addToEmergencyContactsButton.click();
        MobileElementWrapper chooseMobilePopUp = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("mobile")));
        chooseMobilePopUp.click();
        MobileElementWrapper friendRelationshipOption = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("friend")));
        friendRelationshipOption.click();
        MobileElementWrapper contactsBackNavigation = new MobileElementWrapper(driver
                .findElementByAccessibilityId("CNContactView")
                .findElement(By.xpath(XPathGenerator.toXPathWithText("Contacts"))));
        contactsBackNavigation.click();
        MobileElementWrapper emergencyContactStar = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("staroflife.fill")));
        emergencyContactStar.isDisplayed();

    }

    @Test
    public void testRemoveFromEmergerncyContact() {
        MobileElementWrapper KateBellContact = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("Kate Bell")));
        KateBellContact.click();
        MobileElementWrapper contactLabeledAsEmergency = new MobileElementWrapper(driver.findElementByAccessibilityId("Emergency Contact"));
        contactLabeledAsEmergency.isDisplayed();
        TouchWrapper.slideDownXTimes(driver,1);
        MobileElementWrapper removeFromEmergencyContactsButton = new MobileElementWrapper(driver.findElementByAccessibilityId("Remove from Emergency Contacts"));
        removeFromEmergencyContactsButton.click();
        MobileElementWrapper removeConfirmationPopUp = new MobileElementWrapper(driver.findElementByAccessibilityId("Remove from Emergency Contacts"));
        removeConfirmationPopUp.click();
        MobileElementWrapper contactsBackNavigation = new MobileElementWrapper(driver
                .findElementByAccessibilityId("CNContactView")
                .findElement(By.xpath(XPathGenerator.toXPathWithText("Contacts"))));
        contactsBackNavigation.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XPathGenerator.toXPathWithText("staroflife.fill"))));

    }

    @Test
    public void testAddingLinkedInProfileToContactInfo() {
        MobileElementWrapper HankZakroffContact = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("Hank M. Zakroff")));
        HankZakroffContact.click();
        MobileElementWrapper edit = new MobileElementWrapper(driver.findElementByAccessibilityId("Edit"));
        edit.click();
        TouchWrapper.slideDownXTimes(driver,2);
        MobileElementWrapper addSocialProfileButton = new MobileElementWrapper(driver.findElementByAccessibilityId("Insert add social profile"));
        addSocialProfileButton.click();
        MobileElementWrapper twitterProfileOption = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("Twitter")));
        twitterProfileOption.click();
        MobileElementWrapper linkedInOption = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithText("LinkedIn")));
        linkedInOption.click();
        MobileElementWrapper insertLinkedInUrl = new MobileElementWrapper(driver.findElementByXPath(XPathGenerator.toXPathWithValue("Social profile")));
        insertLinkedInUrl.typeText("https://www.linkedin.com/in/hank-zakroff-981665234/");
        MobileElementWrapper done = new MobileElementWrapper(driver.findElementByAccessibilityId("Done"));

    }
}
