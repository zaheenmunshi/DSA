# DSA

A personal collection of **Data Structures & Algorithms** solutions in Java,
written while practicing on [LeetCode](https://leetcode.com/). Problems are
organized by data-structure topic so the repo grows cleanly as new topics are
added.

## Repository structure

```
DSA/
├── README.md
├── run_tests.sh
├── DS/
│   ├── BinarySearch/
│   │   ├── LC35SearchInsertPosition.java
│   │   ├── LC367ValidPerfectSquare.java
│   │   └── LC704BinarySearch.java
│   ├── Graph/
│   │   ├── LC200NumberOfIslands.java
│   │   └── LC1971FindIfPathExistsInGraph.java
│   └── LinkedLists/
│       ├── LC19RemoveNthNodeFromEnd.java
│       ├── LC138CopyListWithRandomPointer.java
│       ├── LC141LinkedListCycle.java
│       ├── LC876MiddleOfLinkedList.java
│       └── Helper/
│           ├── ListNode.java
│           └── Node.java
└── tests/
    ├── TestSupport.java
    ├── BinarySearch/
    │   ├── LC35SearchInsertPositionTest.java
    │   ├── LC367ValidPerfectSquareTest.java
    │   └── LC704BinarySearchTest.java
    ├── Graph/
    │   ├── LC200NumberOfIslandsTest.java
    │   └── LC1971FindIfPathExistsInGraphTest.java
    └── LinkedList/
        ├── LC19RemoveNthNodeFromEndTest.java
        ├── LC138CopyListWithRandomPointerTest.java
        ├── LC141LinkedListCycleTest.java
        └── LC876MiddleOfLinkedListTest.java
```

## Solutions index

| #    | Problem                                                                                                         | Difficulty | Topic         | File                                                                                              | Approach                            | Time       | Space  | Status   |
|------|-----------------------------------------------------------------------------------------------------------------|------------|---------------|---------------------------------------------------------------------------------------------------|-------------------------------------|------------|--------|----------|
| 19   | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)            | Medium     | Linked List   | [LC19RemoveNthNodeFromEnd.java](DS/LinkedLists/LC19RemoveNthNodeFromEnd.java)                    | Two pointers + dummy node           | O(n)       | O(1)   | ✅ Done  |
| 35   | [Search Insert Position](https://leetcode.com/problems/search-insert-position/)                                 | Easy       | Binary Search | [LC35SearchInsertPosition.java](DS/BinarySearch/LC35SearchInsertPosition.java)                   | Binary search; return `left` on miss | O(log n)  | O(1)   | ✅ Done  |
| 138  | [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)                   | Medium     | Linked List   | [LC138CopyListWithRandomPointer.java](DS/LinkedLists/LC138CopyListWithRandomPointer.java)        | Interweave clones, then split       | O(n)       | O(1)   | ✅ Done  |
| 141  | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)                                           | Easy       | Linked List   | [LC141LinkedListCycle.java](DS/LinkedLists/LC141LinkedListCycle.java)                            | Floyd's cycle detection (fast/slow) | O(n)       | O(1)   | ✅ Done  |
| 367  | [Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)                                     | Easy       | Binary Search | [LC367ValidPerfectSquare.java](DS/BinarySearch/LC367ValidPerfectSquare.java)                     | Binary search on `[1, num/2]`       | O(log n)   | O(1)   | ✅ Done  |
| 704  | [Binary Search](https://leetcode.com/problems/binary-search/)                                                   | Easy       | Binary Search | [LC704BinarySearch.java](DS/BinarySearch/LC704BinarySearch.java)                                 | Classic binary search               | O(log n)   | O(1)   | ✅ Done  |
| 876  | [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)                           | Easy       | Linked List   | [LC876MiddleOfLinkedList.java](DS/LinkedLists/LC876MiddleOfLinkedList.java)                      | Fast/slow pointers                  | O(n)       | O(1)   | ✅ Done  |
| 200  | [Number of Islands](https://leetcode.com/problems/number-of-islands/)                                           | Medium     | Graph         | [LC200NumberOfIslands.java](DS/Graph/LC200NumberOfIslands.java)                                  | DFS sink (flood fill)               | O(m*n)     | O(m*n) | ✅ Done  |
| 1971 | [Find if Path Exists in Graph](https://leetcode.com/problems/find-if-path-exists-in-graph/)                    | Easy       | Graph         | [LC1971FindIfPathExistsInGraph.java](DS/Graph/LC1971FindIfPathExistsInGraph.java)                | BFS from source                     | O(V+E)     | O(V+E) | ✅ Done  |

## Helper classes

Shared node types used by the LinkedList solutions (package `DS.LinkedLists.Helper`):

- **`ListNode`** — standard singly linked list node with `val` and `next`.
- **`Node`** — singly linked list node with an additional `random` pointer, used by LC 138.

## Compile & run

From the repo root (`DSA/`), compile all packages with:

```bash
javac DS/LinkedLists/*.java DS/LinkedLists/Helper/*.java DS/BinarySearch/*.java DS/Graph/*.java
```

To run the full test suite:

```bash
./run_tests.sh
```

## Roadmap

More topics will be added as separate folders under `DS/` (e.g. arrays, stacks, trees), each following the same one-file-per-problem convention.
