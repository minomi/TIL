# https://leetcode.com/problems/132-pattern/


def find132pattern(nums):
    s3 = float('-inf')
    st = []
    for num in reversed(nums):
        if num < s3:
            return True
        while st and st[-1] < num:
            s3 = st[-1]
            st.pop()
        st.append(num)
    return False









