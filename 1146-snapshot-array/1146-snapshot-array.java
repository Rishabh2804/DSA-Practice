class SnapshotArray {

    TreeMap<Integer, Integer>[] snapBook;
    int snapID;

    public SnapshotArray(int length) {
        snapBook = new TreeMap[length];
        for (int i = 0; i < length; ++i) {
            snapBook[i] = new TreeMap<Integer, Integer>();
            snapBook[i].put(0, 0);
        }

        snapID = 0;
    }

    public void set(int index, int val) {
        snapBook[index].put(snapID, val);
    }

    public int snap() {
        return snapID++;
    }

//     private int[][] mapToArr(HashMap<Integer, Integer> map) {
//         int[][] mapping = new int[map.size()][2];
//         int i = 0;
//         for (var pair : map.entrySet()) {
//             mapping[i++] = new int[] { pair.getKey(), pair.getValue() };
//         }

//         return mapping;
//     }

//     public int get(int index, int snap_id) {
//         HashMap<Integer, Integer> curr = snapBook[index];

//         int[][] arr = mapToArr(curr);
//         int l = 0, r = arr.length - 1;
//         while (l < r) {
//             int mid = (l + r + 1) / 2;
//             if (arr[mid][0] == snap_id)
//                 return arr[mid][1];
//             else if (arr[mid][0] > snap_id)
//                 r = mid - 1;
//             else
//                 l = mid;
//         }        

//         return arr[r][1];
//     }
    
    public int get(int index, int snapId) {
        return snapBook[index].floorEntry(snapId).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
