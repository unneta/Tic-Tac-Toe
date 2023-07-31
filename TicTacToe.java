package tictactoe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener
{
	Random random = new Random();
	JFrame frame =  new JFrame();
	JPanel titlepanel= new JPanel();
	JPanel buttonpanel= new JPanel();
	JLabel textfield = new JLabel();
	JButton buttons[] = new JButton[9];
	boolean player1turn;
	
	TicTacToe()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free", Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		titlepanel.setLayout(new BorderLayout());
		titlepanel.setBounds(0,0,800,100);
		titlepanel.add(textfield);
		frame.add(titlepanel, BorderLayout.NORTH);
		
		buttonpanel.setLayout(new GridLayout(3,3));
		buttonpanel.setBackground(new Color(150,150,150));
		frame.add(buttonpanel);
		
		for(int i=0;i<9;i++)
		{
			buttons[i]= new JButton();
			buttonpanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		
		firstturn();

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==buttons[i])
			{
				if(player1turn)
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1turn=false;
						textfield.setText("O Turn");
						check();
					}
				}
				
				else				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1turn=true;
						textfield.setText("X Turn");
						check();
					}
				}

			}
		}
	}
	
	public void firstturn()
	{
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i=0;i<9;i++)
			{
				buttons[i].setEnabled(true);
			}
			
		
		if(random.nextInt(2)==0)
		{
			player1turn=true;
			textfield.setText("X Turn");
		}
		
		else
		{
			player1turn=false;
			textfield.setText("O Turn");
		}
	}
	
	public void check()
	{
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X"))
			xwins(0,1,2);
		if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X"))
			xwins(3,4,5);
		if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X"))
			xwins(6,7,8);
		if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X"))
			xwins(0,3,6);
		if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X"))
			xwins(1,4,7);
		if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X"))
			xwins(2,5,8);
		if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X"))
			xwins(0,4,8);
		if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X"))
			xwins(2,4,6);
		
		if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O"))
			owins(0,1,2);
		if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O"))
			owins(3,4,5);
		if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O"))
			owins(6,7,8);
		if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O"))
			owins(0,3,6);
		if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O"))
			owins(1,4,7);
		if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O"))
			owins(2,5,8);
		if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O"))
			owins(0,4,8);
		if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O"))
			owins(2,4,6);
		
		
		for(int x=0;x<9;x++)
		{
			if(buttons[x].getText()=="")
				break;
			if(x==8)
			{
				for(int i=0;i<9;i++)
				{
					buttons[i].setEnabled(false);
				}
				textfield.setText("Tie");
			}
		}
		
		
	}
	
	public void xwins(int a, int b, int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
		
		textfield.setText("X Wins");
	}
	
	public void owins(int a, int b, int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
		
		textfield.setText("O Wins");
	}

}
