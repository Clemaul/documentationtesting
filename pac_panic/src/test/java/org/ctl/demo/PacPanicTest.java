package org.ctl.demo;

import org.junit.jupiter.api.Test;
import org.sfvl.doctesting.ApprovalsBase;

import pac_panic.PacPanic;
import pac_panic.Tiles;

/**
 * Demo of a simple usage to generate documentation.
 */
public class PacPanicTest  extends ApprovalsBase {

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
    public void after_one_tic_two_tiles_appear_at_the_center_the_first_line() {
    	PacPanic game = new PacPanic();
    	game.tic();
    	displayCells(game.getCells());
    }
    
    private void displayCells(Tiles[][] cells) {	
    	tableStart();
    	for(int i=0; i<cells.length; i++) {
            for(int j=0; j<cells[i].length; j++) {
            	write("| "+ cells[i][j].value());
            }
            breakLine(1);
        }
    	tableEnd();
    }
    
    private void tableStart() { write("[%autowidth]\n|===\n"); }
    
    private void tableEnd() { write("|===\n"); }
    
    private void breakLine(int n) {
    	for (int i = 0; i < n; i++) {
    		write("\n"); 
		}
    }
    


}
