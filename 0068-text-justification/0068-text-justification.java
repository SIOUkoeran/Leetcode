class Solution {
    private int maxWidth;
    private String[] words;
    public List<String> fullJustify(String[] words, int maxWidth) {
        this.maxWidth = maxWidth;
        this.words = words;
        int[] wordsLength = new int[words.length];
        List<String> result = new LinkedList<String>();
        for (int i = 0; i < words.length; i++) {
            wordsLength[i] = words[i].length();
        }
        
        int i = 0;
        int totalLine = 0;
        int lastIdx = 0;
        for (i = 0; i < wordsLength.length; i++) {
            int length = wordsLength[i];
            totalLine += length;
            if (maxWidth < (i - lastIdx + totalLine)) {
                result.add(makeString(lastIdx, --i, totalLine - length));
                totalLine = 0;
                lastIdx = i + 1;
            }
        }
        result.add(makeLastString(lastIdx, i - 1, wordsLength[i - 1]));
        return result;
    }
    
    private String makeString(int startIdx, int lastIdx, int total) {
        StringBuilder sb = new StringBuilder();
        int intervalCnt = lastIdx - startIdx == 0 ? 1 : lastIdx - startIdx;
        
        int[] whitespace = makeWhitespace(maxWidth - total, intervalCnt);
        System.out.println(Arrays.toString(whitespace));
        for (int i = startIdx; i <= lastIdx; i++) {
            sb.append(words[i]);
            if (i - startIdx < whitespace.length) {
                for (int j = 0; j < whitespace[i - startIdx]; j++) {
                sb.append(" ");
                }
            }
                
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    private String makeLastString(int startIdx, int lastIdx, int total) {
        StringBuilder sb = new StringBuilder();
        int whiteSpace = maxWidth - total;
        int intervalCnt = lastIdx - startIdx == 0 ? 1 : lastIdx - startIdx;
        int whiteSpaceDivide = whiteSpace / intervalCnt;
        
        for (int i = startIdx; i <= lastIdx; i++) {
            sb.append(words[i]);
            if (i != lastIdx) {
                sb.append(" ");    
            }else {
                for (int j = 0; j < maxWidth - sb.length(); i++) {
                    sb.append(" ");
                }
            }
            
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    private int[] makeWhitespace(int total, int cnt) {
        int divide = total / cnt;
        int sum = divide * cnt;
        int[] result = new int[cnt];
        Arrays.fill(result, divide);
        for (int i = 0; i < cnt; i++) {
            if (sum >= total)
                break;
            ++result[i];
            sum += 1;
        }
        return result;
    }
}