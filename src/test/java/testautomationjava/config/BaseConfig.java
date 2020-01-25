package testautomationjava.config;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import org.testng.asserts.SoftAssert;

import cptaf.testsetup.TestInitializeHookup;
import cptaf.helpers.DatabaseHelper;
import cptaf.helpers.ExcelHelper;
import cptaf.helpers.Utility;
import cptaf.helpers.ReportHelper;

@Listeners(ReportHelper.class)
public abstract class BaseConfig extends TestInitializeHookup {

    //region Object/Variable/Property Members

    public SoftAssert softAssert;

    public ExcelHelper objExcelHelper = new ExcelHelper();
    public Utility objUtil = new Utility();
    public DatabaseHelper objDbHelper = new DatabaseHelper();

    public browserType currentBrowserType;
    public HashMap<String, String> objHashMap;
    public HashMap<String, String> objMsgHashMap;

    public DefaultTableModel dtTempTableModel;

    public JTable jTableExcel;
    public JTable jTableGrid;
    public JTable jTableBeforeDeleteGrid;
    public JTable jTableAfterDeleteGrid;
    public JTable jTableDb;

    public Calendar calToday;
    public Date date;
    public Date dateFrom;
    public Date dateTo;
    public SimpleDateFormat formatter;
    public SimpleDateFormat gridDateFormatter;

    public List<WebElement> listOfGridColumns;
    public List<WebElement> listOfGridRows;
    public List<WebElement> listOfDDLCollection;

    public ArrayList<String> arrListOfExpectedVal;
    public ArrayList<String> arrListOfActualVal;

    public boolean isBoolFlag;

    public int intNoOfSecondsToWait;
    public int intAjaxCallDelayCount;
    public int intNoOfRetryCount;

    public int[] arrGridRecPtr;
    public String[] arrDates;

    public String strDbConnectionUrl;
    public String strUserActivationUrl;
    public String strNoOfRecordsPerPage;

    public String strFromDateLocator = "CFromDate_dateview";
    public String strToDateLocator = "CToDate_dateview";

    //public String strPathToExcelFile = System.getProperty("user.dir") + "\\datasheets\\";
    public String strPathToExcelFile;
    public String strPathToTemplateFile;

    //region Assessment Cycle Page Object/Variable

    public int intNoOfAssessmentCycle;
    public int intAssessmentCycleTblRowPtr;

    public String[] arrAssessmentCycleDates;

    public ArrayList<String> arrListOfAssessmentCycleDates;

    public JTable jTableUnlinkedAC;

    //endregion

    //region KRA Page Object/Variable

    public int intNoOfKRA;
    public int intKRATblRowPtr;

    //endregion

    //region Departmental Role Page Object/Variable

    public int intNoOfDeptRole;
    public int intDeptRoleTblRowPtr;

    public String strAddedDeptRole;
    public String strPrevLinkedAssessmentCycle;

    public ArrayList<String> arrListOfKRACategory;
    public ArrayList<String> arrListOfKRA;
    public ArrayList<String> arrListOfPositiveWeightage;
    public ArrayList<String> arrListOfNegativeWeightage;
    public ArrayList<String> arrListOfAssessmentDegree;

    //endregion

    //region User Page Object/Variable

    public int intNoOfUserToBeCreated;
    public int intUserToBeCreatedTblRowPtr;
    public int intNoOfUserToBeAssignedSysRole;
    public int intUserToBeAssignedSysRoleTblRowPtr;
    public int intNoOfUserToBeAssignedDeptRole;
    public int intUserToBeAssignedDeptRoleTblRowPtr;
    public int intMaxAllowedRAToAssign;

    public String strUserNameOnDrawer;
    public String strUserActionMsg;

    public String strBulkImportedUserName;
    public String strBulkImportedUserPwd;
    public String strBulkImportedUserConcatenatedName;

    public String[] arrAssignedDeptRoleDates;
    public ArrayList<String> arrListOfAssignedDeptRoleDates;

    public JTable jTableSysRole;
    public JTable jTableDeptRole;

