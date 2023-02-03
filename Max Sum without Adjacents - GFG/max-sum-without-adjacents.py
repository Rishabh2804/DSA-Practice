#User function Template for python3
class Solution:
	
	def findMaxSum(self,arr, n):
		if n == 1:
		    return arr[0]
		elif n == 2:
		    return max(arr[0], arr[1])
		elif n == 3:
		    return max(arr[0] + arr[2], arr[1])

        a = [arr[0], arr[1], arr[0] + arr[2]]
        for i in range(3, n):
            a.append(arr[i] + max(a[i - 2], a[i - 3]))
            
        return max(a[n - 1], a[n - 2])
#{ 
 # Driver Code Starts
#Initial Template for Python 3




if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        n = int(input())
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        ans = ob.findMaxSum(arr, n)
        print(ans)
        tc -= 1

# } Driver Code Ends