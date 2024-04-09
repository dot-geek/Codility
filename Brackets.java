/**

A string S consisting of N characters is considered to be properly nested if any of the following conditions is true: 

S is empty; 

S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string; 

S has the form "VW" where V and W are properly nested strings. 

For example, the string "{[()()]}" is properly nested but "([)()]" is not. 

Write a function: 

class Solution { public int solution(String S); } 

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise. 

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above. 

Write an efficient algorithm for the following assumptions: 

N is an integer within the range [0..200,000]; 

string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'. 
 
*/

class Solution { 
    public int solution(String S) {     

        char [] theChars = S.toCharArray(); 
        int strLen = theChars.length; 
        char [] theStack = new char[strLen]; 

        if (strLen == 0) { 
            return 1; 
        } 

        char curlyOpen = '{'; 
        char curlyClose = '}'; 
        char squareOpen = '['; 
        char squareClose = ']'; 
        char roundOpen = '('; 
        char roundClose = ')'; 

        int stackSize = 0; 
        for (int i =0; i < strLen; i++) 
        { 
            // If it's any of the open brackets 
            if (theChars[i] == curlyOpen || theChars[i] == squareOpen || theChars[i] == roundOpen) { 
                // Add to the stack 
                theStack[stackSize] = theChars[i]; 
                stackSize++; 
            } 
            else { 
                // No open brackets, not nested string 
                if (stackSize == 0) { 
                    return 0; 
                } 

                // Not an open bracket                 
                stackSize--; 
                if (theChars[i] == curlyClose) { 
                    if (theStack[stackSize] != curlyOpen) { 
                        // Last element does not match 
                        return 0; 
                    } 
                } 

                else if (theChars[i] == squareClose) { 
                    if (theStack[stackSize] != squareOpen) { 
                        // Last element does not match 
                        return 0; 
                    } 
                } 
                else if (theChars[i] == roundClose) { 
                    if (theStack[stackSize] != roundOpen) { 
                        // Last element does not match 
                        return 0; 
                    } 
                } 
            } 
        } 

        if (stackSize != 0) { 
            // Was not closed, all open 
            return 0; 
        } 

        return 1; 
    } 
} 
