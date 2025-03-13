class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        String target = "1231";
        StringBuilder sb = new StringBuilder();
        for(int i : ingredient) {
            sb.append(i);
            
            int size = sb.length();
            
            if(size >= 4) {
                String temp = sb.substring(size - 4, size);
                if(temp.equals(target)) {
                    answer++;
                    sb.delete(size - 4, size);
                }
            }
        }
        return answer;
    }
}