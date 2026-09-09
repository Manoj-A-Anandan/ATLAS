package org.automation.model;

public class FailureAnalysis {
    private FailureCategory category;
    private Confidence confidence;
    private String analysis;
    private String recommendation;


    public FailureAnalysis(FailureCategory category, Confidence confidence, String analysis, String recommendation) {
        this.category = category;
        this.confidence = confidence;
        this.analysis = analysis;
        this.recommendation = recommendation;
    }

    public FailureCategory getCategory() {
        return category;
    }

    public Confidence getConfidence() {
        return confidence;
    }

    public String getAnalysis() {
        return analysis;
    }

    public String getRecommendation() {
        return recommendation;
    }
}
