import java.util.*;
import java.io.FileInputStream;

class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int d = sc.nextInt();

        ArrayList<Integer> horizonList = new ArrayList<>(Arrays.asList(0, m));
        ArrayList<Integer> verticalList = new ArrayList<>(Arrays.asList(0, n));
        
        for (int i = 0; i < d; i++) {
            int dir = sc.nextInt();
            int num = sc.nextInt();

            if (dir == 0) {  // 가로로 자르기
                verticalList.add(num);
            } else if (dir == 1) {  // 세로로 자르기
                horizonList.add(num);
            }
        }
        Collections.sort(horizonList);
        Collections.sort(verticalList);

        int maxRow = 0;
        int maxCol = 0;
        for (int i = 1 ; i < horizonList.size(); i++) {
            int length = horizonList.get(i) - horizonList.get(i - 1);
            maxRow = maxRow > length ? maxRow : length;
        }
        for (int i = 1 ; i < verticalList.size(); i++) {
            int length = verticalList.get(i) - verticalList.get(i - 1);
            maxCol = maxCol > length ? maxCol : length;
        }
        System.out.println(maxCol * maxRow);
    }
}