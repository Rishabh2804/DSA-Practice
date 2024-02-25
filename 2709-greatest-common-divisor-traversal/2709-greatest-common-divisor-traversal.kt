class Solution {
    fun canTraverseAllPairs(nums: IntArray): Boolean {
        val set: HashSet<Int> = HashSet()
        for (i in nums) set.add(i)
        if (nums.size == 1) return true
        if (set.contains(1)) return false
        val q: Queue<Int> = LinkedList()
        val arr = BooleanArray(100000)
        var pf = primeFactors(nums[0])
        q.add(pf[0])
        while (!q.isEmpty()) {
            val x: Int = q.remove()
            val list: ArrayList<Int> = ArrayList()
            for (i in set) {
                if (i % x == 0) {
                    list.add(i)
                    pf = primeFactors(i)
                    for (j in pf) {
                        if (!arr[j]) {
                            q.add(j)
                            arr[j] = true
                        }
                    }
                }
            }
            for (i in list) set.remove(i)
        }
        return set.size == 0
    }

    fun primeFactors(n: Int): ArrayList<Int> {
        var n = n
        val ans: ArrayList<Int> = ArrayList()
        if (n % 2 == 0) ans.add(2)
        while (n % 2 == 0) n /= 2
        var i = 3
        while (i * i <= n) {
            if (n % i == 0) ans.add(i)
            while (n % i == 0) n /= i
            i += 2
        }
        if (n > 2) ans.add(n)
        return ans
    }
}