import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> result = new ArrayList<>();
    private int count;

    public List<String> generateParenthesis(int n) {
        count = n;
        generate(0, 0, "");
        return result;
    }

    private void generate(int openCount, int closeCount, String currentString) {
        if (openCount < closeCount || openCount > count || closeCount > count)
            return;
        if (openCount == count && closeCount == count)
            result.add(currentString);
        generate(openCount + 1, closeCount, currentString + "(");
        generate(openCount, closeCount + 1, currentString + ")");
    }
}