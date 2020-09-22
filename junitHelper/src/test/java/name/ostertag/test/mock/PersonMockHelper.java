package name.ostertag.test.mock;

import java.util.ArrayList;
import java.util.List;

import name.ostertag.test.mock.DTO.PersonDTO;
import name.ostertag.test.mock.DTO.Race;

public class PersonMockHelper {
	public static final PersonDTO aragorn = new PersonDTO("Aragorn", "Elessar Telcontar", Race.UNKNOWN);
	public static final PersonDTO boromir = new PersonDTO("Boromir", "of Gondor", Race.HUMAN).setAge(37);
	public static final PersonDTO elrond = new PersonDTO("Elrond", "", Race.HALF_ELF);
	public static final PersonDTO frodo = new PersonDTO("Frodo", "Baggins", Race.HOBBIT);
	public static final PersonDTO gandalf = new PersonDTO("Gandalf", "", Race.HUMAN);
	public static final PersonDTO gimli = new PersonDTO("Gimli", "", Race.DWARF);
	public static final PersonDTO legolas = new PersonDTO("Legolas", "", Race.ELF).setAge(1000);
	public static final PersonDTO merry = new PersonDTO("Merry", "", Race.HOBBIT);
	public static final PersonDTO person1 = new PersonDTO("Martin", "Schmidt", Race.HUMAN).setAge(33);
	public static final PersonDTO person2 = new PersonDTO("Otto", "Huber", Race.HUMAN).setAge(43);
	public static final PersonDTO person3 = new PersonDTO("Marcella", "Strojani", Race.HUMAN).setAge(13);
	public static final PersonDTO pippin = new PersonDTO("Pippin", "", Race.HOBBIT);
	public static final PersonDTO samwise = new PersonDTO("Samwise", "Gamgee", Race.HOBBIT).setAge(38);

	public static List<PersonDTO> mockFellowShipOfTheRing() {
		final List<PersonDTO> fellowshipOfTheRing = new ArrayList<>();
		fellowshipOfTheRing.add(frodo);
		fellowshipOfTheRing.add(samwise);
		fellowshipOfTheRing.add(merry);
		fellowshipOfTheRing.add(pippin);
		fellowshipOfTheRing.add(aragorn);
		fellowshipOfTheRing.add(gandalf);
		fellowshipOfTheRing.add(gimli);
		fellowshipOfTheRing.add(legolas);
		fellowshipOfTheRing.add(boromir);
		return fellowshipOfTheRing;
	}

}
