#https://programmers.co.kr/learn/courses/30/lessons/42898
#https://programmers.co.kr/learn/courses/30/lessons/42898
#https://programmers.co.kr/learn/courses/30/lessons/42898
def solution(m, n, puddles):
    anslist = []
    for i in range(0,m):
        mlist = []
        for j in range(0,n):
            if [i+1,j+1] in puddles:
                mlist.append(0)
            elif i == 0 and j == 0:
                mlist.append(1)
            elif i == 0:
                mlist.append(mlist[j-1])
            elif j == 0:
                mlist.append(anslist[i-1][j])
            else:
                mlist.append(anslist[i-1][j] + mlist[j-1])
        #print(mlist)
        anslist.append(mlist)
    answer = anslist[-1][-1]%1000000007
    return answer
if __name__ == "__main__":
    print(solution(4,3,[[2, 2]]))
