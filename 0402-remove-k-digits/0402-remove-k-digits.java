class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == 1)
            return "0";
        Stack<Integer> sc = new Stack<>();
        int m = 0;
        for (int i = 0; i < num.length(); i++) {
            int q = num.charAt(i) - '0';
            if (sc.isEmpty()) {
                sc.push(q);
            } else {
                while (m < k && !sc.isEmpty() && q < sc.peek()) {
                    sc.pop();

                    m++;
                }
                sc.push(q);
            }
        }
        
        while (!sc.isEmpty() && m < k) {
            m++;
            sc.pop();
        }
        String ans = "";
        // System.out.println(sc.size());
        while (!sc.isEmpty()) {
            ans = sc.pop() + ans;
        }
        if (ans.length() == 1)
            return ans;
        int q = 0;
        while (q < ans.length() && ans.charAt(q) == '0') {
            q++;
        }
        if (ans.substring(q) == "")
            return "0";
        return ans.substring(q);
    }
}