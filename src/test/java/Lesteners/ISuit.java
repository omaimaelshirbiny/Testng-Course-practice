package Lesteners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ISuit implements ISuiteListener {
    public void onStart(ISuite suite) {
        System.out.println("start");
    }

    public void onFinish(ISuite suite) {
        System.out.println("end");
    }
}
