import java.util.ArrayList;

public class Lexer {

  private String input;
  private ArrayList<Token> tokens;
  private Kattio io;
  private int currLine;
  private int currentToken  = 0;

  public Lexer(Kattio io) {
    this.io = io;
    tokens = new ArrayList<Token>();
    generateTokens();
  }

  // Kika på nästa token i indata, utan att gå vidare
	public Token peekToken() throws SyntaxError {
		// Slut på indataströmmen
		if (!hasMoreTokens())
			throw new SyntaxError("no more tokens");
		return tokens.get(currentToken);
	}

	// Hämta nästa token i indata och gå framåt i indata
	public Token nextToken() throws SyntaxError {
		Token res = peekToken();
		++currentToken;
		return res;
	}

	public boolean hasMoreTokens() {
		return currentToken < tokens.size();
	}


  private void generateTokens() {
    String currWord;
    while(io.hasMoreTokens()) {
      currWord = io.getWord();
      currLine = io.getInputLine();
      tokens.add(getNewToken(currWord));
    }
    tokens.add(new Token(TokenType.EOF, currLine+1));
  }



  private Token getNewToken(String currWord) {
    switch(currWord) {
      case "rep":
          return new Token(TokenType.REP, currLine);
      case ".":
          return new Token(TokenType.DOT, currLine);
      case  "down":
          return new Token(TokenType.DOWN, currLine);
      case "up":
          return new Token(TokenType.UP, currLine);
      case "color":
          return new Token(TokenType.COLOR, currLine);
      case "forw":
        return new Token(TokenType.FORW, currLine);
      case "back":
        return new Token(TokenType.BACK, currLine);
      case "left":
        return new Token(TokenType.LEFT, currLine);
      case "right":
          return new Token(TokenType.RIGHT, currLine);
      default:
        if(isUnsignedInteger(currWord)) {
            return new Token(TokenType.NUM, Integer.parseInt(currWord), currLine);
        } else if(isHexaNumber(currWord)) {
            return new Token(TokenType.HEXA, currWord, currLine);
        }
      }
      return new Token(TokenType.INVALID, currLine);
  }

  public static boolean isHexaNumber(String s) {
      if(s.charAt(0) != '#') {
          return false;
      }
      for(int i = 1; i < s.length(); i++) {
          if((!(Character.isDigit(s.charAt(i)))) ||  s.charAt(i) < 'a' || s.charAt(i) > 'f') {
              return false;
          }
      }
      return true;
  }

  public static boolean isUnsignedInteger(String s) {
      if(s.charAt(0) == '0') {
        return false;
      }
      for(int i = 0; i < s.length(); i++) {
            if(!(Character.isDigit(s.charAt(i)))) {
              return false;
            }
      }
      return true;
  }

  public void printTokenArray() {
    for(int i = 0; i < tokens.size(); i++) {
      System.out.println(tokens.get(i).getType() + " :"+tokens.get(i).getIndataLine());
    }
  }
}
