package name.ostertag.test.mock;

public class IdHelper {

	private static int nextId = 1;

	public static int getNextId() {
		return nextId++;
	}

}
