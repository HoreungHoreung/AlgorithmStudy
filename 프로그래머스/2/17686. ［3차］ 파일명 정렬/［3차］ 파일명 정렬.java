// 10:55 -> 
import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files, new Comparator<String>(){
    @Override
    public int compare(String s1, String s2) {
        int i1 = 0, i2 = 0;
        int n1 = s1.length(), n2 = s2.length();

        // 1) HEAD
        StringBuilder head1 = new StringBuilder();
        while (i1 < n1 && !Character.isDigit(s1.charAt(i1))) {
            head1.append(Character.toLowerCase(s1.charAt(i1)));
            i1++;
        }

        StringBuilder head2 = new StringBuilder();
        while (i2 < n2 && !Character.isDigit(s2.charAt(i2))) {
            head2.append(Character.toLowerCase(s2.charAt(i2)));
            i2++;
        }

        String h1 = head1.toString();
        String h2 = head2.toString();
        int hcmp = h1.compareTo(h2);
        if (hcmp != 0) return hcmp;

        // 2) NUMBER (최대 5자리)
        int num1 = 0, len1 = 0;
        while (i1 < n1 && len1 < 5 && Character.isDigit(s1.charAt(i1))) {
            num1 = num1 * 10 + (s1.charAt(i1) - '0');
            i1++; len1++;
        }

        int num2 = 0, len2 = 0;
        while (i2 < n2 && len2 < 5 && Character.isDigit(s2.charAt(i2))) {
            num2 = num2 * 10 + (s2.charAt(i2) - '0');
            i2++; len2++;
        }

        if (num1 != num2) return Integer.compare(num1, num2);

        // 3) HEAD/NUMBER 동일 시: 원래 순서 유지 (Arrays.sort(Object[])는 안정 정렬)
        return 0;
    }
});
        return files;
    }
}