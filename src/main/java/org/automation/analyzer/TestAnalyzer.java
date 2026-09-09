package org.automation.analyzer;

import org.automation.model.FailureType;
import org.automation.model.TestResult;
import org.automation.model.TestStatus;

import java.util.List;

public class TestAnalyzer {

    public String analyze(TestResult result) {
        if(result.getStatus() == TestStatus.PASSED) return "Test passed successfully.";

        FailureType failureType = result.getFailureType();

        return switch (failureType) {
            case TIMEOUT -> "Possible synchronization issue.";
            case ELEMENT_NOT_FOUND -> "Possible locator or UI change.";
            case ASSERTION_FAILURE -> "Application behavior may not match expected result.";
            case NETWORK_ERROR -> "Possible network or environment issue.";
            default -> "Unable to determine the failure cause.";
        };
    }

    public String analyze(List<TestResult> results) {
        int totalTests = results.size();
        int passedTests = 0;
        int failedTests = 0;
        int skippedTests = 0;

        for(TestResult result: results) {
            if (result.getStatus() == TestStatus.PASSED) passedTests++;
            else if (result.getStatus() == TestStatus.FAILED) failedTests++;
            else if (result.getStatus() == TestStatus.SKIPPED) skippedTests++;
        }

        return "Total Tests: " + totalTests +
                "\nPassed: " + passedTests +
                "\nFailed: " + failedTests +
                "\nSkipped: " + skippedTests;
    }
}
