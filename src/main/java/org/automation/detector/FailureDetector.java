package org.automation.detector;

import org.automation.model.FailureType;

public class FailureDetector {

    public FailureType detect(String errorMessage) {

        if (errorMessage == null || errorMessage.isBlank()) {
            return FailureType.NONE;
        }

        errorMessage = errorMessage.trim().toLowerCase();

        if (errorMessage.contains("timeoutexception")
                || errorMessage.contains("timed out")) {

            return FailureType.TIMEOUT;

        } else if (errorMessage.contains("nosuchelementexception")
                || errorMessage.contains("unable to locate element")
                || errorMessage.contains("element not found")) {

            return FailureType.ELEMENT_NOT_FOUND;

        } else if (errorMessage.contains("assertionerror")
                || errorMessage.contains("asserttrue")
                || errorMessage.contains("assertequals")) {

            return FailureType.ASSERTION_FAILURE;

        } else if (errorMessage.contains("connectexception")
                || errorMessage.contains("connection refused")
                || errorMessage.contains("502 bad gateway")) {

            return FailureType.NETWORK_ERROR;
        }

        return FailureType.UNKNOWN;
    }
}