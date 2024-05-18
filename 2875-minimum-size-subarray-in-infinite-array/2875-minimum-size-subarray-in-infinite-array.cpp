class Solution {
public:
    int minSizeSubarray(vector<int>& n, long long t)
{
	int s = reduce(begin(n), end(n), 0ll);
	int quot(t/s), sz(size(n));
	t = t%s;
	int out{INT_MAX};
	for(int i{}, j{}; i<size(n); )
		if(t>0)
		{
			t -= n[j%sz];
			++j;
		 }
		else
		{
		    if(!t) out=min(out,(j-i+sz)%sz);
		    t += n[i++];                
		}
	return out==INT_MAX ? -1 : quot*sz+out;
}
};