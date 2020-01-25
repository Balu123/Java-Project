package testautomationjava.pom.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.How;

import cptaf.testsetup.DriverContext;

import testautomationjava.config.BaseConfig;

public abstract class LoginPage extends DriverContext {

    //region Object/Variable/Property Members

    BaseConfig objBaseConfig;

    //endregion

    //region Parameterized Constructor

    public LoginPage(BaseConfig config)
    {
        super(config.driver);
        objBaseConfig = config;
    }

    //endregion

    //region Elements

    @FindBy(how = How.ID, using = "Email")
    WebElement txtUserName;

    @FindBy(how = How.ID, using = "pass")
    WebElement txtPwd;

    @FindBy(how = How.ID, using = "save")
    WebElement btnLogin;

    @FindBy(how = How.ID, using = "Wronguserpass")
    public WebElement spnErrorMsg;

    //endregion

    //region Methods

    /*
    LoginPage getPageInstance(BaseConfig config) -
    Gets the instance of LoginPage based on the given browser type, and returns it.
     */
    public static LoginPage getPageInstance(BaseConfig config)
    {
        switch (config.currentBrowserType)
        {
            case Chrome:
                return new testautomationjava.pom.chrome.LoginPage(config);
            case Firefox:
                return new testautomationjava.pom.firefox.LoginPage(config);
        }
        return null;
    }

    /*
    NavigationPage logInToApplication(String userName, String password) -
    Logs in to application, & returns the instance of NavigationPage.
     */
    public NavigationPage logInToApplication(String userName, String password)
    {
        txtUserName.clear();
        txtUserName.sendKeys(userName);

        txtPwd.clear();
        txtPwd.sendKeys(password);

        btnLogin.click();

        return NavigationPage.getPageInstance(objBaseConfig);
    }

    //endregion
}
