
public class CalculatorTest {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		System.out.println("Starting Calculator");
		c.setOperandOne(10.5);
		c.setOperation("+");
		c.setOperandTwo(5.2);
		c.performOperation();
		System.out.println(c.getResult());
		Calculator c2 = new Calculator();
		c2.setOperandOne(10.5);
		c2.setOperation("-");
		c2.setOperandTwo(5.2);
		c2.performOperation();
		System.out.println(c2.getResult());
	}

}
