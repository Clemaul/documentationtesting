package pac_panic;

public enum Tiles {

	Empty (0),
	Block (1),
	RedGhost (2),
	BlueGhost (3),
	PacMan (4),
	Fairy (5);
	
	private int value;

	private Tiles(int value) {
		this.value = value;
	}
	
	public int value() {
		return value;
	}

}
