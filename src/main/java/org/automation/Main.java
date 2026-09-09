package org.automation;

import org.automation.analyzer.TestAnalyzer;
import org.automation.model.FailureType;
import org.automation.model.TestResult;
import org.automation.model.TestStatus;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<TestResult> results  = new ArrayList<>();

        results.add( new TestResult(
                "LoginTest",
                TestStatus.PASSED,
                4.2,
                FailureType.NONE,
                "Successfully logged in."
        ));

        results.add( new TestResult(
                "CheckoutTest",
                TestStatus.FAILED,
                6.0,
                FailureType.TIMEOUT,
                "Checkout button was not clickable"
        ));

        results.add( new TestResult(
                "PaymentTest",
                TestStatus.FAILED,
                5.1,
                FailureType.ASSERTION_FAILURE,
                "Payment failure."
        ));

        TestAnalyzer analyzer = new TestAnalyzer();

        String analysis = analyzer.analyze(results);

        System.out.println("================================");
        System.out.println("        ATLAS ANALYSIS");
        System.out.println("================================");

        System.out.println(analysis);
    }
}
