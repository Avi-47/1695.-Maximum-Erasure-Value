# 1695.-Maximum-Erasure-Value
The question asks to return the maximum score, where score is the sum of elements of that subarray that has unique elements.
So for this, I have used 2 pointers, HashSet.
I am using 2 pointers r and l, first i traverse r from index 0 to last one and i put all those chacter in the hashset now if at any index i find that the number at that index is already in the set then I took the max length by Math.max(max,r-l+1) and then traverse throgh l upto r till i find that duplicate element and till then i remove all the elemnt from the set.
And at the end of the loop, I return max.
