
package name.ostertag.test.mock.DTO;

import org.apache.commons.lang3.StringUtils;

public enum Race {
	BIRD("bird", "tree"), //
	DWARF("dwarf", "Blue Mountains"), //
	ELF("elf", ""), //
	GOBLIN("goblin", ""), //
	HALF_ELF("half-elf", ""), //
	HOBBIT("hobbit", "middle-earth"), //
	HUMAN("human", "earth"), //
	TROLL("troll", "stones"), //
	UNKNOWN("UNKNOWN", ""), //
	;

	private String name;
	private String origin;

	Race(String name, String origin) {
		this.name = name;
		if (StringUtils.isBlank(origin)) {
			this.origin = "UNKNOWN";
		} else {
			this.origin = origin;
		}
	}

	public String getName() {
		return name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}
