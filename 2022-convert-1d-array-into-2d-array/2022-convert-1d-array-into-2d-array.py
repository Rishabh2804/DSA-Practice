class Solution:
    def construct2DArray(self, o: List[int], m: int, n: int) -> List[List[int]]:
        l=[]
        if(n*m!=len(o)):
            return l
        k=0
        for i in range(m):
            f=[]
            for j in range(n):
                f.append(o[k])
                k+=1
            l.append(f)
        return l