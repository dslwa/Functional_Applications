package ZigZagStr;
public class ZigZag {

    public String solution(String s, int num_rows) {
        if (num_rows == 1)
            return s;

        StringBuilder[] result = new StringBuilder[num_rows];
        int row = 0, dir = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            row += dir;
            result[row].append(c);
            if (row == 0 || row == num_rows - 1) {
                if (dir == 0) {
                    dir = 1;
                } else {
                    dir = -dir;
                }
            }
        }
        return convert(result);
    }

    private String convert(StringBuilder[] result) {
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : result) {
            res.append(sb.toString());
        }
        return res.toString();
    }
}