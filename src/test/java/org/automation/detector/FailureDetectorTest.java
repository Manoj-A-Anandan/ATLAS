package org.automation.detector;

import org.automation.model.FailureType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FailureDetectorTest {

    private final FailureDetector detector = new FailureDetector();

    @Test
    public void shouldDetectTimeout() {

        String error = """
                org.openqa.selenium.TimeoutException:
                Expected condition failed: waiting for visibility of element
                """;

        FailureType actual = detector.detect(error);

        Assert.assertEquals(actual, FailureType.TIMEOUT);
    }
    @Test
    public void shouldDetectElementNotFound() {

        String error = """
            org.openqa.selenium.NoSuchElementException:
            Unable to locate element
            """;

        FailureType actual = detector.detect(error);

        Assert.assertEquals(actual, FailureType.ELEMENT_NOT_FOUND);
    }

    @Test
    public void shouldDetectAssertionFailure() {

        String error = """
            java.lang.AssertionError:
            expected [true] but found [false]
            """;

        FailureType actual = detector.detect(error);

        Assert.assertEquals(actual, FailureType.ASSERTION_FAILURE);
    }

    @Test
    public void shouldDetectNetworkError() {

        String error = """
            java.net.ConnectException:
            Connection refused
            """;

        FailureType actual = detector.detect(error);

        Assert.assertEquals(actual, FailureType.NETWORK_ERROR);
    }

    @Test
    public void shouldReturnNoneForBlankError() {

        String error = "   ";

        FailureType actual = detector.detect(error);

        Assert.assertEquals(actual, FailureType.NONE);
    }

    @Test
    public void shouldReturnUnknownForUnrecognizedError() {

        String error = "Something completely unexpected happened";

        FailureType actual = detector.detect(error);

        Assert.assertEquals(actual, FailureType.UNKNOWN);
    }
}