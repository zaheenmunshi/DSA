package tests;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.engine.discovery.DiscoverySelectors;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Drives the JUnit Platform Launcher for all test classes passed as
 * command-line arguments (fully-qualified class names).
 */
public class TestRunner {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.err.println("Usage: TestRunner <fully.qualified.ClassName> ...");
            System.exit(1);
        }

        var selectors = Arrays.stream(args)
                .map(DiscoverySelectors::selectClass)
                .collect(Collectors.toList());

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectors)
                .build();

        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        Launcher launcher = LauncherFactory.create();
        launcher.discover(request);
        launcher.execute(request, listener);

        TestExecutionSummary summary = listener.getSummary();
        summary.printFailuresTo(new PrintWriter(System.out, true));

        long total  = summary.getTestsStartedCount();
        long passed = summary.getTestsSucceededCount();
        long failed = summary.getTestsFailedCount();

        System.out.println("============================================");
        System.out.printf("Tests run: %d  |  Passed: %d  |  Failed: %d%n", total, passed, failed);

        if (failed > 0) {
            System.out.println("SOME TESTS FAILED");
            System.exit(1);
        } else {
            System.out.println("ALL TESTS PASSED");
        }
    }
}
