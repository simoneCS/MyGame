import java.awt.Dimension;

import javax.swing.JButton;

public class TerrainButton extends JButton {

	private static final int SIZE = 50;
	private int row = 0;
	private int col = 0;
	
	private boolean revealed = false;
	
	
	
	
	public TerrainButton(int r, int c) {
		row = r;
		col = c;
		
		Dimension size = new Dimension(SIZE, SIZE);
		setPreferredSize(size);
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public boolean isRevealed() {
		return revealed;
	}
	
	public void reset() {
		revealed = false;
		setText(" ");
	}
	
	public void reveal(){
		revealed = true;
	}

	

	
	
}