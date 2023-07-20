package easy;

public class RomanToInteger13 {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char num = s.charAt(i);
            switch (num) {
                case 'I' -> {
                    if (res >= 5)
                        res -=1;
                    else
                        res +=1;
                } case 'V' -> {
                    if (res >= 10)
                        res -=5;
                    else
                        res +=5;
                } case 'X' -> {
                    if (res >= 50)
                        res -= 10;
                    else
                        res += 10;
                } case 'L' -> {
                    if (res >= 100)
                        res -= 50;
                    else
                        res += 50;
                } case 'C' -> {
                    if (res >= 500)
                        res -= 100;
                    else
                        res += 100;
                } case 'D' -> {
                    if (res >= 1000)
                        res -= 500;
                    else
                        res += 500;
                } case 'M' -> {
                    res += 1000;
                }
            }
        }
        return res;
    }
}
