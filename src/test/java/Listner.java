import org.testng.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class Listner implements ITestListener, ISuiteListener, IExecutionListener {
    private static int runningTestCaseNumber;
    private static int totalTestCases;
    private static int totalTestCasesPassed;
    private static int totalTestCasesFailed;
    private static int totalTestCasesSkipped;

    private static String getCurrentTime() {

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(date);
    }


    @Override
    public void onExecutionStart() {
        System.out.println("Execution Starting.");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Execution Finished.");
    }

    @Override
    public void onStart(ISuite suite) {
        // TODO Auto-generated method stub
        totalTestCases = suite.getAllMethods().size();
        System.out.printf("Test suite started at : %s\n", getCurrentTime());
        System.out.printf("Total test cases : %s\n", totalTestCases);
        runningTestCaseNumber = 0;
        totalTestCasesPassed = 0;
        totalTestCasesFailed = 0;
        totalTestCasesSkipped = 0;
    }

    @Override
    public void onFinish(ISuite suite) {
        // TODO Auto-generated method stub
        System.out.printf("Test suite finished at : %s\n", getCurrentTime());
        System.out
                .printf("Total number of test cases executed : %d\n",
                        (totalTestCasesPassed + totalTestCasesFailed + totalTestCasesSkipped));
        System.out
                .printf("Total test cases passed  : %s\n", totalTestCasesPassed);
        System.out
                .printf("Total test cases failed  : %s\n", totalTestCasesFailed);
        System.out.printf("Total test cases skipped  : %s\n", totalTestCasesSkipped);
    }

    @Override
    public void onTestStart(ITestResult result) {
        runningTestCaseNumber++;
        System.out.printf("Test case running number is : %d out of total number of test cases : %d\n", runningTestCaseNumber, totalTestCases);
        System.out.printf("Test case running is : %s, which started at : %s\n", result.getName(), getCurrentTime());
        System.out.println("###################################################################");
        System.out.println("Test results so far as below.");
        System.out.printf("Total test cases passed till now : %d\n", totalTestCasesPassed);
        System.out.printf("Total test cases failed till now : %d\n", totalTestCasesFailed);
        System.out.printf("Total test cases skipped till now : %d\n", totalTestCasesSkipped);
        System.out.println("###################################################################");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.printf("%s is passed. It passed at : %s\n", result.getName(), getCurrentTime());
        totalTestCasesPassed++;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.printf("%s is failed. It failed at time : %s\n", result.getName(), getCurrentTime());
        totalTestCasesFailed++;
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.printf("%s is skipped. It skipped at : %s\n", result.getName(), getCurrentTime());
        totalTestCasesSkipped++;
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }
}
