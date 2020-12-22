# This is a sample Python script.
#시험 조작점수 찾는문제
#arr은 1번참가자부터 마지막 참가자까지 점수가 내림차순으로 정렬되어있음
#조작된 점수인지 아닌지 판단하는 방법은 앞사람과의 점수차가 같은것이 n번 있는 것을 조작된 점수로 판단
#조작된 점수가 아닌 점수가 몇개인지 return 하시오
def sol(N, Mlist):
    prev = 0
    have = {} #점수 차가 나는 거
    output = len(Mlist)
    for i in range(0,len(Mlist)- 1):
        index = Mlist[i] - Mlist[i + 1]
        if prev == index:
            flag = 1
        else:
            flag = 0
        try:
            if flag == 0:
                have[prev] += 1
                have[index] += 1 #증가문
            else:
                have[index] += 1 #증가문
        except KeyError:
            have[index] = 1 #초기화문 처음 친구와 그다음 친구
        prev = index
    for i in have.values():
        if i > N:
            output -= i
    #print(have)
    return output
if __name__ == '__main__':
# See PyCharm help at https://www.jetbrains.com/help/pycharm/
    N = int(input())
    M = input()
    Mlist = list(map(int, M.split()))
    output = sol(N,Mlist)
    print(output)