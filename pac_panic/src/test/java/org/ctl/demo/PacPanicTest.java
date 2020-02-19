package org.ctl.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sfvl.doctesting.ApprovalsBase;

import pac_panic.PacPanic;
import pac_panic.Tiles;

/**
 * Demo of a simple usage to generate documentation.
 */


public class PacPanicTest  extends ApprovalsBase {
	private static final  Tiles[][] THREE_CRATES = {{Tiles.Crate,Tiles.Empty},{Tiles.Crate,Tiles.Crate}};

	
    @BeforeEach
	public void init() {
    	initAsciiDocVariables();
    	breakLine(1);
    }
	
    @AfterEach
    public  void after() {
    	initAsciiDocStyle();
    }

	/**
     * Game start with a empty 13 *6  cells
     */
    @Test
    public void game_start_with_empty_13_by_6_cells() {

    	PacPanic game = new PacPanic();
    	
    	write(String.format("The number of row is = %d", game.getCells().length));
		breakLine(2);
    	
    	displayCells(game.getCells());
    }
    
    @Test
    public void next_tiles_to_spawn_need_to_be_2_by_2_with_a_empty_one_at_first_line_at_second_tile() {
    	PacPanic game = new PacPanic();
    	write(String.format("Tiles to spawn is a %s tiles", get2dArrayTilesDimension(game.getTilesToSpawn())));
    	breakLine(2);
    	write(String.format("The second tile at first row is %s", game.getTilesToSpawn()[0][1]));
    	//displayCells(game.getTilesToSpawn());
    }
    
    @Test
    public void spawnable_tiles_with_three_crate_look_like() {
    	PacPanic game = new PacPanic();   	
    	game.setTilesToSpawn(THREE_CRATES);
    	displayCells(game.getTilesToSpawn());
    }
    
    @Test
    public void given_three_crate_to_spawn_and_after_one_tic_game_board_will_look_like() {
    	PacPanic game = new PacPanic();   	
    	game.setTilesToSpawn(THREE_CRATES);
    	displayCells(game.getTilesToSpawn());
    	displayCells(game.tic().getCells());
    }
    
    @Test
    public void given_three_crate_to_spawn_and_after_two_tic_game_board_will_look_like() {
    	PacPanic game = new PacPanic();   	
    	game.setTilesToSpawn(THREE_CRATES);
    	displayCells(game.getTilesToSpawn());
    	displayCells(game.tic().tic().getCells());
    }
    
    @Test
    public void given_a_empty_board_with_three_crate_to_spawn_and_after_13_tics_game_board_will_look_like() {
    	PacPanic game = new PacPanic();   	
    	game.setTilesToSpawn(THREE_CRATES);
    	displayCells(game.getTilesToSpawn());
    	displayCells(tic(game, 13).getCells());
    }
    
	public PacPanic tic(PacPanic game, int n) {
		PacPanic lastState = null;
		for (int i = 0; i < n; i++) {
			lastState = game.tic();
		}
		return lastState;
	}
    
    private void displayCells(Tiles[][] cells) {	
    	tableStart();
    	for(int i=0; i<cells.length; i++) {
            for(int j=0; j<cells[i].length; j++) {
            	write("| {"+ cells[i][j].value()+"}");
            }
            breakLine(1);
        }
    	tableEnd();
    }
    
    private String get2dArrayTilesDimension(Tiles[][] cells) {	
    	int column = 0;
    	String result = null;
    	for(int i=0; i<cells.length; i++) {
        	if(column == 0 || column == cells[i].length) {
        		result = cells.length + " by " + cells[i].length;
        	}else {
        		result = "wtf?!";
        		break;
        	}
        }
    	return result;
    }
    
    private void tableStart() { write("[.myTable]\n|===\n"); }
    
    private void tableEnd() { write("|===\n"); }
    
    private void breakLine(int n) {
    	for (int i = 0; i < n; i++) {
    		write("\n"); 
		}
    }
    
	private void initAsciiDocVariables() {
		write(":0: image:tiles/empty.png[]\n");
		write(":1: image:tiles/crate.png[]\n");
		write(":2: image:tiles/crate_dead.png[]\n");
		write(":3: image:tiles/ghost.png[]\n");
		write(":4: image:tiles/ghost_afraid.png[]\n");
		write(":5: image:tiles/eaterR.png[]\n");
		write(":6: image:tiles/eaterL.png[]\n");
	}
	
	private void initAsciiDocStyle() {
		breakLine(1);
		write("++++\n");
		write("<style>\n");
		write(".myTable td{\n");
		write("background-color: grey;\n");
		write("border: 0;\n");
		write("padding : 0;\n");
		write("</style>\n");
		write("++++\n");
		write("\n");
	}
}
