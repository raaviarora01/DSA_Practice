# 🔗 Linked List - DSA Package

This repository contains comprehensive Java implementations of all major **Linked List** types and operations.

---

## 🚀 Features

- Singly Linked List
- Doubly Linked List
- Circular Singly Linked List
- Circular Doubly Linked List
- Common operations implemented:
  - Creation
  - Insertion (head, tail, position)
  - Deletion (head, tail, position)
  - Traversal
  - Search
  - Reversal

---

## ⏱ Time Complexity Analysis

| Operation                     | Singly LL | Doubly LL | Circular Singly LL | Circular Doubly LL |
| ----------------------------- | --------- | --------- | ------------------ | ------------------ |
| Insertion at head             | O(1)      | O(1)      | O(1)               | O(1)               |
| Insertion at tail (no tail)   | O(n)      | O(n)      | O(n)               | O(n)               |
| Insertion at tail (with tail) | O(1)      | O(1)      | O(1)               | O(1)               |
| Insertion at position         | O(n)      | O(n)      | O(n)               | O(n)               |
| Deletion at head              | O(1)      | O(1)      | O(1)               | O(1)               |
| Deletion at tail (no tail)    | O(n)      | O(1)      | O(n)               | O(1)               |
| Deletion at tail (with tail)  | O(n)      | O(1)      | O(n)               | O(1)               |
| Deletion at position          | O(n)      | O(n)      | O(n)               | O(n)               |
| Search                        | O(n)      | O(n)      | O(n)               | O(n)               |
| Traversal                     | O(n)      | O(n)      | O(n)               | O(n)               |
| Reverse                       | O(n)      | O(n)      | O(n)               | O(n)               |

---

## 💾 Space Complexity Analysis

| Linked List Type     | Space Complexity            |
| -------------------- | --------------------------- |
| Singly Linked List   | O(n)                        |
| Doubly Linked List   | O(n) + O(n) `prev` pointers |
| Circular Singly List | O(n)                        |
| Circular Doubly List | O(n) + O(n) `prev` pointers |

> 💡 Tail pointer is an optimization for improving time complexity at the end operations.  
> ⚠️ Doubly lists require extra memory for backward traversal (`prev` pointer).
