/** 

An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and: 

A[P] + A[Q] > A[R], 

A[Q] + A[R] > A[P], 

A[R] + A[P] > A[Q]. 

For example, consider array A such that: 

A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20 

Triplet (0, 2, 4) is triangular. 

Write a function: 

class Solution { public int solution(int[] A); } 

that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise. 

For example, given array A such that: 

A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20 

the function should return 1, as explained above. Given array A such that: 

A[0] = 10 A[1] = 50 A[2] = 5 A[3] = 1 

the function should return 0. 

Write an efficient algorithm for the following assumptions: 

N is an integer within the range [0..100,000]; 

each element of array A is an integer within the range [−2,147,483,648..2,147,483,647]. 

SCORED 93% 
Time complexity: O(N*log(N))

extreme_arith_overflow1
overflow test, 3 MAXINTs ✘WRONG ANSWER
got 0 expected 1

*/

class Solution { 
    public int solution(int[] A) { 

        int lenA = A.length; 

        // No point continuing if array is less than 3
        if (lenA < 3) { 
            return 0; 
        } 

        // Sort the array. The idea is that the conditions will more likely
        // be met if the numbers are close together
        Arrays.parallelSort(A); 

        // Loop through the array and calculate every 3 elements according to the 
        // conditions
        for (int i = 0; i < lenA-2; i++) { 
            int p = A[i]; 
            int q = A[i+1]; 
            int r = A[i+2]; 

            // p can be zero, q > p, r > q, so they can't be zero
            if (p >= 0 && q > 0 && r > 0) { 
                if (p+q > r && q+r > p && r+p > q) { 
                    return 1; 
                }  
            }   
        } 

        return 0; 
    } 
} 
