import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class Frame {
	
	static JFrame frame = new JFrame("The Maze Coder");
	JPanel p = new JPanel(new BorderLayout());
	JPanel p2 = new JPanel(new BorderLayout());
	
	public Frame(int level){		
		
		final Board test = new Board(level,level,level);
		final Player player = new Player(test, level);
		
		p.add(test, BorderLayout.CENTER);
		p.setFocusable(true);
		frame.add(p, BorderLayout.CENTER);				
		frame.add(p2, BorderLayout.SOUTH);	
			
		
		JButton menu = new JButton("New Game");
		menu.setFocusable(false);
		p2.add(menu, BorderLayout.CENTER);
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				frame.dispose();
				new MainMenu();
			}
		});	
				
		p.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e){				
				int keyCode = e.getKeyCode();
				if(e.getKeyChar() == 'a' || keyCode == KeyEvent.VK_LEFT) player.moveLeft(test);
				if(e.getKeyChar() == 'd' || keyCode == KeyEvent.VK_RIGHT) player.moveRight(test);
				if(e.getKeyChar() == 'w' || keyCode == KeyEvent.VK_UP) player.moveUp(test);
				if(e.getKeyChar() == 's' || keyCode == KeyEvent.VK_DOWN) player.moveDown(test);
			}
		});	
		
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.green);
		frame.setVisible(true);
	}

	public Frame(int level, int money){
        
        frame.dispose();        
        JFrame frame2 = new JFrame();
        
        JLabel textLabel = new JLabel("Success", JLabel.CENTER);
        textLabel.setFont(new Font("Verdana", Font.BOLD, 32));
        
        frame2.setBackground(Color.green);
        frame2.add(textLabel, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500,500);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }
}