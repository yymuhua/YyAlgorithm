import java.util.ArrayList;
import java.util.List;

/**
 * @author yymuhua
 * @create 2020-04-19 11:44
 */
public class Test3 {
    public static void main(String[] args) {
        minNumberOfFrogs("croak");
    }
    public static int minNumberOfFrogs(String s) {
        List<Integer> list = new ArrayList<>();
        int[] cnts = new int[5]; // 统计crock各字符的数量
        int res = 0;
        for(char c : s.toCharArray()) {
            int key = getKey(c);
            cnts[key]++;
            if(c == 0) {
                list.add(0);
            }else {
                boolean finded = false;
                for(int i = 0; i < list.size(); i++) {
                    int num = list.get(i);
                    if(num == key - 1) {
                        finded = true;
                        if(key == 4) {
                            list.remove(i);
                        }else {
                            list.set(i, key);
                        }
                    }
                }
                res = Math.max(res, list.size());
                if(!finded) return -1;
            }
        }
        int cntOfC = cnts[0];
        for(int cnt : cnts) {
            if(cnt != cntOfC) return -1;
        }
        return res;
    }
    private static int getKey(char c) {
        switch(c) {
            case 'c' : return 0;
            case 'r' : return 1;
            case 'o' : return 2;
            case 'a' : return 3;
            case 'k' : return 4;
            default : return -1;
        }
    }
}
