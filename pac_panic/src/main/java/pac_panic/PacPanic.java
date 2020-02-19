package pac_panic;

public class PacPanic {
	
	Tiles[][] cells = new Tiles [13][6];
	Tiles[][] tilesToSpawn = new Tiles [2][2];
	Tiles[][] fallingTiles = new Tiles [2][2];
	int ticFallCount = 0;

	public PacPanic() {
		initBoardTiles();
		generateTilesToSpawn();
	}
	
	public PacPanic tic() {
		if(ticFallCount ==0 ) {
			cells[ticFallCount][2] = tilesToSpawn[1][0];
			cells[ticFallCount][3] = tilesToSpawn[1][1];
		}else if (ticFallCount == 1){
			cells[ticFallCount][2] = cells[0][2];
			cells[ticFallCount][3] = cells[0][3];
			
			cells[ticFallCount - 1][2] = tilesToSpawn[0][0];
			cells[ticFallCount - 1][3] = tilesToSpawn[0][1];
		}else {
			cells[ticFallCount][2] = cells[ticFallCount - 1][2];
			cells[ticFallCount][3] = cells[ticFallCount - 1][3];
			
			cells[ticFallCount - 1][2] = cells[ticFallCount - 2][2];
			cells[ticFallCount - 1][3] = cells[ticFallCount - 2][3];
			
			//clean up
			cells[ticFallCount - 2][2] = Tiles.Empty;
			cells[ticFallCount - 2][3] = Tiles.Empty;		
		}
		
		ticFallCount++;
		
		return this;
	}
	
	public void rotateLeft() {
		
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
