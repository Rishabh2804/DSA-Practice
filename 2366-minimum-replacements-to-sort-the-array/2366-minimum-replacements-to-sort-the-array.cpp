class Solution
{
public:
    long long minimumReplacement(vector<int> &nums)
    {
        long long int replacements = 0;
        long int currLargest = nums[nums.size() - 1];
        for (long int i = nums.size() - 2; i >= 0; i--)
        {
            if (nums[i] <= currLargest)
            {
                currLargest = nums[i];
                continue;
            }

            if (nums[i] % currLargest == 0)
                replacements += (long long int)((nums[i] / currLargest) - 1);
            else
            {
                long int x = nums[i] % currLargest;
                long int operations = (nums[i] / currLargest) + 1;
                replacements += (long long int)((nums[i] / currLargest) - 1);
                nums[i] /= operations;
                replacements++;
                currLargest = nums[i];
            }
        }

        return replacements;
    }
};
