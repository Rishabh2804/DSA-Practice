class Solution {
public:
    int minTaps(int n, vector<int>& ranges) {
    vector <int> startEnd(n+1 , 0);
    for(int i =0; i<ranges.size(); i++)
    {
    int start = max(0, i-ranges[i]);  // working as a left ------> as an index 
    int end = min (n , i+ranges[i]);

    startEnd[start]   = max(startEnd[start] ,end);  

    }

    int curr_end = 0;
    int max_end = startEnd[0];
    int tap = 0;
    for(int i=0; i<startEnd.size(); i++)
    {

  if(i> max_end) return -1;
   if(i > curr_end)
   {
   tap +=1;
   curr_end = max_end;
   }
   
   max_end = max(max_end , startEnd[i]);
    }

  return tap;
    }
};