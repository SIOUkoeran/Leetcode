import heapq
import sys
input = sys.stdin.readline


n,k = map(int,input().split())
jewerly = []
bags = []

for i in range(n):
    jewerly.append(list(map(int,input().split())))
for j in range(k):
    bags.append(int(input()))

jewerly.sort()
bags.sort()
tmp = []
answer= 0
i=0 

for bag in bags:
    while i<n and jewerly[i][0]<=bag:
        heapq.heappush(tmp,(-jewerly[i][1], jewerly[i][1]))
        i+=1
    if len(tmp)>0:
        answer += heapq.heappop(tmp)[1]

print(answer)