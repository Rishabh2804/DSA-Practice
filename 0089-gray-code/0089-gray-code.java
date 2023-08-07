import java.util.AbstractList;

class Solution {
    public List<Integer> grayCode(int n) {
                
        return new AbstractList<Integer>(){
            public Integer get(int index) {
                return index ^ (index >> 1);
            }
            
            public int size(){
                return 1 << n;
            }
        };
    }
}

// 111
// 011
// 001
// 000
// 010
// 110
// 100
// 101


// 000 100 110 010 011 111 101 001

// 111
// 011 111
// 001 101 111 011
// 000 100 110 010 011 111 101 001

// 111
// 111 011
// 111 011 001 101
// 111 011 001 101 100 000 010 110


// 0111 1111 1111 0111