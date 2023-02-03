class Solution {
        public String convert(String s, int numRows) {
            if(numRows == 1)
                return s;
            
            int upPath = -1;
            int downPath = 2 * numRows - 3;

            StringBuilder zigZag = new StringBuilder();
            for (int i = 0; i < numRows; ++i) {

                int j = i;
                boolean skipTop = false;
                while (j < s.length()) {
                    zigZag.append(s.charAt(j));
                    if (skipTop) {
                        if (upPath == -1)
                            j += downPath + 1;
                        else
                            j += upPath + 1;
                    } else {
                        if (downPath == -1)
                            j += upPath + 1;
                        else
                            j += downPath + 1;
                    }
                    
                    skipTop = skipTop == false;
                }

                upPath += 2;
                downPath -= 2;
            }

            return zigZag.toString();
        }
    }
