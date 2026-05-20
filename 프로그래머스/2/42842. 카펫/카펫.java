class Solution {
    public int[] solution(int brown, int yellow) {
          for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
              int y_width = yellow / i;
              if (brown == y_width * 2 + i * 2 + 4) {
                return new int[] {y_width + 2, i + 2};
              }
            }
          }
        return new int[]{};
    }
}