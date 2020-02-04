package pac_panic;

public enum Tiles {

	Empty (0),
	Crate (1),
	CrateDead (2),
	Ghost (3),
	GhostAfraid (4),
	EaterRight (5),
	EaterLeft (6),
	Fairy (7);
	
	private int value;

	private Tiles(int value) {
		this.value = value;
	}
	
	public int value() {
		return value;
	}

}
