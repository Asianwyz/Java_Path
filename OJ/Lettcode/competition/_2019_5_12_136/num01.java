package Lettcode.competition._2019_5_12_136;

public class num01 {
    public static void main(String[] args) {
        String instructions = "GG";
        int dire = 0;
        boolean ans = solution(instructions,dire);
        System.out.println(ans);
    }

    private static boolean solution(String instructions, int dire) {
        int x = 0, y = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < instructions.length() ; i++) {
                char ch = instructions.charAt(i);
                if (ch == 'G'){
                    if (dire == 0){
                        y++;
                    }
                    else if (dire == 1){
                        x--;
                    }
                    else if (dire == 2){
                        y--;
                    }
                    else x++;
                }
                else if (ch == 'L'){
                    dire = (dire + 1) % 4;
                }
                else dire = (dire + 3) % 4;
            }
        }
        if (x == 0 && y == 0){
            return true;
        }
        return false;
    }
}
