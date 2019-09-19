'''
1. You must not modify the array (assume the array is read only).
2. You must use only constant, O(1) extra space.
3. Your runtime complexity should be less than O(n2).
4. There is only one duplicate number in the array, but it could be repeated more
than once.
'''

# https://en.wikipedia.org/wiki/Cycle_detection
# f(x) = y 는 x 노드 -> y 노드, nums[x] = y 라고 표현해 보자 
# (nums 가 함수라고 생각)
# 그리고 그래프 노드를 그려보자,
# 만약 중복인 숫자가 있다면 cycle 이 생길 것이다
# 결국 cycle 을 찾은뒤, 그 cycle 의 진입점을 찾는 문제

def find_duplicate(nums):
    tortoise = nums[0] # 거북이는 한칸씩 보내고
    hare = nums[nums[0]] # 토끼는 두칸씩 보내며

    while tortoise != hare: # cycle 을 찾자
        tortoise = nums[tortoise]
        hare = nums[nums[hare]]
    
    hare = 0 # 토끼를 시작점으로 보낸다
    
    while tortoise != hare:
    # 토끼와 거북이 각각 한칸씩 이동 시키며 cycle 의 진입점을 찾는다
        tortoise = nums[tortoise] 
        hare = nums[hare]

    return tortoise


def test_find_duplicate():
    assert find_duplicate([1,1]) == 1
    assert find_duplicate([1,3,4,2,2]) == 2
    assert find_duplicate([3,1,3,4,2]) == 3
