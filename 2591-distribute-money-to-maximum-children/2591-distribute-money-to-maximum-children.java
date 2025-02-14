class Solution {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;  // Not enough money to give at least $1 to each child
        }

        money -= children;  // Give each child at least $1
        int answer = Math.min(money / 7, children);  // Maximum $8 distributions

        money -= answer * 7;
        children -= answer;

        // Edge case: If one child is left and exactly $3 remains, avoid giving $4
        if (children == 1 && money == 3) {
            answer--;
        }

        // Edge case: If all children have received $8 but money is still left,
        // we need to reduce the number of $8 distributions to avoid leaving money undistributed
        if (children == 0 && money > 0) {
            answer--;
        }

        return answer;
    }
}