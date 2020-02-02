package pac_panic;

public class PacPanic {
	
	Tiles[][] cells = new Tiles [13][6];

	public PacPanic() {
		 initTiles();
	}
	
	public Tiles[][] tic() {
		cells[0][2] = Tiles.Block;
		cells[0][3] = Tiles.Block;
		
		return cells;
	}

	public Tiles[][] getCells() {
		return cells;
	}
	
	private void initTiles() {
		for(int i=0; i<cells.length; i++) {
            for(int j=0; j<cells[i].length; j++) {
            	cells[i][j] = Tiles.Empty;
            }
        }
	}

}
