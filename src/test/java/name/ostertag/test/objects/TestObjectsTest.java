package name.ostertag.test.objects;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import name.ostertag.test.mock.PersonMockHelper;
import name.ostertag.test.mock.DTO.PersonDTO;
import name.ostertag.test.utils.assertertion.AbstractTest;

public class TestObjectsTest extends AbstractTest {

	private static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

	@Test
	public void testFilenameAddition() {
		assertExpectedResult(PersonMockHelper.person1, "part1");
		assertExpectedResult(PersonMockHelper.person2, "part2");
	}

	@Test
	public void testList() {

		final List<PersonDTO> fellowshipOfTheRing = PersonMockHelper.mockFellowShipOfTheRing();

		assertExpectedResult(fellowshipOfTheRing);
	}

	@Test
	public void testSingleResult1() {
		assertExpectedResult(PersonMockHelper.person1);
	}

	@Test
	public void testSIngleResult2() {
		assertExpectedResult(PersonMockHelper.person2);
	}

}
