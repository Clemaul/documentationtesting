package pac_panic;

public class PacPanic {
	
	Tiles[][] cells = new Tiles [13][6];
	Tiles[][] tilesToSpawn = new Tiles [2][2];
	int ticFallCount = 1;

	public PacPanic() {
		initBoardTiles();
		generateTilesToSpawn();
	}
	
	public PacPanic tic() {
		if(ticFallCount ==1 ) {
			cells[0][2] = tilesToSpawn[1][0];
			cells[0][3] = tilesToSpawn[1][1];
		}else {
			cells[1][2] = cells[0][2];
			cells[1][3] = cells[0][3];
			cells[0][2] = tilesToSpawn[0][0];
			cells[0][3] = tilesToSpawn[0][1];

		}
		ticFallCount++;
		
		return this;
	}
	
	private void initBoardTiles() {
		for(int i=0; i<cells.length; i++) {
            for(int j=0; j<cells[i].length; j++) {
            	cells[i][j] = Tiles.Empty;
            }
        }
	}
	
	private void generateTilesToSpawn() {
		Tiles[][] generatedTiles = {
			{Tiles.Crate,Tiles.Empty},
			{Tiles.Crate,Tiles.Crate}
		};
		tilesToSpawn = generatedTiles;
	}
	
	public Tiles[][] getCells() {
		return cells;
	}

	public Tiles[][] getTilesToSpawn() {
		return tilesToSpawn;
	}

	public void setTilesToSpawn(Tiles[][] tilesToSpawn) {
		this.tilesToSpawn = tilesToSpawn;
	}

}