    public ArrayList<String> arrListOfDeptRole;
    public ArrayList<String> arrListOfFromDate;
    public ArrayList<String> arrListOfToDate;
    public ArrayList<String> arrListOfRA;
    public ArrayList<String> arrListOfRAId;
    public ArrayList<String> arrListOfConcatenatedRA;

    //endregion

    //region Feedbacks Page Object/Variable

    public int intNoOfUserToSubmitFeedbackFor;
    public int intUserToSubmitFeedbackForTblRowPtr;
    public int intNoOfCXOUserToAssessFeedback;
    public int intCXOUserToAssessFeedbackTblRowPtr;
    public int intNoOfFeedbackToIgnore;
    public int intIgnoreFeedbackRowPtr;
    public int intMaxAllowedFeedbackToSubmit;

    public String strAppraiseeName;
    public String strAppraiserPwd;
    public String strAppraiserName;
    public String strAppraiseePwd;
    public String strCXOName;
    public String strCXOPwd;
    public String strActiveDeptRole;
    public String strIgnoredFeedbackColor;
    public String strIgnoredFeedbackStatus;
    public String strIgnoredFeedbackReason;

    public String strAdvSearchFromDate;
    public String strAdvSearchToDate;
    public String strAdvSearchAppraisee;
    public String strAdvSearchAppraiser;
    public String strAdvSearchRole;
    public String strAdvSearchKRA;
    public String strAdvSearchRating;
    public String strAdvSearchSubject;

    public String strAdvSearchFromDateFilter;
    public String strAdvSearchToDateFilter;

    public String[] arrAdvSearchDates;
    public ArrayList<String> arrListOfAdvSearchDates;

    public boolean isBoolAssessFeedbackFlag;

    public String[] arrIncidentDates;
    public ArrayList<String> arrListOfFeedbackIncidentDates;

    public JTable jTableAppraiser_Appraisee;
    public JTable jTableCXO;
    public JTable jTableDeptRole_KRACat_KRA;

    public ArrayList<String> arrListOfIncidentDates;
    public ArrayList<String> arrListOfRating;
    public ArrayList<String> arrListOfSubject;
    public ArrayList<String> arrListOfComment;
    public ArrayList<String> arrListOfKRA_KRACAT;
    public ArrayList<String> arrListOfIgnoredFeedback;
    public ArrayList<String> arrListOfReasonForIgnoredFeedback;

    //endregion

    //region Top Header Object/Variable

    public String strDefaultAssessmentCycle;

    //endregion

    //endregion

    //region Enum

    //region Assessment Cycle Enum

    //Enum for configuring the Assessment Cycles to be created Browser wise
    public enum eNoOfAssessmentCycle
    {
        Chrome (2),
        Firefox (2);

        private final int intAssessmentCycleCnt;

        eNoOfAssessmentCycle(int intCnt) {
            intAssessmentCycleCnt = intCnt;
        }

        public int getNoOfAssessmentCycle() {
            return intAssessmentCycleCnt;
        }
    }

    //Enum for configuring the Row Pointer to Excel JTable to Fetch Assessment Cycle details from (Browser wise)
    public enum eAssessmentCycleTblRowPtr
    {
        Chrome (0),
        Firefox (0);

        private final int intAssessmentCycleRowPtr;

        eAssessmentCycleTblRowPtr(int intRowPtr) {
            intAssessmentCycleRowPtr = intRowPtr;
        }

        public int getAssessmentCycleTblRowPtr() {
            return intAssessmentCycleRowPtr;
        }
    }

    //endregion

    //region KRA Enum

    //Enum for configuring the KRA to be created Browser wise
    public enum eNoOfKRA
    {
        Chrome (10),
        Firefox (10);

        private final int intKRACnt;

        eNoOfKRA(int intCnt) {
            intKRACnt = intCnt;
        }

        public int getNoOfKRA() {
            return intKRACnt;
        }
    }

    //Enum for configuring the Row Pointer to Excel JTable to Fetch KRA details from (Browser wise)
    public enum eKRATblRowPtr
    {
        Chrome (0),
        Firefox (0);

        private final int intKRARowPtr;

        eKRATblRowPtr(int intRowPtr) {
            intKRARowPtr = intRowPtr;
        }

        public int getKRATblRowPtr() {
            return intKRARowPtr;
        }
    }

    //endregion

