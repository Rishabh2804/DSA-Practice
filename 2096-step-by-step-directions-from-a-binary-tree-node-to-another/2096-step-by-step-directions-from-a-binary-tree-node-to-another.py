# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def findLCA(self, root, p, q):
        if not root or root.val == p or root.val == q:
            return root
        
        left = self.findLCA(root.left, p, q)
        right = self.findLCA(root.right, p, q)
        
        if left and right:
            return root
        
        return left if left else right

    def findPath(self, root, value, path):
        if not root:
            return False
        if root.val == value:
            return True
        
        path.append('L')
        if self.findPath(root.left, value, path):
            return True
        path.pop()
        
        path.append('R')
        if self.findPath(root.right, value, path):
            return True
        path.pop()
        
        return False

    def getDirections(self, root, startValue, destValue):
        """
        :type root: Optional[TreeNode]
        :type startValue: int
        :type destValue: int
        :rtype: str
        """
        lca = self.findLCA(root, startValue, destValue)
    
        pathToStart = []
        self.findPath(lca, startValue, pathToStart)
        
        pathToDest = []
        self.findPath(lca, destValue, pathToDest)
        
        directions = 'U' * len(pathToStart) + ''.join(pathToDest)
        return directions