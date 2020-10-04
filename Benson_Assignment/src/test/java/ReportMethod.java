import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ReportMethod
{
    public static ExtentReports bensonreport;
    public static ExtentSparkReporter extentSparkReporter;//html
    public static ExtentTest ReportResult;

    @BeforeSuite
    public void setup() {
        String path = System.getProperty ("user.dir");
        bensonreport = new ExtentReports ();
        extentSparkReporter = new ExtentSparkReporter (path + "\\report\\report.html");
        bensonreport.attachReporter (extentSparkReporter);
    }


    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus () == ITestResult.FAILURE) {
            ReportResult.log (Status.FAIL, MarkupHelper.createLabel (result.getName () + " Test case FAILED due to below issues:", ExtentColor.AMBER.RED));
            ReportResult.fail (result.getThrowable ());
        } else if (result.getStatus () == ITestResult.SUCCESS) {
            ReportResult.log (Status.PASS, MarkupHelper.createLabel (result.getName () + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            ReportResult.log (Status.SKIP, MarkupHelper.createLabel (result.getName () + " Test Case SKIPPED", ExtentColor.ORANGE));
            ReportResult.skip (result.getThrowable ());
        }
    }

    @AfterSuite
    public void tearDown() {
        bensonreport.flush ();
    }
}






