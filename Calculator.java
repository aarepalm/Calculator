import java.util.Scanner;

class Calculator {

	enum Selection {
		UNDEFINED,
		ADD,
		MULTIPLY,
		SUBTRACT,
		DIVIDE
	}

	float add(float a, float b) {
		return a+b;
	}

	float subtract(float a, float b) {
		return a-b;
	}

	float multiply(float a, float b) {
		return a*b;
	}

	// Must not be called with b == 0
	float divide(float a, float b) {
		return a/b;
	}

	Selection getUserSelection() {
		String instructions = "Select the calculation: \n" +
		"1. Addition\n" +
		"2. Multiplication\n" +
		"3. Subtraction\n" +
		"4. Division\n" +
		"\n" +
		"Selection: ";
		System.out.print(instructions);
		Scanner scanner = new Scanner(System.in);
		final boolean FOREVER = true;
		Selection result = Selection.UNDEFINED;
		while (FOREVER) {
			//@ TODO: Expects that only single integer is entered.
			// Should be changed to fail gracefully with all other values.
			int i = scanner.nextInt();
			switch (i)
			{
			case 1:
				result = Selection.ADD;
				break;

			case 2:
				result = Selection.MULTIPLY;
				break;

			case 3:
				result = Selection.SUBTRACT;
				break;

			case 4:
				result = Selection.DIVIDE;
				break;
			}

			if (result != Selection.UNDEFINED)
				return result;
			else
				System.out.println("Please select 1 or 2 or 3 or 4");
		}
	}

	float getAFloatFromUser() {
		System.out.print("Enter a number: ");
		//@ TODO: Expects that only single float is entered.
		// Should be changed to fail gracefully with all other values.
		Scanner scanner = new Scanner(System.in);
		return scanner.nextFloat();
	}

	public static void main(String[] args) {

		Calculator calc = new Calculator();
		Selection userSelection = calc.getUserSelection();
		float a = calc.getAFloatFromUser();
		float b = calc.getAFloatFromUser();

		switch (userSelection) {
			case ADD:
				System.out.println("The result of " + userSelection + " is " + calc.add(a,b));
				break;

			case MULTIPLY:
				System.out.println("The result of " + userSelection + " is " + calc.multiply(a,b));
				break;

			case SUBTRACT:
				System.out.println("The result of " + userSelection + " is " + calc.subtract(a,b));
				break;

			case DIVIDE:
				if (b == 0)
					System.out.println("you cannot insert zero for second input");
				else
					System.out.println("The result of " + userSelection + " is " + calc.divide(a,b));
				break;
		}
	}
}
