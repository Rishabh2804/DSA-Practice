class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        int l1 = Math.abs(ax2 - ax1);
        int b1 = Math.abs(ay2 - ay1);
        int area1 = l1 * b1;
                    
        int l2 = Math.abs(bx2 - bx1);
        int b2 = Math.abs(by2 - by1);
        int area2 = l2 * b2;
        
        // Overlapping
        int ol = 0;
        if(ax1 <= bx1 && bx2 <= ax2) // complete overlap (l1 > l2)
            ol = l2;
        else if(bx1 <= ax1 && ax2 <= bx2) // complete overlap (l2 > l1)
            ol = l1;
        else if(ax1 <= bx1 && bx1 <= ax2) // partial overlap
            ol = ax2 - bx1;
        else if(ax1 <= bx2 && bx2 <= ax2) // partial overlap
            ol = bx2 - ax1;
        
        int ob = 0;
        if(ay1 <= by1 && by2 <= ay2) // complete overlap (b1 > b2)
            ob = b2;
        else if(by1 <= ay1 && ay2 <= by2) // complete overlap (b2 > b1)
            ob = b1;
        else if(ay1 <= by1 && by1 <= ay2) // partial overlap
            ob = ay2 - by1;
        else if(ay1 <= by2 && by2 <= ay2) // partial overlap
            ob = by2 - ay1;    
        
        int overlap = ol * ob;
        
        return area1 + area2 - overlap;        
    }
}