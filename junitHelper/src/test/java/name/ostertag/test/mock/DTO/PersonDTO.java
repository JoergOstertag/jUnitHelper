package name.ostertag.test.mock.DTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import name.ostertag.test.mock.IdHelper;

public class PersonDTO {

	// the age of the Person
	private int age = -1;

	// SImeId used for testing ignore
	private int awsomeId = -1;

	private final List<String> exampleList = new ArrayList<>();

	private final Map<String, String> exampleMap = new TreeMap<>();

	private final Set<String> exampleSet = new HashSet<>();

	// Gender of the person currently preset with a fixed Rule
	Gender gender = Gender.UNKNOWN;

	// the second(last) name of the person
	private String lastName;

	// The first Name of the Person
	private String name;

	// another ID for testing
	private int otherId = -1;

	// The race of this Person
	private Race race = Race.UNKNOWN;

	// A unique ID for Testing
	private int uniqueId = -1;

	/**
	 * Create a person.<br>
	 * if the name ends with "a" we assume it is female ;-)
	 *
	 * @param name
	 * @param lastName
	 * @param race
	 */
	public PersonDTO(String name, String lastName, Race race) {
		this.name = name;
		this.lastName = lastName;

		if (name.endsWith("a")) {
			gender = Gender.FEMALE;
		} else {
			gender = Gender.MALE;
		}
		this.race = race;

		// Set unique Ids
		otherId = IdHelper.getNextId();
		awsomeId = IdHelper.getNextId();
		uniqueId = IdHelper.getNextId();
	}

	public int getAge() {
		return age;
	}

	public int getAwsomeId() {
		return awsomeId;
	}

	public List<String> getExampleList() {
		return exampleList;
	}

	public Map<String, String> getExampleMap() {
		return exampleMap;
	}

	public Set<String> getExampleSet() {
		return exampleSet;
	}

	public Gender getGender() {
		return gender;
	}

	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return name;
	}

	public int getOtherId() {
		return otherId;
	}

	public Race getRace() {
		return race;
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public PersonDTO setAge(int age) {
		this.age = age;
		return this;
	}

	public PersonDTO setAwsomeId(int awsomeId) {
		this.awsomeId = awsomeId;
		return this;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public PersonDTO setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public PersonDTO setName(String name) {
		this.name = name;
		return this;
	}

	public PersonDTO setOtherId(int otherId) {
		this.otherId = otherId;
		return this;
	}

	public PersonDTO setRace(Race race) {
		this.race = race;
		return this;
	}

	public PersonDTO setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
		return this;
	}

}
