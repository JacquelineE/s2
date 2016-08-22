public class Main{

  public static void main(String args[]) throws SyntaxError {
    Kattio io = new Kattio(System.in, System.out);
    Lexer lexer = new Lexer(io);
	//	Parser parser = new Parser(lexer);
		//ParseTree result = parser.parse();

	  //io.println(result.evaluate());
    lexer.printTokenArray();
    io.close();
  }
}
