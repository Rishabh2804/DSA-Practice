class Solution {
    public ArrayList<HashMap<Character, Boolean>> rows = new ArrayList<>();
    public ArrayList<HashMap<Character, Boolean>> cols = new ArrayList<>();
    public ArrayList<HashMap<Character, Boolean>> boxes = new ArrayList<>();

    public boolean isValidSudoku(char[][] board) {

        for(int i = 0;i < 9;i++) {
            rows.add(new HashMap<>());
            cols.add(new HashMap<>());
            boxes.add(new HashMap<>());
        }

        for(int i = 0;i < 9;i++) {
            for(int j = 0;j < 9;j++) {
                if(board[i][j] != '.') {
                    if(!rows.get(i).containsKey(board[i][j])) {
                        rows.get(i).put(board[i][j], true);
                    } else {
                        return false;
                    }
                    if(!cols.get(j).containsKey(board[i][j])) {
                        cols.get(j).put(board[i][j], true);
                    } else {
                        return false;
                    }
                    int boxRow = i / 3;
                    int boxCol = j / 3;
                    if(!boxes.get(boxRow * 3 + boxCol).containsKey(board[i][j])) {
                        boxes.get(boxRow * 3 + boxCol).put(board[i][j], true);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}