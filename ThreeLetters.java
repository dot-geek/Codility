/**
Write a function solution that, given two integers A and B, returns a string containing exactly A letters 'a' and exactly B letters 'b' with no three consecutive letters being the same (in other words, neither "aaa" nor "bbb" may occur in the returned string).

Examples:

1. Given A = 5 and B = 3, your function may return "aabaabab". Note that "abaabbaa" would also be a correct answer. Your function may return any correct answer.

2. Given A = 3 and B = 3, your function should return "ababab", "aababb", "abaabb" or any of several other strings.

3. Given A = 1 and B = 4, your function should return "bbabb", which is the only correct answer in this case.

Assume that:

A and B are integers within the range [0..100];
at least one solution exists for the given A and B.
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
*/

class Solution {
    public String solution(int A, int B) {
        String retStr = "";

        while (A > 0 || B > 0) {
            // If there are more a's, we append aab
            if (A > B) {
                if (A > 0) {
                    retStr = retStr + "a";
                    A--;
                }
                if (A > 0) {
                    retStr = retStr + "a";
                    A--;
                }
                if (B > 0) {
                    retStr = retStr + "b";
                    B--;
                }
            }
            // If there are more b's, we append bba
            else if (B > A) {
                if (B > 0) {
                    retStr = retStr + "b";
                    B--;
                }
                if (B > 0) {
                    retStr = retStr + "b";
                    B--;
                }
                if (A > 0) {
                    retStr = retStr + "a";
                    A--;
                }
            }
            // A == B, we append ab
            else if (A == B) {
                if (A > 0) {
                    retStr = retStr + "a";
                    A--;
                }
                if (B > 0) {
                    retStr = retStr + "b";
                    B--;
                }
            }
        }

        return retStr;
    }
}
