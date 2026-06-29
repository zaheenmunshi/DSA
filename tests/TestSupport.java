package tests;

import DS.LinkedLists.Helper.ListNode;

/**
 * Minimal, dependency-free test harness for the solution classes.
 *
 * <p>Each test suite creates one {@code TestSupport} instance, runs a series of
 * {@code checkEquals}/{@code check} assertions, and calls {@link #done()} at the
 * end. {@code done()} prints a per-suite summary and exits the JVM with a
 * non-zero status if any assertion failed, so the runner script can detect
 * failures. Also provides linked-list builders shared by the list tests.
 */
public class TestSupport {

    private final String suite;
    private int passed = 0;
    private int failed = 0;

    public TestSupport(String suite) {
        this.suite = suite;
        System.out.println("=== " + suite + " ===");
    }

    public void check(String name, boolean condition) {
        if (condition) {
            passed++;
            System.out.println("  [PASS] " + name);
        } else {
            failed++;
            System.out.println("  [FAIL] " + name);
        }
    }

    public void checkEquals(String name, int expected, int actual) {
        check(name + " (expected " + expected + ", got " + actual + ")", expected == actual);
    }

    public void checkEquals(String name, boolean expected, boolean actual) {
        check(name + " (expected " + expected + ", got " + actual + ")", expected == actual);
    }

    public void checkEquals(String name, int[] expected, int[] actual) {
        check(name + " (expected " + java.util.Arrays.toString(expected)
                + ", got " + java.util.Arrays.toString(actual) + ")",
                java.util.Arrays.equals(expected, actual));
    }

    /** Prints the suite summary and exits with code 1 if anything failed. */
    public void done() {
        System.out.println("  -> " + passed + " passed, " + failed + " failed");
        System.out.println();
        System.exit(failed == 0 ? 0 : 1);
    }

    // ---- linked-list helpers ----------------------------------------------

    /** Builds a singly linked list from the given values; empty input -> null. */
    public static ListNode buildList(int... vals) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int v : vals) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    /**
     * Builds a list whose tail links back to the node at index {@code pos}
     * (0-based), creating a cycle. Use {@code pos < 0} for no cycle.
     */
    public static ListNode buildListWithCycle(int[] vals, int pos) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode cycleTarget = null;
        int i = 0;
        for (int v : vals) {
            tail.next = new ListNode(v);
            tail = tail.next;
            if (i == pos) {
                cycleTarget = tail;
            }
            i++;
        }
        if (pos >= 0) {
            tail.next = cycleTarget;
        }
        return dummy.next;
    }

    /** Converts a (acyclic) list to an int array for easy comparison. */
    public static int[] toArray(ListNode head) {
        java.util.List<Integer> out = new java.util.ArrayList<>();
        for (ListNode c = head; c != null; c = c.next) {
            out.add(c.val);
        }
        int[] arr = new int[out.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = out.get(i);
        }
        return arr;
    }
}