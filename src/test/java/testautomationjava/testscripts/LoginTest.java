package testautomationjava.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import testautomationjava.config.BaseConfig;
import testautomationjava.pom.common.*;

public class LoginTest extends BaseConfig {

    @Test
    public void loginWithValidCredentialsTest() {

        try {

            //region Step:1 Log in to application with valid credentials

            LoginPage objLoginPage = LoginPage.getPageInstance(this);

            objLoginPage.logInToApplication(objExcelHelper.readDataFromExcel(0, "UserName"), objExcelHelper.readDataFromExcel(0, "Password"));

            //endregion

            //region Step:2 Verify logged in user name

            UserProfilePage objUserProfilePage = UserProfilePage.getPageInstance(this);

            Assert.assertEquals(objUtil.waitForElementToBeVisible(driver, objUserProfilePage.spnLoggedInUserName, intNoOfSecondsToWait).getText(), objExcelHelper.readDataFromExcel(0, "FirstName") + " " + objExcelHelper.readDataFromExcel(0, "LastName"), "Logged In User Name does not match on User Profile Sidebar");

            //endregion

            //region Step:3 Open the User Profile sidebar, & Log out of application

            objUserProfilePage.openUserProfileSidebar();
            objUserProfilePage.logOutOfApplication();

            //endregion
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Assert.fail(String.format("Unexpected exception of type %1$s caught: %2$s", ex, ex.getMessage()));
        }
    }

    @Test
    public void loginWithInvalidCredentialsTest() {

        try {

            //region Step:1 Log in to application with invalid credentials

            LoginPage objLoginPage = LoginPage.getPageInstance(this);

            objLoginPage.logInToApplication(objExcelHelper.readDataFromExcel(1, "UserName"), objExcelHelper.readDataFromExcel(1, "Password"));

            //endregion

            //region Step:2 Verify the Error Message

            Assert.assertEquals(objUtil.waitForElementToBeVisible(driver, objLoginPage.spnErrorMsg, intNoOfSecondsToWait).getText(), objMsgHashMap.get("invalidLogInMsg"));

            //endregion
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Assert.fail(String.format("Unexpected exception of type %1$s caught: %2$s", ex, ex.getMessage()));
        }
    }

}
