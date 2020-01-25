package testautomationjava.pom.common;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import cptaf.testsetup.DriverContext;

import testautomationjava.config.BaseConfig;

public abstract class NavigationPage extends DriverContext {

    //region Object/Variable/Property Members

    BaseConfig objBaseConfig;

    //endregion

    //region Parameterized Constructor

    public NavigationPage(BaseConfig config)
    {
        super(config.driver);
        objBaseConfig = config;

    }

    //endregion

    //region Elements

    @FindBy(how = How.XPATH, using = ".//div[@id='Usergrid']/div[1]/div/table/thead/tr")
    private WebElement divUserGridFirstRow;

    @FindBy(how = How.XPATH, using = ".//div[@id='KRA_grid']/div[1]/div/table/thead/tr")
    private WebElement divKRAGridFirstRow;

    @FindBy(how = How.XPATH, using = ".//div[@id='Assessmentgrid']/div[1]/div/table/thead/tr")
    private WebElement divAssessmentCycleGridFirstRow;

    @FindBy(how = How.XPATH, using = ".//div[@id='DeptGrid']/div[1]/div/table/thead/tr")
    private WebElement divDeptRolesGridFirstRow;

    @FindBy(how = How.XPATH, using = ".//div[@id='FeedbackUsergrid']/div[1]/div/table/thead/tr")
    private WebElement divFeedbacksReceivedByMeGridFirstRowHeader;

    @FindBy(how = How.XPATH, using = ".//div[@id='FeedbackGrid']/div[1]/div/table/thead/tr")
    private WebElement divFeedbacksSubmittedByMeGridFirstRowHeader;

    @FindBy(how = How.XPATH, using = ".//div[@id='AssessfeedbackGrid']/div[1]/div/table/thead/tr")
    private WebElement divAssessFeedbacksGridFirstRowHeader;

    //region Assessment Cycle Header

    @FindBy(how = How.ID, using = "assessment_contextNew")
    private WebElement divAssessmentCycleHeader;

    @FindBy(how = How.ID, using = "DispAssessmentCycle")
    private WebElement spnAssessmentCycleHeader;

    @FindBy(how = How.XPATH, using = ".//ul[@id='ulAssessmentCycle']/li")
    private List<WebElement> listOfAssessmentCycleColl;

    //endregion

    //region Admin Menu/Sub-menu

    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Admin')]")
    private WebElement anchorAdmin;

    @FindBy(how = How.LINK_TEXT, using = "Users")
    private WebElement anchorUsers;

    @FindBy(how = How.LINK_TEXT, using = "Key Responsiblity Areas")
    private WebElement anchorKRA;

    @FindBy(how = How.LINK_TEXT, using = "Assessment Cycles")
    private WebElement anchorAssessmentCycles;

    @FindBy(how = How.LINK_TEXT, using = "Departmental Roles")
    private WebElement anchorDeptRoles;

    //endregion

    //region Feedback Menu/Sub-Menu

    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Feedbacks')]")
    private WebElement anchorFeedbacks;

    @FindBy(how = How.LINK_TEXT, using = "Received By Me")
    private WebElement anchorReceivedByMe;

    @FindBy(how = How.LINK_TEXT, using = "Submitted By Me")
    private WebElement anchorSubmittedByMe;

    @FindBy(how = How.LINK_TEXT, using = "Assess Feedbacks")
    private WebElement anchorAssessFeedback;

    //endregion

    //region Pagination

    @FindBy(how = How.ID, using = "gridpopoverMenuTarget")
    private WebElement btnPaginationEllipsis;

    @FindBy(how = How.CSS, using = "ul#gridpopoverMenu1 > li:nth-of-type(3) > div> span > span.k-dropdown-wrap.k-state-default > span:nth-of-type(2)")
    private WebElement spnPageRecordsNoDDLArrow;

    @FindBy(how = How.XPATH, using = ".//ul[@id='pagerDropdown1_listbox']/li")
    private List<WebElement> listOfPageRecordsNoColl;

    //endregion

    //endregion

    //region Methods

    /*
    NavigationPage getPageInstance(BaseConfig config) -
    gets the instance of NavigationPage based on the given browser type, and returns it.
     */
    public static NavigationPage getPageInstance(BaseConfig config)
    {
        switch (config.currentBrowserType)
        {
            case Chrome:
                return new testautomationjava.pom.chrome.NavigationPage(config);
            case Firefox:
                return new testautomationjava.pom.firefox.NavigationPage(config);
        }
        return null;
    }

    //endregion
}
