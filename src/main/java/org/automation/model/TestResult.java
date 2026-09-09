package org.automation.model;

public class TestResult {

    private String testName;
    private TestStatus status;
    private double duration;
    private FailureType failureType;
    private String errorMessage;

    public TestResult(
            String testName,
            TestStatus status,
            double duration,
            FailureType failureType,
            String errorMessage) {

        this.testName = testName;
        this.status = status;
        this.duration = duration;
        this.failureType = failureType;
        this.errorMessage = errorMessage;
    }


    public String getTestName() {
        return testName;
    }

    public TestStatus getStatus() {
        return status;
    }

    public double getDuration() {
        return duration;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public FailureType getFailureType() {
        return failureType;
    }
}
