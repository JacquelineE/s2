public class Parser {

  private Lexer lexer;

  public Parser(Lexer lexer) {
    this.lexer = lexer;
  }

  //TODO jag har för mig jag läste ngt om att man sparar var man är i sin stegning
  //genom tokens listan, för att på detta sätt kunna gå tillbaka om man
  //efter flertalet steg inser att man hamnat fel

  public ParseTree parse() throws SyntaxError {
      // Startsymbol är Expr
      ParseTree result = Expr();
      // Borde inte finnas något kvar av indata när vi parsat ett uttryck
      if (lexer.nextToken().getType() != TokenType.EOF) {
        throw new SyntaxError("Borde inte finnas något kvar av indata när vi parsat ett uttryck");
      }
      return result;
  }

  private ParseTree Expr() throws SyntaxError {
      ParseTree result = Cmd();
      return result;
  }

  private ParseTree Cmd() throws SyntaxError {
    if (lexer.peekToken().getType() == TokenType.NUM) {
      //  ParseTree result = Move();
    }
    int number = 0;
    //TODO implement
    return new CmdNode(MoveDirection.FORW, number);

  }
/*
  private ParseTree Move() {
    Token t = lexer.nextToken();
    //TODO handle all directories
    if(t.getType == TokenType.FORW) {

    }

  }
  */

}