    //region Departmental Role Enum

    //Enum for configuring the Departmental Role to be created Browser wise
    public enum eNoOfDeptRole
    {
        Chrome (3),
        Firefox (3);

        private final int intDeptRoleCnt;

        eNoOfDeptRole(int intCnt) {
            intDeptRoleCnt = intCnt;
        }

        public int getNoOfDeptRole() {
            return intDeptRoleCnt;
        }
    }

    //Enum for configuring the Row Pointer to Excel JTable to Fetch Departmental Role details from (Browser wise)
    public enum eDeptRoleTblRowPtr
    {
        Chrome (0),
        Firefox (0);

        private final int intDeptRoleRowPtr;

        eDeptRoleTblRowPtr(int intRowPtr) {
            intDeptRoleRowPtr = intRowPtr;
        }

        public int getDeptRoleTblRowPtr() {
            return intDeptRoleRowPtr;
        }
    }

    //endregion

    //region User Enum

    //Enum for configuring the User to be created Browser wise
    public enum eNoOfUserToBeCreated
    {
        Chrome (4),
        Firefox (4);

        private final int intUserToBeCreatedCnt;

        eNoOfUserToBeCreated(int intCnt) {
            intUserToBeCreatedCnt = intCnt;
        }

        public int getNoOfUserToBeCreated() {
            return intUserToBeCreatedCnt;
        }
    }

    //Enum for configuring the Row Pointer to Excel JTable to Fetch User to be created details from (Browser wise)
    public enum eUserToBeCreatedTblRowPtr
    {
        Chrome (0),
        Firefox (0);

        private final int intUserToBeCreatedRowPtr;

        eUserToBeCreatedTblRowPtr(int intRowPtr) {
            intUserToBeCreatedRowPtr = intRowPtr;
        }

        public int getUserToBeCreatedTblRowPtr() {
            return intUserToBeCreatedRowPtr;
        }
    }

    //Enum for configuring the User to be assigned the System Role Browser wise
    public enum eNoOfUserToBeAssignedSysRole
    {
        Chrome (3),
        Firefox (3);

        private final int intUserToBeAssignedSysRoleCnt;

        eNoOfUserToBeAssignedSysRole(int intCnt) {
            intUserToBeAssignedSysRoleCnt = intCnt;
        }

        public int getNoOfUserToBeAssignedSysRole() {
            return intUserToBeAssignedSysRoleCnt;
        }
    }

    //Enum for configuring the Row Pointer to Excel JTable to Fetch User to be assigned the System Role details from (Browser wise)
    public enum eUserToBeAssignedSysRoleTblRowPtr
    {
        Chrome (0),
        Firefox (0);

        private final int intUserToBeAssignedSysRoleRowPtr;

        eUserToBeAssignedSysRoleTblRowPtr(int intRowPtr) {
            intUserToBeAssignedSysRoleRowPtr = intRowPtr;
        }

        public int getUserToBeAssignedSysRoleTblRowPtr() {
            return intUserToBeAssignedSysRoleRowPtr;
        }
    }

    //Enum for configuring the User to be assigned the Departmental Role Browser wise
    public enum eNoOfUserToBeAssignedDeptRole
    {
        Chrome (3),
        Firefox (3);

        private final int intUserToBeAssignedDeptRoleCnt;

        eNoOfUserToBeAssignedDeptRole(int intCnt) {
            intUserToBeAssignedDeptRoleCnt = intCnt;
        }

        public int getNoOfUserToBeAssignedDeptRole() {
            return intUserToBeAssignedDeptRoleCnt;
        }
    }

    //Enum for configuring the Row Pointer to Excel JTable to Fetch User to be assigned the Departmental Role details from (Browser wise)
    public enum eUserToBeAssignedDeptRoleTblRowPtr
    {
        Chrome (0),
        Firefox (0);

        private final int intUserToBeAssignedDeptRoleRowPtr;

        eUserToBeAssignedDeptRoleTblRowPtr(int intRowPtr) {
            intUserToBeAssignedDeptRoleRowPtr = intRowPtr;
        }

        public int getUserToBeAssignedDeptRoleTblRowPtr() {
            return intUserToBeAssignedDeptRoleRowPtr;
        }
    }

