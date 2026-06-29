# DSA

A personal collection of **Data Structures & Algorithms** solutions in Java,
written while practicing on [LeetCode](https://leetcode.com/). Problems are
organized by data-structure topic so the repo grows cleanly as new topics are
added.

## Repository structure

```
DSA/
├── README.md
├── .gitignore
├── run_tests.sh                               # compile + run all test suites
├── DS/
│   ├── LinkedLists/
│   │   ├── LinkedListCycle.java                # LC 141
│   │   ├── MiddleOfLinkedList.java             # LC 876
│   │   ├── RemoveNthNodeFromEnd.java           # LC 19
│   │   ├── CopyListWithRandomPointer.java      # LC 138
│   │   └── Helper/
│   │       ├── ListNode.java                   # singly linked list node (val, next)
│   │       └── Node.java                       # node with an extra random pointer
│   └── BinarySearch/
│       ├── BinarySearch.java                   # LC 704
│       ├── SearchInsertPosition.java           # LC 35
│       └── ValidPerfectSquare.java             # LC 367
└── tests/
    ├── TestSupport.java                        # assertion + list-builder helpers
    ├── BinarySearchTest.java                   # LC 704
    ├── SearchInsertPositionTest.java           # LC 35
    ├── ValidPerfectSquareTest.java             # LC 367
    ├── LinkedListCycleTest.java                # LC 141
    ├── MiddleOfLinkedListTest.java             # LC 876
    ├── RemoveNthNodeFromEndTest.java           # LC 19
    └── CopyListWithRandomPointerTest.java      # LC 138
```

The Java source root is the `DSA/` directory (solutions use the `DS.LinkedLists`
and `DS.BinarySearch` packages; tests use the `tests` package).

## Solutions index

| #   | Problem                                                                                  | Difficulty | Topic         | File                                                              | Approach                          | Time      | Space | Status         |
| --- | ---------------------------------------------------------------------------------------- | ---------- | ------------- | ---------------------------------------------------------------- | --------------------------------- | --------- | ----- | -------------- |
| 19  | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Medium     | Linked List   | [RemoveNthNodeFromEnd.java](DS/LinkedLists/RemoveNthNodeFromEnd.java)             | Two pointers + dummy node         | O(n)      | O(1)  | ✅ Done        |
| 35  | [Search Insert Position](https://leetcode.com/problems/search-insert-position/)                     | Easy       | Binary Search | [SearchInsertPosition.java](DS/BinarySearch/SearchInsertPosition.java)          | Binary search; return `left` on miss | O(log n) | O(1)  | ✅ Done        |
| 138 | [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)       | Medium     | Linked List   | [CopyListWithRandomPointer.java](DS/LinkedLists/CopyListWithRandomPointer.java) | Interweave clones, then split     | O(n)      | O(1)  | ✅ Done        |
| 141 | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)                               | Easy       | Linked List   | [LinkedListCycle.java](DS/LinkedLists/LinkedListCycle.java)                     | Floyd's cycle detection (fast/slow) | O(n)    | O(1)  | ✅ Done        |
| 367 | [Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)                         | Easy       | Binary Search | [ValidPerfectSquare.java](DS/BinarySearch/ValidPerfectSquare.java)              | Binary search on `[1, num/2]`     | O(log n)  | O(1)  | ✅ Done        |
| 704 | [Binary Search](https://leetcode.com/problems/binary-search/)                                       | Easy       | Binary Search | [BinarySearch.java](DS/BinarySearch/BinarySearch.java)                          | Classic binary search             | O(log n)  | O(1)  | ✅ Done        |
| 876 | [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)               | Easy       | Linked List   | [MiddleOfLinkedList.java](DS/LinkedLists/MiddleOfLinkedList.java)               | Fast/slow pointers                | O(n)      | O(1)  | ✅ Done        |

## Helper classes

Shared node types used by the solutions (package `DS.LinkedLists.Helper`):

- **`ListNode`** — standard singly linked list node with `val` and `next`.
- **`Node`** — singly linked list node with an additional `random` pointer, used
  by problems like *Copy List with Random Pointer*.

## Tests

Every solution has a matching suite under `tests/`, named `<Solution>Test.java`.
The suites use a tiny dependency-free harness (`TestSupport`) — no JUnit or build
tool required, just a JDK. `TestSupport` also provides the linked-list builders
(`buildList`, `buildListWithCycle`, `toArray`) shared by the list tests.

| #   | Suite                                                                       | Solution under test |
| --- | --------------------------------------------------------------------------- | ------------------- |
| 19  | [RemoveNthNodeFromEndTest.java](tests/RemoveNthNodeFromEndTest.java)         | LC 19               |
| 35  | [SearchInsertPositionTest.java](tests/SearchInsertPositionTest.java)         | LC 35               |
| 138 | [CopyListWithRandomPointerTest.java](tests/CopyListWithRandomPointerTest.java) | LC 138           |
| 141 | [LinkedListCycleTest.java](tests/LinkedListCycleTest.java)                   | LC 141              |
| 367 | [ValidPerfectSquareTest.java](tests/ValidPerfectSquareTest.java)             | LC 367              |
| 704 | [BinarySearchTest.java](tests/BinarySearchTest.java)                         | LC 704              |
| 876 | [MiddleOfLinkedListTest.java](tests/MiddleOfLinkedListTest.java)             | LC 876              |

## Compile, run & test

The simplest path is the runner script, which compiles every solution, helper,
and test into `build/` and then executes each suite:

```bash
./run_tests.sh
```

On Windows, run it from **Git Bash**. It exits non-zero if compilation or any
suite fails, so it also works in CI.

To compile the solutions by hand from the source root (`DSA/`):

```bash
javac DS/LinkedLists/*.java DS/LinkedLists/Helper/*.java DS/BinarySearch/*.java
```

> Note: the solution classes have no `main` — they mirror the method signatures
> LeetCode expects. The `tests/` suites are how you exercise them locally; each
> test class has a `main` that runs its cases and reports pass/fail.

## Roadmap

More topics will be added as separate folders under `DS/` (e.g. arrays, stacks,
trees, graphs), each following the same one-file-per-problem convention.

## Note

The documentation in this repository — this README and the JavaDoc comments in
the source files — was generated with the help of AI.
