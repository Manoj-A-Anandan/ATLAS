package org.automation;

import org.automation.analyzer.TestAnalyzer;
import org.automation.model.FailureType;
import org.automation.model.TestResult;
import org.automation.model.TestStatus;

public class Main {
    public static void main(String[] args) {
        TestResult result = new TestResult(
                "CheckoutTest",
                TestStatus.FAILED,
                4.2,
                FailureType.TIMEOUT,
                "Checkout button was not clickable"
        );

        TestAnalyzer analyzer = new TestAnalyzer();

        String analysis = analyzer.analyze(result);

        System.out.println("================================");
        System.out.println("        ATLAS ANALYSIS");
        System.out.println("================================");

        System.out.println("Test: " + result.getTestName());
        System.out.println("Status: " + result.getStatus());
        System.out.println("Failure: " + result.getFailureType());
        System.out.println("Analysis: " + analysis);
    }
}
