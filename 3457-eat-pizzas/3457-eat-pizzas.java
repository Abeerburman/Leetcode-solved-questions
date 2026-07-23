import java.util.Arrays;

class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);

        int days = pizzas.length / 4;
        int oddDays = (days + 1) / 2;
        int evenDays = days / 2;

        int index = pizzas.length - 1;
        long answer = 0;

        // Odd days: take the largest pizza
        for (int i = 0; i < oddDays; i++) {
            answer += pizzas[index--];
        }

        // Even days: skip Z and take Y
        for (int i = 0; i < evenDays; i++) {
            index--;                 // Skip the largest pizza Z
            answer += pizzas[index--]; // Gain the second-largest Y
        }

        return answer;
    }
}