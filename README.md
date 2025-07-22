# 🚀 1695. Maximum Erasure Value

## 📌 Problem Statement

You are given an array of positive integers `nums`. Your task is to find the **maximum score** you can get by erasing a subarray that contains **only unique elements**.

The **score** of such a subarray is defined as the **sum of its elements**.

You must return the **maximum possible score**.

---

## ✅ Approach: Sliding Window + HashSet

To solve this problem, I used the **sliding window technique** with **two pointers** (`l` and `r`) and a `HashSet` to track unique elements in the current window:

- Start with two pointers `l = 0` and `r = 0`.
- Traverse the array using `r`.
- For each `r`, if `nums[r]` is not in the set, add it and its value to the current sum (`max`).
- If `nums[r]` is already in the set, we shrink the window from the left (`l`) until the duplicate is removed.
- Keep updating the result `a` with the maximum value of the current sum.
- Finally, return `a`.

---

## 🧠 Code Explanation

```java
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int a = 0;       // Final result: max score
        int l = 0;       // Left pointer of the window
        int max = 0;     // Current sum of unique subarray
        Set<Integer> map = new HashSet<>();
        
        for (int r = 0; r < nums.length; r++) {
            // If nums[r] already in set, remove from left until it's unique
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
⚙️ Time and Space Complexity
Time Complexity: O(n)
Each element is added and removed from the set at most once.

Space Complexity: O(n)
In the worst case, the HashSet will store all unique elements.
