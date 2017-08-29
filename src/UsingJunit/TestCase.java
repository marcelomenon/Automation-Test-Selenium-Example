package UsingJunit;

public class TestCase {

	public static void main(String[] args) {
		
		JunitClass testcase = new JunitClass();
		JunitClass.setUpTest();
		testcase.completeForm();
		testcase.messageTest();
		JunitClass.tearDownTest();

		}
}