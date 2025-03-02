import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skills : skill_trees) {
            Map<Character, Integer> skillPos = new HashMap<>();
            
            // skill 문자열에 있는 문자들의 위치를 기록
            for (int i = 0; i < skills.length(); i++) {
                char c = skills.charAt(i);
                if (skill.contains(String.valueOf(c))) {
                    skillPos.put(c, i);
                }
            }

            boolean isValid = true;
            int prevIndex = -1;

            for (char c : skill.toCharArray()) {
                int currIndex = skillPos.getOrDefault(c, Integer.MAX_VALUE); // 없으면 큰 값으로 설정

                if (currIndex < prevIndex) { // 스킬 순서가 틀렸다면
                    isValid = false;
                    break;
                }

                prevIndex = currIndex;
            }

            if (isValid) answer++;
        }

        return answer;
    }
}