    public enum eUserAuthenticationType
    {
        RDBMS,
        AD
    }

    //endregion

    //region Feedback Enum

    //Enum for Feedback Status
    public enum eFeedbackStatus
    {
        Active ("#213241"),
        Ignored ("#ff5a5a");

        private final String strIgnoredOrActivatedFeedbackColorCode;

        eFeedbackStatus(String strColorCode) {
            strIgnoredOrActivatedFeedbackColorCode = strColorCode;
        }

        public String getIgnoredOrActivatedFeedbackColorCode() {
            return strIgnoredOrActivatedFeedbackColorCode;
        }
    }

    //Enum for configuring the User to submit the Feedback for Browser wise
    public enum eNoOfUserToSubmitFeedbackFor
    {
        Chrome (1),
        Firefox (1);

        private final int intUserToSubmitFeedbackForCnt;

        eNoOfUserToSubmitFeedbackFor(int intCnt) {
            intUserToSubmitFeedbackForCnt = intCnt;
        }

        public int getNoOfUserToSubmitFeedbackForCnt() {
            return intUserToSubmitFeedbackForCnt;
        }
    }

    //Enum for configuring the Row Pointer to Excel JTable to Fetch User to submit the Feedback for details from (Browser wise)
    public enum eUserToSubmitFeedbackForTblRowPtr
    {
        Chrome (0),
        Firefox (0);

        private final int intUserToSubmitFeedbackForRowPtr;

        eUserToSubmitFeedbackForTblRowPtr(int intRowPtr) {
            intUserToSubmitFeedbackForRowPtr = intRowPtr;
        }

        public int getUserToSubmitFeedbackForTblRowPtr() {
            return intUserToSubmitFeedbackForRowPtr;
        }
    }

    //Enum for configuring the CXO User to assess the Feedback details Browser wise
    public enum eNoOfCXOUserToAssessFeedback
    {
        Chrome (1),
        Firefox (1);

        private final int intCXOUserToAssessFeedbackCnt;

        eNoOfCXOUserToAssessFeedback(int intCnt) {
            intCXOUserToAssessFeedbackCnt = intCnt;
        }

        public int getNoOfCXOUserToAssessFeedbackCnt() {
            return intCXOUserToAssessFeedbackCnt;
        }
    }

    //Enum for configuring the Row Pointer to Excel JTable to Fetch CXO User to assess the Feedback details from (Browser wise)
    public enum eCXOUserToAssessFeedbackTblRowPtr
    {
        Chrome (0),
        Firefox (0);

        private final int intCXOUserToAssessFeedbackRowPtr;

        eCXOUserToAssessFeedbackTblRowPtr(int intRowPtr) {
            intCXOUserToAssessFeedbackRowPtr = intRowPtr;
        }

        public int getCXOUserToAssessFeedbackTblRowPtr() {
            return intCXOUserToAssessFeedbackRowPtr;
        }
    }

    //Enum for configuring the CXO User to Ignore the Feedback Browser wise
    public enum eNoOfFeedbackToIgnore
    {
        Chrome (1),
        Firefox (1);

        private final int intIgnoreFeedbackCnt;

        eNoOfFeedbackToIgnore(int intCnt) {
            intIgnoreFeedbackCnt = intCnt;
        }

        public int getNoOfFeedbackToIgnoreCnt() {
            return intIgnoreFeedbackCnt;
        }
    }

    //Enum for configuring the Row Pointer to Fetch the Feedback to be ignored by CXO (Browser wise)
    public enum eIgnoreFeedbackRowPtr
    {
        Chrome (0),
        Firefox (0);

        private final int intIgnoreFeedbackRowPtr;

        eIgnoreFeedbackRowPtr(int intRowPtr) {
            intIgnoreFeedbackRowPtr = intRowPtr;
        }

        public int getIgnoreFeedbackRowPtr() {
            return intIgnoreFeedbackRowPtr;
        }
    }

    //endregion

    //endregion

    //region Constructor

