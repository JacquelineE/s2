/** Simple yet moderately fast I/O routines.
 *
 * Example usage:
 *
 * Kattio io = new Kattio(System.in, System.out);
 *
 * while (io.hasMoreTokens()) {
 *    int n = io.getInt();
 *    double d = io.getDouble();
 *    double ans = d*n;
 *
 *    io.println("Answer: " + ans);
 * }
 *
 * io.close();
 *
 *
 * Some notes:
 *
 * - When done, you should always do io.close() or io.flush() on the
 *   Kattio-instance, otherwise, you may lose output.
 *
 * - The getInt(), getDouble(), and getLong() methods will throw an
 *   exception if there is no more data in the input, so it is generally
 *   a good idea to use hasMoreTokens() to check for end-of-file.
 *
 * @author: Kattis
 */

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.lang.StringBuilder;

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    public int getInputLine() {
      return inputLine;
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;
    private int inputLine = 0;
    private String input = "";

    /**
    * to lowercase charcters, add space before dots, remove comments
    **/
    private String cleanLine(String input) {
//      if("".equals(input) ||
if(input == null) {
      return null;
  }
      StringBuilder sb = new StringBuilder();
      char currChar;
      for(int i = 0; i < input.length(); i++) {
        currChar = input.charAt(i);
        if(currChar == '%')  {
          break;
        }
        if(currChar == '.') {
          sb.append(' ');
        }
        sb.append(Character.toLowerCase(currChar));
      }
      return sb.toString();

    }

    //changed peekToken to ignore comments (%)
    private String peekToken() {

        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    input = r.readLine();
                    inputLine++;
                    //to lowercase,remove comments and add space before dot
                    line = cleanLine(input);
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
