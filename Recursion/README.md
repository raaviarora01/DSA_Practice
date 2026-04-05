# 🔁 Recursion - DSA Practice

This folder contains Java implementations of fundamental and advanced **Recursion** problems, building a strong foundation for backtracking and dynamic programming.

---

## 🚀 Features

- Basic recursion problems
- Parameterized & functional recursion
- Recursion on arrays and strings
- Subsequence generation
- Combination problems
- Introduction to backtracking

---

## 📊 Complexity Analysis

| Problem Type                  | Time Complexity        | Space Complexity        |
| ---------------------------- | ---------------------- | ---------------------- |
| Factorial                    | O(n)                   | O(n) (recursion stack) |
| Fibonacci (naive)            | O(2ⁿ)                  | O(n)                   |
| Print N numbers              | O(n)                   | O(n)                   |
| Sum of N numbers             | O(n)                   | O(n)                   |
| Reverse array                | O(n)                   | O(n)                   |
| Subsequence generation       | O(2ⁿ)                  | O(n)                   |
| Combination Sum (backtrack)  | Exponential            | O(n)                   |

---

## 💾 Space Complexity Insight

- Recursion uses **implicit stack space**
- Maximum space = **depth of recursion tree**
- Deep recursion may lead to **StackOverflowError**

> 💡 Recursive space comes from function call stack  
> ⚠️ Always try to optimize recursion depth where possible

---

## 🧠 Key Concepts Covered

- Base case & recursive case
- Stack behavior in recursion
- Backtracking basics (pick / not pick)
- Divide and conquer intuition
- Converting recursion to iteration (where possible)