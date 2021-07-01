#https://programmers.co.kr/learn/courses/30/lessons/12980
def solution(n):
    ans = 0

    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    print('Hello Python')
    idx = 0
    while n >= (1 << idx):
        if n & (1 << idx) == 2 ** idx:
            ans += 1
        idx += 1
    return ans