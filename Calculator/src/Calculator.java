
 	class Calculator {
	private double operandOne;
	private String operation;
	private double operandTwo;
	private double result;
	
	public Calculator() {
		
	}
		
	public void performOperation() {
		if(this.getOperation() == "+") {
			result = getOperandOne() + getOperandTwo();
			this.setResult(result);
			} else if(this.getOperation() == "-") {
				result = getOperandOne() - getOperandTwo();
				this.setResult(result);
				}
		}
	
	
	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public double getOperandOne() {
		return operandOne;
	}
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
}
