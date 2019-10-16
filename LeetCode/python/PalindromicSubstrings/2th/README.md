#### 문제
https://leetcode.com/problems/palindromic-substrings/

#### 해결
str = "문자열" 일때

dp[n][m] = 인덱스 n ~ m 까지 펠린드롬 인가? (True or False) 라고 하면

dp[n][m] = dp[n+1][m-1] && str[n] == str[m] 

요런 식을 하나 생각함

