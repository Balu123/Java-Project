package testautomationjava.pom.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import cptaf.testsetup.DriverContext;

import testautomationjava.config.BaseConfig;

import javax.swing.*;

public abstract class UserProfilePage extends DriverContext {

    //region Object/Variable/Property Members

    BaseConfig objBaseConfig;

    //endregion

    //region Parameterized Constructor

    public UserProfilePage(BaseConfig config)
    {
        super(config.driver);
        objBaseConfig = config;
    }

    //endregion

    //region Elements

    @FindBy(how = How.ID, using = "login_UserName")
    public WebElement spnLoggedInUserName;

    @FindBy(how = How.ID, using = "setting")
    public WebElement anchorSettings;

    @FindBy(how = How.XPATH, using = ".//a[@class='back']")
    public WebElement anchorBackArrow;

    @FindBy(how = How.XPATH, using = ".//ul/li[not(@id)]/a[@class='d-flex align-items-center justify-content-center']/span")
    private WebElement anchorLogout;

    //region Change Password Fields

    @FindBy(how = How.ID, using = "txtCurrentPassword")
    public WebElement txtCurrentPassword;

    @FindBy(how = How.ID, using = "txtNewPassword")
    public WebElement txtNewPassword;

    @FindBy(how = How.ID, using = "txtConfirmPassword")
    public WebElement txtConfirmPassword;

    @FindBy(how = How.ID, using = "btnChangePassword")
    public WebElement anchorSavePassword;

    //endregion

    //region Message

    @FindBy(how = How.ID, using = "SuccessMsgchgpawrd")
    public WebElement spnChangePasswordSuccessMsg;

    @FindBy(how = How.CSS, using = "div#SuccessChangePassword > button.close > i.icon-cancel")
    private WebElement btnChangePasswordCloseMsg;

    //endregion

    //endregion

    //region Methods

    /*
    UserProfilePage getPageInstance(BaseConfig config) -
    Gets the instance of UserProfilePage based on the given browser type, and returns it.
     */
    public static UserProfilePage getPageInstance(BaseConfig config)
    {
        switch (config.currentBrowserType)
        {
            case Chrome:
                return new testautomationjava.pom.chrome.UserProfilePage(config);
            case Firefox:
                return new testautomationjava.pom.firefox.UserProfilePage(config);
        }
        return null;
    }

    /*
    void openUserProfileSidebar() -
    Opens the User Profile side bar.
     */
    public void openUserProfileSidebar()
    {
        objBaseConfig.objUtil.waitForElementToBeClickable(objBaseConfig.driver, spnLoggedInUserName, objBaseConfig.intNoOfSecondsToWait);
        objBaseConfig.objUtil.executeJavaScript(objBaseConfig.driver, "arguments[0].click();", spnLoggedInUserName);
    }

    /*
    void logOutOfApplication() -
    Logs out of application.
     */
    public void logOutOfApplication()
    {
        objBaseConfig.objUtil.waitForElementToBeClickable(objBaseConfig.driver, anchorLogout, objBaseConfig.intNoOfSecondsToWait);
        objBaseConfig.objUtil.executeJavaScript(objBaseConfig.driver, "arguments[0].click();", anchorLogout);
    }

    private void openSettings()
    {
        //Click on Settings Icon from User Profile sidebar
        objBaseConfig.objUtil.waitForElementToBeClickable(objBaseConfig.driver, anchorSettings, objBaseConfig.intNoOfSecondsToWait);
        objBaseConfig.objUtil.executeJavaScript(objBaseConfig.driver, "arguments[0].click();", anchorSettings);
    }

    //region Change Password Methods

    public void changePassword(int intRecPtr, JTable jTable) throws InterruptedException
    {
        //Click on Settings Icon
        openSettings();

        Thread.sleep(500);

        //Wait for the Current Password text box to be visible, & Enter the Current Password
        objBaseConfig.objUtil.waitForElementToBeVisible(objBaseConfig.driver, txtCurrentPassword, objBaseConfig.intNoOfSecondsToWait).clear();
        txtCurrentPassword.sendKeys(jTable.getValueAt(intRecPtr, jTable.getColumn("CurrentPassword").getModelIndex()).toString());

        //Enter the New Password
        txtNewPassword.sendKeys(jTable.getValueAt(intRecPtr, jTable.getColumn("NewPassword").getModelIndex()).toString());

        //Enter the Confirm Password
        txtConfirmPassword.sendKeys(jTable.getValueAt(intRecPtr, jTable.getColumn("ConfirmPassword").getModelIndex()).toString());

        //Click on Save button
        anchorSavePassword.click();
    }

    public void closeChangePasswordMsg()
    {
        //Click on (x) Icon - Close Message
        btnChangePasswordCloseMsg.click();

        //Click on Back Button
        anchorBackArrow.click();
    }

    //endregion

    //endregion
}
