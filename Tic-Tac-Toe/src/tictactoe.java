import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		setTitle("Tic Tac Toe");
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
				check(row,col); 
			}
			if (clicks%2 == 0) {
				grid[row][col].setText(player2);
				check(row,col);
			}
		} else {
			clicks--;
			check(row,col);}}
		
		private void check(int row, int col) {  
			if(grid[0][0].getText().equals (grid[0][1].getText()) && grid[0][0].getText().equals(grid[0][2].getText())
					&& !grid[0][0].getText().equals("") && !grid[0][1].getText().equals("") && !grid[0][2].getText().equals("")) { 
				  JOptionPane.showMessageDialog(null, " You won!! ");
			}
			if(grid[1][0].getText().equals( grid[1][1].getText()) && grid[1][0].getText().equals( grid[1][2].getText())
					&& !grid[1][0].getText().equals("") && !grid[1][1].getText().equals("") && !grid[1][2].getText().equals("")) { 
				JOptionPane.showMessageDialog(null, " You won!! ");
			
		}
			if(grid[2][0].getText().equals(grid[2][1].getText()) && grid[2][0].getText().equals(grid[2][2].getText())
					&& !grid[2][0].getText().equals("") && !grid[2][1].getText().equals("") && !grid[2][2].getText().equals("")) { 
				JOptionPane.showMessageDialog(null, " You won!! ");
			
		}
			if(grid[0][0].getText().equals(grid[1][0].getText()) && grid[0][0].getText().equals(grid[2][0].getText())
					&& !grid[0][0].getText().equals("") && !grid[1][0].getText().equals("") && !grid[2][0].getText().equals("")) { 
				JOptionPane.showMessageDialog(null, " You won!! ");
			
		}
			if(grid[0][1].getText().equals(grid[1][1].getText()) && grid[0][1].getText().equals(grid[2][1].getText())
					&& !grid[0][1].getText().equals("") && !grid[1][1].getText().equals("") && !grid[2][1].getText().equals("")) { 
				JOptionPane.showMessageDialog(null, " You won...fifth row!! ");
			
		}
			if(grid[0][2].getText().equals(grid[1][2].getText()) && grid[0][2].getText().equals(grid[2][2].getText())
					&& !grid[0][2].getText().equals("") && !grid[1][2].getText().equals("") && !grid[2][2].getText().equals("")) { 
				JOptionPane.showMessageDialog(null, " You won!! ");
			
		}
			if(grid[0][0].getText().equals(grid[1][1].getText()) && grid[0][0].getText().equals( grid[2][2].getText())
					&& !grid[0][0].getText().equals("") && !grid[1][1].getText().equals("") && !grid[2][2].getText().equals("")) { 
				JOptionPane.showMessageDialog(null, " You won!! ");
			
		}
			if(grid[2][0].getText().equals(grid[1][1].getText()) && grid[2][0].getText().equals( grid[0][2].getText()) 
					&& !grid[2][0].getText().equals("") && !grid[1][1].getText().equals("") && !grid[0][2].getText().equals("")) { 
				JOptionPane.showMessageDialog(null, " You won!! ");
			
		}
			if(clicks == 9 ) { 
				JOptionPane.showMessageDialog(null, " It's a tie ");
			}
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