class Solution {
public:
    int minExtraChar(string s, vector<string>& str) {
        unordered_set<string> set;
        for (auto m : str)
            set.insert(m);

        int n = s.size();
        vector<int> ans(n);

        for (int i = n - 1; i >= 0; i--) {
            int min = INT_MAX;
            for (int j = i; j < n; j++) {
                string curr = s.substr(i, j - i + 1);
                if (set.count(curr))
                    min = std::min(min, (j + 1 < n) ? ans[j + 1] : 0);
                else
                    min = std::min(min, ((j + 1 < n) ? ans[j + 1] : 0) + (j - i + 1));
            }

            ans[i] = min;
        }
        return ans[0];
    }
};