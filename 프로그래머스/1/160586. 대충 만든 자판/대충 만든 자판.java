import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> minPressCount = new HashMap<>();

        // 1️⃣ 각 문자(A-Z)에 대해 최소 입력 횟수 저장
        for (int i = 0; i < keymap.length; i++) {
            String keys = keymap[i]; 
            for (int j = 0; j < keys.length(); j++) {
                char ch = keys.charAt(j);
                int pressCount = j + 1; // 1-based index (1번 누르면 입력)

                // 기존 값과 비교하여 최소 횟수 저장
                minPressCount.put(ch, Math.min(minPressCount.getOrDefault(ch, Integer.MAX_VALUE), pressCount));
            }
        }

        // 2️⃣ 각 target 문자열을 입력하는 최소 횟수 계산
        int[] result = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int totalPress = 0;
            boolean isPossible = true;

            for (char ch : targets[i].toCharArray()) {
                if (minPressCount.containsKey(ch)) {
                    totalPress += minPressCount.get(ch); // 해당 문자 입력에 필요한 최소 횟수 누적
                } else {
                    isPossible = false; // 입력할 수 없는 문자 발견
                    break;
                }
            }

            result[i] = isPossible ? totalPress : -1; // 입력 불가능한 경우 -1
        }

        return result;
    }
}