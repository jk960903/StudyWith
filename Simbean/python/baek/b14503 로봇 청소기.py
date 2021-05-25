import sys
#https://www.acmicpc.net/problem/14503
ix = [-1,0,1,0]
jx = [0,1,0,-1]
def search_cleaning(i,j,space,status):
    #print(1)
    """    for _ in space:
            print(_)
        print()"""
    for _ in range(4):
        if space[i+ix[status]][j+jx[status]] != 0:
            return -1
        else:
            return status
def back_move(i,j,space,status):
    #print(2)
    if space[i - ix[status]][j - jx[status]] == 1:
        return [-1,-1]
    else:
        i -= ix[status]
        j -= jx[status]
        return [i,j]
def clean(i,j,space,cnt):
    #print(3)
    if space[i][j] != 2:
        space[i][j] = 2
        cnt += 1
    return [space,cnt]
def change_status(status):
    #0 북 1 동 2 남 3 서
    if status == 0:
        return 3
    elif status == 3:
        return 2
    elif status == 2:
        return 1
    else:
        return 0
def cleaning(robot,space):
    cnt = 0
    cflag = 0 #continue flag
    while True:
        [space,cnt] = clean(robot[0][0],robot[0][1],space,cnt) #1
        for i in range(4):
            robot[1] = change_status(robot[1])#2.a
            flag = search_cleaning(robot[0][0],robot[0][1],space,robot[1])
            if flag == robot[1]:
                robot[0][0] += ix[robot[1]]
                robot[0][1] += jx[robot[1]]
                cflag = 1
                break
        if cflag == 1:
            cflag = 0
            continue
        back_move(robot[0][0],robot[0][1],space,robot[1])
        [robot[0][0] ,robot[0][1]] = back_move(robot[0][0],robot[0][1],space,robot[1])
        if robot[0][0] == -1:
            break
    return cnt
if __name__ == "__main__":
    N = list(map(int,sys.stdin.readline().split()))
    M = list(map(int,sys.stdin.readline().split()))
    robot = [[M[0],M[1]],M[2],0]
    space = []
    for i in range(N[0]):
        space.append(list(map(int,sys.stdin.readline().split())))
    cnt = cleaning(robot,space)
    print(cnt)


