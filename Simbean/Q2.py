#시험 조작점수 찾는문제
#arr은 1번참가자부터 마지막 참가자까지 점수가 내림차순으로 정렬되어있음
#조작된 점수인지 아닌지 판단하는 방법은 앞사람과의 점수차가 같은것이 n번 있는 것을 조작된 점수로 판단
#조작된 점수가 아닌 점수가 몇개인지 return 하시오

def insert(message,node):
    if message in node:
        node[message] += 1
    else:
        node[message] = 1

def sol(N, Mlist):
    global have
    useList = []
    node = {}
    have = {} #점수 차가 나는 거
    output = len(Mlist)
    prev = 0
    for i in range(0, len(Mlist) - 1):
        index = Mlist[i] - Mlist[i + 1] #연산 차
        if prev != index: #앞점수차랑 뒷점수차가 다를때
            insert((prev,index),node)
            insert(index,have)
        else: #같을때
            insert(index,have)
        prev = index
   # print(have) #연산량 기록 딕셔너리
    #print(node) #중첩이 되는 부분 기록한 딕셔너리
    #------------------검거문--------------
    for i in have.items():
        if i[1] >= N:
            output -= i[1]
            useList.append(i[0])
    for j in node.items():
        for i in useList:
            if i == j[0][1]:
                output -= j[1]
    return output
if __name__ == '__main__':
# See PyCharm help at https://www.jetbrains.com/help/pycharm/
    N = int(input())
    M = input()
    Mlist = list(map(int, M.split()))
    output = sol(N,Mlist)
    print(output)

