# 🌟 Leetcode 1695 - Maximum Erasure Value

[![LeetCode badge](https://img.shields.io/badge/LeetCode-1695-blue.svg?logo=leetcode&logoColor=white)](https://leetcode.com/problems/maximum-erasure-value/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow.svg)](https://leetcode.com/problems/maximum-erasure-value/)
[![Language](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.java.com/)

---

## 📌 Problem Statement

You are given an array of positive integers `nums`. Your task is to find the **maximum score** you can get by erasing a subarray that contains **only unique elements**.

The **score** of a subarray is the **sum of its elements**.

Return the **maximum possible score** obtainable by erasing exactly one such subarray.

🔗 **Link to the problem:** [Leetcode 1695 - Maximum Erasure Value](https://leetcode.com/problems/maximum-erasure-value/)

---

## 🧠 Example Walkthrough

**Input:**  
```text
nums = [4, 2, 4, 5, 6]
```
Step-by-step:

Start at index 0: [4] → sum = 4

Extend to [4, 2] → sum = 6

Extend to [4, 2, 4] → duplicate found → remove from left → [2, 4]

Continue to [2, 4, 5] → sum = 11

Extend to [2, 4, 5, 6] → sum = 17
✅ Maximum sum with unique subarray = 17

✅ Approach: Sliding Window + HashSet
To solve this problem, we use a sliding window with two pointers (l and r) and a HashSet to track unique elements in the current subarray.

Key Steps:
Use l as the left pointer and r as the right pointer.

Traverse using r. Add each element to a HashSet.

If a duplicate is encountered, shrink the window by moving l and removing elements from the set until the duplicate is gone.

Maintain the sum of the current window and keep track of the maximum sum found.

```
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int a = 0;       // Final result: max score
        int l = 0;       // Left pointer of the window
        int max = 0;     // Current sum of unique subarray
        Set<Integer> map = new HashSet<>();
        
        for (int r = 0; r < nums.length; r++) {
            // Remove from the left until nums[r] becomes unique
            while (l < r && map.contains(nums[r])) {
                max -= nums[l];
                map.remove(nums[l]);
                l++;
            }
            map.add(nums[r]);
            max += nums[r];
            a = Math.max(max, a);
        }
        return a;
    }
}
```
⚙️ Time and Space Complexity
Complexity	Value
🕒 Time	O(n)
🧠 Space	O(n)
