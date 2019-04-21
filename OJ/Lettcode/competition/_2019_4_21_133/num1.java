package Lettcode.competition._2019_4_21_133;


        import static java.lang.Math.abs;

public class num1 {
    public static void main(String[] args) {
        int[][] costs = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        System.out.println(solution(costs));
    }

    private static int solution(int[][] costs) {
        int ans = 0;
        int len = costs.length;
        int[] d = new int[len];
        for (int i = 0; i < len; i++) {
            d[i] = costs[i][0] - costs[i][1];
            if (d[i] < 0)
                d[i] *= -1;
        }
        for (int i = 0; i < len-1; i++) {
            for (int j = i + 1 ; j < len; j++) {
                if (d[i] < d[j]){
                    int t = d[i];
                    d[i] = d[j];
                    d[j] = t;
                    t = costs[i][0];
                    costs[i][0] = costs[j][0];
                    costs[j][0] = t;
                    t = costs[i][1];
                    costs[i][1] = costs[j][1];
                    costs[j][1] = t;
                }
            }
        }
        int x = 0, y = 0;
        int n = len / 2;
        for (int i = 0; i < len; i++) {
            if ((costs[i][0] < costs[i][1]) && (x < n)){
                ans += costs[i][0];
                x++;
                continue;
            }
            else if (y < n){
                ans += costs[i][1];
                y++;
                continue;
            }
            ans += costs[i][0];
            x++;
        }

        return ans;
    }



}
