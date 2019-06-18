package Lettcode.let;

public class num66 {
    public int[] plusOne(int[] digits) {
        int add = 1;
        for (int i = digits.length - 1; i >= 0 ; i--) {
            int x = digits[i] + add;
            if (x < 10){
                add = 0;
                digits[i] = x;
                break;
            }
            else{
                add = x / 10;
                digits[i] = x % 10;
            }
        }
        if (add == 0)
            return digits;
        int[] ans = new int[digits.length + 1];
        ans[0] = add;
        for (int i = 0; i < digits.length; i++) {
            ans[i+1] = digits[i];
        }
        return ans;

    }
}
