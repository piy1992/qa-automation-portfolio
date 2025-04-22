class Hindex1 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n=0;
        for (int i = citations.length-1; i >=0; i--) {
            if(citations[i]>n){
             n++;}
             else
             {break;}
        }
            return n;
    }

}