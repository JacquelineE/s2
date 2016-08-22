enum MoveDirection {
  FORW, BACK, LEFT, RIGHT
}


// Ett syntaxträd


abstract class ParseTree {
	abstract public int evaluate();

}

// Ett syntaxträd som representerar en "leaf(...)"
class CmdNode extends ParseTree {

  //TODO ska jag spara statet på color och pennan i parsen så jag kan skicka med
  //det i konstruktorn eller ska jag ha metod här så man kan uppdtera



	String color = "#0000FF";
  boolean active = false; //whether the pen is down or not
  MoveDirection direction;
  int arg; //how much Leonardo should move

	public CmdNode(MoveDirection direction, int number) {
		this.direction = direction;
    this.arg = number;
	}



	public int evaluate() {
    //TODO implement func, see lab instruction
	//	return (int)data;
    return 0;
	}
}

// Ett syntaxträd som representerar en "branch(... , ...)"
class BinaryOperation extends ParseTree {
  //TODO change to use MoveDirection
	TokenType operation;
	ParseTree left, right;
	public BinaryOperation(TokenType operation, ParseTree left, ParseTree right) {
		this.operation = operation;
		this.left = left;
		this.right = right;
	}

	public int evaluate() {
		switch (operation) {

		}
		assert false; // borde aldrig kunna hända
		return 0;
	}
}
