package name.ostertag.test.utils.assertertion;

// entry point for all assertThat methods and utility methods (e.g. entry)
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.tuple;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import name.ostertag.test.mock.PersonMockHelper;
import name.ostertag.test.mock.DTO.PersonDTO;
import name.ostertag.test.mock.DTO.Race;

public class AssertJTest extends AbstractTest {

	private static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

	@Test
	public void test01() {

		final Object person1DTO = PersonMockHelper.person1;
		final PersonDTO person2DTO = PersonMockHelper.person2;
		Assertions.assertThat(person2DTO).usingRecursiveComparison()
				.ignoringFields("name", "lastName", "uniqueId", "otherId", "age")
				.ignoringFieldsMatchingRegexes(".*someId").ignoringOverriddenEqualsForTypes(Race.class, Race.class)
				.isEqualTo(person1DTO);

	}

	/**
	 * Check if we can compare a single property of the Object
	 */
	@Test
	public void test02() {
		final PersonDTO personDTO = PersonMockHelper.person1;

		// basic assertions
		assertThat(personDTO.getName()).isEqualTo("Martin");
		assertThat(personDTO).isNotEqualTo(PersonMockHelper.person2);

	}

	/**
	 * Check StartWith, EndsWith and isEqualToIgnoringCase
	 */
	@Test
	public void test03() {
		final PersonDTO personDTO = PersonMockHelper.frodo;

		// chaining string specific assertions
		assertThat(personDTO.getName()).startsWith("Fro").endsWith("do").isEqualToIgnoringCase("frodo");

	}

	/**
	 * check hasSize, contains, doesNotContain
	 */
	@Test
	public void test04() {
		final List<PersonDTO> fellowshipOfTheRingList = PersonMockHelper.mockFellowShipOfTheRing();

		// collection specific assertions (there are plenty more)
		// in the examples below fellowshipOfTheRing is a List<TolkienCharacter>
		assertThat(fellowshipOfTheRingList).hasSize(9).contains(PersonMockHelper.frodo, PersonMockHelper.samwise)
				.doesNotContain(PersonMockHelper.person1);

	}

	/**
	 * Check extracting age and comparing
	 */
	@Test
	public void test05() {
		final PersonDTO personDTO = PersonMockHelper.person1;

		// as() is used to describe the test and will be shown before the error message
		assertThat(personDTO.getAge()).as("check %s's age", personDTO.getName()).isEqualTo(33);

	}

	/**
	 * Check Exception cheking
	 */
	@Test
	public void test06() {
		// exception assertion, standard style ...
		assertThatThrownBy(() -> {
			throw new Exception("boom!");
		}).hasMessage("boom!");
		// ... or BDD style
		final Throwable thrown = catchThrowable(() -> {
			throw new Exception("boom!");
		});
		assertThat(thrown).hasMessageContaining("boom");

	}

	/**
	 * check extracting Name and doesNotContain
	 */
	@Test
	public void test07() {
		final List<PersonDTO> fellowshipOfTheRing = PersonMockHelper.mockFellowShipOfTheRing();

		// using the 'extracting' feature to check fellowshipOfTheRing character's names
		assertThat(fellowshipOfTheRing).extracting(PersonDTO::getName).doesNotContain("person2", "Elrond");

	}

	/**
	 * check using extracting tuples
	 */
	@Test
	public void test08() {
		final List<PersonDTO> fellowshipOfTheRing = PersonMockHelper.mockFellowShipOfTheRing();

		// extracting multiple values at once grouped in tuples
		assertThat(fellowshipOfTheRing) //
				.extracting("name", "age", "race.name")//
				.contains(//
						tuple("Boromir", 37, "human"), //
						tuple("Samwise", 38, "hobbit"), //
						tuple("Legolas", 1000, "elf"));

	}

	/**
	 * Check filteredOn
	 */
	@Test
	public void test09() {
		final List<PersonDTO> fellowshipOfTheRing = PersonMockHelper.mockFellowShipOfTheRing();

		// filtering a collection before asserting
		assertThat(fellowshipOfTheRing).filteredOn(character -> character.getName().contains("o")).containsOnly(
				PersonMockHelper.frodo, //
				PersonMockHelper.aragorn, //
				PersonMockHelper.legolas, //
				PersonMockHelper.boromir //
		);

	}

	/**
	 * check filtering and extracting tuples
	 */
	@Test
	public void test10() {
		final List<PersonDTO> fellowshipOfTheRing = PersonMockHelper.mockFellowShipOfTheRing();

		// combining filtering and extraction (yes we can)
		assertThat(fellowshipOfTheRing).filteredOn(person -> person.getName().contains("o")) //
				.containsOnly(//
						PersonMockHelper.aragorn, //
						PersonMockHelper.frodo, //
						PersonMockHelper.legolas, //
						PersonMockHelper.boromir) //
				.extracting(person -> person.getRace().getName()).contains("hobbit", "elf", "human");

	}

}
