package helpers;

import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomListener extends ExitCodeListener{
    Date currentDate = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        System.out.println("Test failed at: " + currentDate);
        Actions.takeScreenshot("D:/FailedTests/" +
                result.getMethod().getTestClass().getName() +
                "/" + format.format(currentDate) +
                "/" + result.getMethod().getMethodName() + ".png");
    }

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        System.out.println("Test started at: " + currentDate);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        System.out.println("Test passed at: " + currentDate);
    }
}
