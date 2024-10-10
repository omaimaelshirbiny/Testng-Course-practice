package Lesteners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITest implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println('a');
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("b");
    }


    public void onStart(ITestContext context) {
        System.out.println(context.getName() + " started");
    }

    public void onFinish(ITestContext context) {
        System.out.println(context.getName() + " finished");
    }
}
