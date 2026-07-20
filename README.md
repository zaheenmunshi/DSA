# DSA

A personal collection of **Data Structures & Algorithms** solutions in Java,
written while practicing on [LeetCode](https://leetcode.com/). Problems are
organized by data-structure topic so the repo grows cleanly as new topics are
added.

## Repository structure

```
DSA/
├── pom.xml
├── mvnw
├── src/
│   ├── main/java/DS/
│   │   ├── BinarySearch/
│   │   │   ├── LC35SearchInsertPosition.java
│   │   │   ├── LC367ValidPerfectSquare.java
│   │   │   └── LC704BinarySearch.java
│   │   ├── Graph/
│   │   │   ├── LC133CloneGraph.java
│   │   │   ├── LC200NumberOfIslands.java
│   │   │   ├── LC207CourseSchedule.java
│   │   │   ├── LC210CourseScheduleII.java
│   │   │   ├── LC695MaxAreaOfIsland.java
│   │   │   ├── LC1971FindIfPathExistsInGraph.java
│   │   │   └── Helper/
│   │   │       └── GraphNode.java
│   │   └── LinkedLists/
│   │       ├── LC19RemoveNthNodeFromEnd.java
│   │       ├── LC138CopyListWithRandomPointer.java
│   │       ├── LC141LinkedListCycle.java
│   │       ├── LC876MiddleOfLinkedList.java
│   │       └── Helper/
│   │           ├── ListNode.java
│   │           └── Node.java
│   └── test/java/DS/
│       ├── BinarySearch/
│       │   ├── LC35SearchInsertPositionTest.java
│       │   ├── LC367ValidPerfectSquareTest.java
│       │   └── LC704BinarySearchTest.java
│       ├── Graph/
│       │   ├── LC133CloneGraphTest.java
│       │   ├── LC200NumberOfIslandsTest.java
│       │   ├── LC207CourseScheduleTest.java
│       │   ├── LC210CourseScheduleIITest.java
│       │   ├── LC695MaxAreaOfIslandTest.java
│       │   └── LC1971FindIfPathExistsInGraphTest.java
│       └── LinkedList/
│           ├── LC19RemoveNthNodeFromEndTest.java
│           ├── LC138CopyListWithRandomPointerTest.java
│           ├── LC141LinkedListCycleTest.java
│           └── LC876MiddleOfLinkedListTest.java
```

## Solutions index

| #    | Problem                                                                                                         | Difficulty | Topic         | File                                                                                                        | Approach                            | Time       | Space  | Status  |
|------|-----------------------------------------------------------------------------------------------------------------|------------|---------------|-------------------------------------------------------------------------------------------------------------|-------------------------------------|------------|--------|---------|
| 19   | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)            | Medium     | Linked List   | [LC19RemoveNthNodeFromEnd.java](src/main/java/DS/LinkedLists/LC19RemoveNthNodeFromEnd.java)                 | Two pointers + dummy node           | O(n)       | O(1)   | ✅ Done |
| 35   | [Search Insert Position](https://leetcode.com/problems/search-insert-position/)                                 | Easy       | Binary Search | [LC35SearchInsertPosition.java](src/main/java/DS/BinarySearch/LC35SearchInsertPosition.java)                | Binary search; return `left` on miss | O(log n)  | O(1)   | ✅ Done |
| 138  | [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)                   | Medium     | Linked List   | [LC138CopyListWithRandomPointer.java](src/main/java/DS/LinkedLists/LC138CopyListWithRandomPointer.java)     | Interweave clones, then split       | O(n)       | O(1)   | ✅ Done |
| 133  | [Clone Graph](https://leetcode.com/problems/clone-graph/)                                                       | Medium     | Graph         | [LC133CloneGraph.java](src/main/java/DS/Graph/LC133CloneGraph.java)                                         | DFS with node-to-clone map          | O(V+E)     | O(V)   | ✅ Done |
| 141  | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)                                           | Easy       | Linked List   | [LC141LinkedListCycle.java](src/main/java/DS/LinkedLists/LC141LinkedListCycle.java)                         | Floyd's cycle detection (fast/slow) | O(n)       | O(1)   | ✅ Done |
| 200  | [Number of Islands](https://leetcode.com/problems/number-of-islands/)                                           | Medium     | Graph         | [LC200NumberOfIslands.java](src/main/java/DS/Graph/LC200NumberOfIslands.java)                               | DFS flood fill                      | O(m*n)     | O(m*n) | ✅ Done |
| 207  | [Course Schedule](https://leetcode.com/problems/course-schedule/)                                               | Medium     | Graph         | [LC207CourseSchedule.java](src/main/java/DS/Graph/LC207CourseSchedule.java)                                 | Kahn's topological sort (BFS)       | O(V+E)     | O(V+E) | ✅ Done |
| 210  | [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)                                         | Medium     | Graph         | [LC210CourseScheduleII.java](src/main/java/DS/Graph/LC210CourseScheduleII.java)                             | Kahn's topological sort, emit order | O(V+E)     | O(V+E) | ✅ Done |
| 695  | [Max Area of Island](https://leetcode.com/problems/max-area-of-island/)                                         | Medium     | Graph         | [LC695MaxAreaOfIsland.java](src/main/java/DS/Graph/LC695MaxAreaOfIsland.java)                               | DFS flood fill, track max area      | O(m*n)     | O(m*n) | ✅ Done |
| 367  | [Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)                                     | Easy       | Binary Search | [LC367ValidPerfectSquare.java](src/main/java/DS/BinarySearch/LC367ValidPerfectSquare.java)                  | Binary search on `[1, num/2]`       | O(log n)   | O(1)   | ✅ Done |
| 704  | [Binary Search](https://leetcode.com/problems/binary-search/)                                                   | Easy       | Binary Search | [LC704BinarySearch.java](src/main/java/DS/BinarySearch/LC704BinarySearch.java)                              | Classic binary search               | O(log n)   | O(1)   | ✅ Done |
| 876  | [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)                           | Easy       | Linked List   | [LC876MiddleOfLinkedList.java](src/main/java/DS/LinkedLists/LC876MiddleOfLinkedList.java)                   | Fast/slow pointers                  | O(n)       | O(1)   | ✅ Done |
| 1971 | [Find if Path Exists in Graph](https://leetcode.com/problems/find-if-path-exists-in-graph/)                    | Easy       | Graph         | [LC1971FindIfPathExistsInGraph.java](src/main/java/DS/Graph/LC1971FindIfPathExistsInGraph.java)             | BFS from source                     | O(V+E)     | O(V+E) | ✅ Done |

## Helper classes

Shared node types used by the solutions:

- **`ListNode`** (`DS.LinkedLists.Helper`) — standard singly linked list node with `val` and `next`.
- **`Node`** (`DS.LinkedLists.Helper`) — singly linked list node with an additional `random` pointer, used by LC 138.
- **`GraphNode`** (`DS.Graph.Helper`) — undirected graph node with `val` and a list of `neighbors`, used by LC 133.

## Running tests

This project uses **Maven** with **JUnit 5**. A Maven Wrapper (`mvnw`) is included — no Maven install needed.

Run all tests from the repo root:

```bash
./mvnw test
```

Maven downloads JUnit 5 automatically on first run. All test classes use standard JUnit 5 annotations (`@Test`, `@BeforeEach`) and assertions (`assertEquals`, `assertTrue`, `assertFalse`, `assertNull`, `assertArrayEquals`).

## Roadmap

More topics will be added as separate folders under `src/main/java/DS/` (e.g. arrays, stacks, trees), each following the same one-file-per-problem convention.