    public BaseConfig() {

        try {

            //objHashMap = objUtil.LoadPropertyFileIntoHashMap(System.getProperty("user.dir") + "\\appresources\\AppConfig");
            objHashMap = objUtil.loadPropertyFileIntoHashMap(getDirPathToResources() + "/appresources/AppConfig");
            objMsgHashMap = objUtil.loadPropertyFileIntoHashMap(getDirPathToResources() + "/appresources/ProjMessages");

            intNoOfSecondsToWait = Integer.parseInt(objHashMap.get("explicitWaitTimeOut"));
            intAjaxCallDelayCount = Integer.parseInt(objHashMap.get("ajaxCallDelayCount"));
            intNoOfRetryCount = Integer.parseInt(objHashMap.get("noOfRetry"));

            strPathToExcelFile = getDirPathToResources() + "/datasheets/";
            strPathToTemplateFile = getDirPathToResources() + "/templates/";
            strDbConnectionUrl = objHashMap.get("dbConnectionUrl");
            strUserActivationUrl = objHashMap.get("userActivationUrl");
            strNoOfRecordsPerPage = objHashMap.get("noOfRecordsPerPage");

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    //endregion

    //region Methods

    /*
    String getDirPathToResources() -
    Gets the directory path to resources.
     */
    public String getDirPathToResources()
    {
        String strDecodedPath = null;

        try {

            String strPath = BaseConfig.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            strDecodedPath = URLDecoder.decode(strPath, "UTF-8").substring(0, strPath.lastIndexOf("/"));

            if(strDecodedPath.startsWith("/"))
            {
                strDecodedPath = strDecodedPath.substring(1);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return strDecodedPath;
    }

    @BeforeMethod
    @Parameters("currentBrowser")
    public void setDriver(@Optional("") String currentBrowser, ITestContext testContext)
    {
        try {

            if(!currentBrowser.equals("")) {
                currentBrowserType = browserType.valueOf(currentBrowser);
                driver = initializeDriver(browserType.valueOf(currentBrowser));
            }
            else {
                currentBrowserType = browserType.valueOf(objHashMap.get("currentBrowser"));
                driver = initializeDriver(browserType.valueOf(objHashMap.get("currentBrowser")));
            }

            softAssert = new SoftAssert();
            testContext.setAttribute("WebDriver", driver);

            goToURL();

            setEnumToVar();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
    void goToURL() -
    Goes to the specified URL, and maximizes the window.
     */
    private void goToURL()
    {
        objUtil.navigateToURL(driver, objHashMap.get("appUrl"));
        driver.manage().window().maximize();

        objExcelHelper.populateInCollectionFromExcel(strPathToExcelFile + objHashMap.get("loginDataFileName"), "LoginSheet");
    }

    /*
    void setEnumToVar() -
    Sets the Enum values to Variables.
     */
    private void setEnumToVar()
    {
        //region Enum to Variable Value Setup

        if (currentBrowserType == browserType.Chrome) {

            intNoOfAssessmentCycle = eNoOfAssessmentCycle.Chrome.getNoOfAssessmentCycle();
            intAssessmentCycleTblRowPtr = eAssessmentCycleTblRowPtr.Chrome.getAssessmentCycleTblRowPtr();

            intNoOfKRA = eNoOfKRA.Chrome.getNoOfKRA();
            intKRATblRowPtr = eKRATblRowPtr.Chrome.getKRATblRowPtr();

            intNoOfDeptRole = eNoOfDeptRole.Chrome.getNoOfDeptRole();
            intDeptRoleTblRowPtr = eDeptRoleTblRowPtr.Chrome.getDeptRoleTblRowPtr();

            intNoOfUserToBeCreated = eNoOfUserToBeCreated.Chrome.getNoOfUserToBeCreated();
            intUserToBeCreatedTblRowPtr = eUserToBeCreatedTblRowPtr.Chrome.getUserToBeCreatedTblRowPtr();

            intNoOfUserToBeAssignedSysRole = eNoOfUserToBeAssignedSysRole.Chrome.getNoOfUserToBeAssignedSysRole();
            intUserToBeAssignedSysRoleTblRowPtr = eUserToBeAssignedSysRoleTblRowPtr.Chrome.getUserToBeAssignedSysRoleTblRowPtr();

            intNoOfUserToBeAssignedDeptRole = eNoOfUserToBeAssignedDeptRole.Chrome.getNoOfUserToBeAssignedDeptRole();
            intUserToBeAssignedDeptRoleTblRowPtr = eUserToBeAssignedDeptRoleTblRowPtr.Chrome.getUserToBeAssignedDeptRoleTblRowPtr();

            intNoOfUserToSubmitFeedbackFor = eNoOfUserToSubmitFeedbackFor.Chrome.getNoOfUserToSubmitFeedbackForCnt();
            intUserToSubmitFeedbackForTblRowPtr = eUserToSubmitFeedbackForTblRowPtr.Chrome.getUserToSubmitFeedbackForTblRowPtr();

            intNoOfCXOUserToAssessFeedback = eNoOfCXOUserToAssessFeedback.Chrome.getNoOfCXOUserToAssessFeedbackCnt();
            intCXOUserToAssessFeedbackTblRowPtr = eCXOUserToAssessFeedbackTblRowPtr.Chrome.getCXOUserToAssessFeedbackTblRowPtr();

            intNoOfFeedbackToIgnore = eNoOfFeedbackToIgnore.Chrome.getNoOfFeedbackToIgnoreCnt();
            intIgnoreFeedbackRowPtr = eIgnoreFeedbackRowPtr.Chrome.getIgnoreFeedbackRowPtr();

        } else if (currentBrowserType == browserType.Firefox) {

            intNoOfAssessmentCycle = eNoOfAssessmentCycle.Firefox.getNoOfAssessmentCycle();
            intAssessmentCycleTblRowPtr = eAssessmentCycleTblRowPtr.Firefox.getAssessmentCycleTblRowPtr();

            intNoOfKRA = eNoOfKRA.Firefox.getNoOfKRA();
            intKRATblRowPtr = eKRATblRowPtr.Firefox.getKRATblRowPtr();

            intNoOfDeptRole = eNoOfDeptRole.Firefox.getNoOfDeptRole();
            intDeptRoleTblRowPtr = eDeptRoleTblRowPtr.Firefox.getDeptRoleTblRowPtr();

            intNoOfUserToBeCreated = eNoOfUserToBeCreated.Firefox.getNoOfUserToBeCreated();
            intUserToBeCreatedTblRowPtr = eUserToBeCreatedTblRowPtr.Firefox.getUserToBeCreatedTblRowPtr();

            intNoOfUserToBeAssignedSysRole = eNoOfUserToBeAssignedSysRole.Firefox.getNoOfUserToBeAssignedSysRole();
            intUserToBeAssignedSysRoleTblRowPtr = eUserToBeAssignedSysRoleTblRowPtr.Firefox.getUserToBeAssignedSysRoleTblRowPtr();

            intNoOfUserToBeAssignedDeptRole = eNoOfUserToBeAssignedDeptRole.Firefox.getNoOfUserToBeAssignedDeptRole();
            intUserToBeAssignedDeptRoleTblRowPtr = eUserToBeAssignedDeptRoleTblRowPtr.Firefox.getUserToBeAssignedDeptRoleTblRowPtr();

            intNoOfUserToSubmitFeedbackFor = eNoOfUserToSubmitFeedbackFor.Firefox.getNoOfUserToSubmitFeedbackForCnt();
            intUserToSubmitFeedbackForTblRowPtr = eUserToSubmitFeedbackForTblRowPtr.Firefox.getUserToSubmitFeedbackForTblRowPtr();

            intNoOfCXOUserToAssessFeedback = eNoOfCXOUserToAssessFeedback.Firefox.getNoOfCXOUserToAssessFeedbackCnt();
            intCXOUserToAssessFeedbackTblRowPtr = eCXOUserToAssessFeedbackTblRowPtr.Firefox.getCXOUserToAssessFeedbackTblRowPtr();

            intNoOfFeedbackToIgnore = eNoOfFeedbackToIgnore.Firefox.getNoOfFeedbackToIgnoreCnt();
            intIgnoreFeedbackRowPtr = eIgnoreFeedbackRowPtr.Firefox.getIgnoreFeedbackRowPtr();
        }

        //endregion
    }

    @AfterMethod
    public void quitDriver()
    {
        try {
            CleanupDriver();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //endregion
}
