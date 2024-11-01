public class ConvertColumNumberToTitles {
    public String convertTitles(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;

            ans.append((char) (((columnNumber) % 26) + 'A'));
            columnNumber = (columnNumber) / 26;

            } 

            return ans.reverse().toString();
        }
    }
    