import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class tictactoe extends JFrame {
	private String player1 = "X";
	private String player2 = "O";
	private int clicks = 0;
	private static final int GRIDSIZE = 3;
	private TerrainButton[][] grid = new TerrainButton[GRIDSIZE][GRIDSIZE];
	
	public tictactoe () {
		initGUI();
		setTitle("Tic Tac Tiger");
		setSize(600,600);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private void initGUI() { 
		JLabel titleLabel = new JLabel(" Tic-Tac-Toe ");
		titleLabel.setOpaque(true);
		add(titleLabel, BorderLayout.PAGE_START);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		add(centerPanel, BorderLayout.CENTER);
		for (int r = 0; r < GRIDSIZE; r++) {
			for (int c = 0; c < GRIDSIZE; c++) {
				grid[r][c] = new TerrainButton(r, c);
				grid[r][c].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						TerrainButton button = (TerrainButton) e.getSource();
						int row = button.getRow();
						int col = button.getCol();
						click(row, col);
					}
				});
				centerPanel.add(grid[r][c]);
			}
		}
	
	}
	
	private void click(int row, int col) {
		clicks++;
		if(grid[row][col].isRevealed() == false) { 
			if (clicks%2 == 1) {
				grid[row][col].setText(player1);
			}
			if (clicks%2 == 0) {
				grid[row][col].setText(player2);
			}
		} else {
			clicks--;}
		
		}
   
     
     public static void main(String[] args) {
 		
 		try {
             String className = UIManager.getCrossPlatformLookAndFeelClassName();
             UIManager.setLookAndFeel(className);
         } catch ( Exception e) {}
         
         EventQueue.invokeLater(new Runnable (){
             @Override
             public void run() {
                 new tictactoe();
             }   
         });
 		
 	}
 

 	
	
}