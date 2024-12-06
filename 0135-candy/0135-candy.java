class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];

        Arrays.fill(candies, 1); // start with minimum 1 candy

        // left pass is to make sure children with higher rating to its neighbor always get more than neighbor
        for(int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        // right pass is to make sure we are also taking into account that the left neighbor gets higher than right if its score is higher

        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                int maxCandy = Math.max(candies[i], candies[i+1] + 1);
                candies[i] = maxCandy;
            }

        }

        int answer = 0;

        for(int candy : candies) {
            answer += candy;
        }

        return answer;
        
    }
}