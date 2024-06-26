/**

An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A. 

For example, consider array A such that 

A[0] = 3 A[1] = 4 A[2] = 3 A[3] = 2 A[4] = 3 A[5] = -1 A[6] = 3 A[7] = 3 

The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8. 

Write a function 

class Solution { public int solution(int[] A); } 

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator. 

For example, given array A such that 

A[0] = 3 A[1] = 4 A[2] = 3 A[3] = 2 A[4] = 3 A[5] = -1 A[6] = 3 A[7] = 3 

the function may return 0, 2, 4, 6 or 7, as explained above. 

Write an efficient algorithm for the following assumptions: 

N is an integer within the range [0..100,000]; 

each element of array A is an integer within the range [−2,147,483,648..2,147,483,647]. 

*/

class Solution { 
    public int solution(int[] A) { 

        int lenA = A.length; 

        if (lenA == 0) { 
            return -1; 
        } 

        // Cloning array A because we want to retain the index to
        // look up to return later on
        int[] B = A.clone(); 

        // Sort the array to get groups
        Arrays.parallelSort(B); 

        // The idea is that the dominant number will be in the middle of the
        // array because it is occurs more than half of the elements
        int middleIndex = lenA/2; 
        int domCandidate = B[middleIndex]; 
        int indexToReturn = -1; 
        int domCandidateIndex = -1; 

        int count = 0; 
        // Loop through array A to find the number of dominant elements
        // Add to count when we find one
        // The index we are returning is the last dominant element we find in the array
        for (int i = 0; i < lenA; i++) { 
            if (A[i] == domCandidate) { 
                count++; 
                domCandidateIndex = i; 
            } 
        } 

        // Checking that count is more than half of the elements,
        // as if it is not, we return -1 because there is no dominator
        // If it is more than half, we return the index of the dominant element
        if (count > middleIndex) { 
            indexToReturn = domCandidateIndex; 
        } 

        return indexToReturn; 
    } 
} 

 
