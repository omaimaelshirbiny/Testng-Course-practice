package Lesteners;

import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class IInvokedMethod implements IInvokedMethodListener {
    public void beforeInvocation(org.testng.IInvokedMethod method, ITestResult testResult) {
        System.out.println(method.getTestMethod().getMethodName());
    }

    public void afterInvocation(org.testng.IInvokedMethod method, ITestResult testResult) {
        System.out.println(testResult.getStatus());
    }


}
