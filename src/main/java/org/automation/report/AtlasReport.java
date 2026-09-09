package org.automation.report;

import org.automation.analyzer.TestAnalyzer;
import org.automation.model.FailureAnalysis;
import org.automation.model.FailureType;
import org.automation.model.TestResult;
import org.automation.model.TestStatus;

import java.util.List;

public class AtlasReport {

    public void generateReport(List<TestResult> results) {

        TestAnalyzer analyzer = new TestAnalyzer();

        System.out.println("================================");
        System.out.println("           ATLAS REPORT");
        System.out.println("================================");

        System.out.println(analyzer.analyze(results));

        System.out.println();
        System.out.println("FAILED TESTS");
        System.out.println("--------------------------------");

        int sNo = 1;

        for (TestResult result : results) {

            if (result.getStatus() == TestStatus.PASSED) {
                continue;
            }

            FailureType failureType = result.getFailureType();
            double duration = result.getDuration();
            String error = result.getErrorMessage();

            FailureAnalysis analysis = analyzer.analyze(result);

            System.out.println(
                    sNo++ + ". " + result.getTestName() + "\n"
                            + "   Failure Type : " + failureType + "\n"
                            + "   Duration     : " + duration + " sec\n"
                            + "   Error        : " + error + "\n"
                            + "   Category       : " + analysis.getCategory() + "\n"
                            + "   Confidence     : " + analysis.getConfidence() + "\n"
                            + "   ATLAS Analysis : " + analysis.getAnalysis() + "\n"
                            + "   Recommendation : " + analysis.getRecommendation() + "\n"
            );
        }
    }
}