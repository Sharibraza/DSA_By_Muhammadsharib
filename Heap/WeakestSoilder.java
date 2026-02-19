import java.util.PriorityQueue;

public class WeakestSoilder {
    
    static class Row implements Comparable<Row> {
        int soliders;
        int idx;

        public Row(int soliders, int idx){
            this.soliders = soliders;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2){
            if(this.soliders == r2.soliders){
                return this.idx - r2.idx;  // If two rows have the same soliders count, the one with the smaller idx comes first.
            }else{
                return this.soliders - r2.soliders; // Otherwise, the one with the smaller soliders count comes first.
            }
        }
    }
    public static void main(String[] args) {
        
        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};

        int k = 2 ;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        
        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army.length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }


        for (int i = 0; i < k ; i++) {
            // PQ : (1,0), (1,2), (1,3), (4,1).
            System.out.println("R" + pq.remove().idx);
        }
    }
}
