# DSA

A personal collection of **Data Structures & Algorithms** solutions in Java,
written while practicing on [LeetCode](https://leetcode.com/). Problems are
organized by data-structure topic so the repo grows cleanly as new topics are
added.

## Repository structure

```
DSA/
├── README.md
└── DS/
    ├── LinkedLists/
    │   ├── LinkedListCycle.java            # LC 141
    │   ├── MiddleOfLinkedList.java         # LC 876
    │   ├── RemoveNthFrombehind.java        # LC 19
    │   ├── CopyListWithRandomPointer.java  # LC 138
    │   └── Helper/
    │       ├── ListNode.java               # singly linked list node (val, next)
    │       └── Node.java                   # node with an extra random pointer
    └── BinarySearch/
        ├── BinarySearch.java               # LC 704
        ├── SearchInsertPosition.java       # LC 35
        └── ValidPerfectSquare.java         # LC 367
```

The Java source root is the `DSA/` directory (classes use the `DS.LinkedLists`
and `DS.BinarySearch` packages).

## Solutions index

| #   | Problem                                                                                  | Difficulty | Topic         | File                                                              | Approach                          | Time      | Space | Status         |
| --- | ---------------------------------------------------------------------------------------- | ---------- | ------------- | ---------------------------------------------------------------- | --------------------------------- | --------- | ----- | -------------- |
| 19  | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Medium     | Linked List   | [RemoveNthFrombehind.java](DS/LinkedLists/RemoveNthFrombehind.java)             | Two pointers + dummy node         | O(n)      | O(1)  | ✅ Done        |
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

## Compile & run

From the source root (`DSA/`), compile all packages with:

```bash
javac DS/LinkedLists/*.java DS/LinkedLists/Helper/*.java DS/BinarySearch/*.java
```

> Note: these are solution classes (no `main` method) — they mirror the method
> signatures LeetCode expects. To exercise them locally, add a small driver class
> with a `main` that builds a list and calls the method, or paste the solution
> into the LeetCode editor.

## Roadmap

More topics will be added as separate folders under `DS/` (e.g. arrays, stacks,
trees, graphs), each following the same one-file-per-problem convention.

## Note

The documentation in this repository — this README and the JavaDoc comments in
the source files — was generated with the help of AI.
