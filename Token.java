//Types in the grammar
enum TokenType {
	REP, DOT, NUM, DOWN, UP, COLOR, HEXA, FORW, BACK, LEFT, RIGHT, INVALID, EOF
}

class Token {
	private TokenType type;
	private Object data;
  private int indataLine;

	public Token(TokenType type, int indataLine) {
		this.type = type;
		this.data = null;
		this.indataLine = indataLine;
	}

	public Token(TokenType type, Object data, int indataLine) {
		this.type = type;
		this.data = data;
		this.indataLine = indataLine;
	}

	public TokenType getType() { return type; }
	public Object getData() { return data; }
  public int getIndataLine() {return indataLine; }

}
