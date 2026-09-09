package org.automation.analyzer;

import org.automation.model.*;

import java.util.List;

public class TestAnalyzer {

    public FailureAnalysis analyze(TestResult result) {

        if (result.getStatus() == TestStatus.PASSED) {
            return null;
        }

        switch (result.getFailureType()) {

            case ASSERTION_FAILURE:
                return new FailureAnalysis(
                        FailureCategory.APPLICATION,
                        Confidence.HIGH,
                        "Application behavior does not match the expected result.",
                        "Verify the application logic and investigate the unexpected output."
                );

            case TIMEOUT:
                return new FailureAnalysis(
                        FailureCategory.AUTOMATION,
                        Confidence.HIGH,
                        "Test execution timed out while waiting for the expected condition.",
                        "Review explicit waits, synchronization, and element readiness."
                );

            case ELEMENT_NOT_FOUND:
                return new FailureAnalysis(
                        FailureCategory.AUTOMATION,
                        Confidence.HIGH,
                        "The automation could not locate the expected UI element.",
                        "Verify the locator and check whether the UI structure has changed."
                );

            case NETWORK_ERROR:
                return new FailureAnalysis(
                        FailureCategory.ENVIRONMENT,
                        Confidence.HIGH,
                        "Test execution encountered a network or service connectivity problem.",
                        "Check network connectivity and the availability of dependent services."
                );

            default:
                return new FailureAnalysis(
                        FailureCategory.UNKNOWN,
                        Confidence.LOW,
                        "ATLAS could not determine the probable cause of the failure.",
                        "Investigate the error message, logs, and execution environment."
                );
        }
    }

    public String analyze(List<TestResult> results) {

        int totalTests = results.size();
        int passedTests = 0;
        int failedTests = 0;
        int skippedTests = 0;

        for (TestResult result : results) {

            if (result.getStatus() == TestStatus.PASSED) {
                passedTests++;
            } else if (result.getStatus() == TestStatus.FAILED) {
                failedTests++;
            } else if (result.getStatus() == TestStatus.SKIPPED) {
                skippedTests++;
            }
        }

        return "Total Tests: " + totalTests +
                "\nPassed: " + passedTests +
                "\nFailed: " + failedTests +
                "\nSkipped: " + skippedTests;
    }
}