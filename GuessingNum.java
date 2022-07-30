import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuessingNum implements ActionListener 
{
	JFrame f1;
	JLabel l1,l3,l4,l5,l6,l7,l8;
	static JLabel l2;
	static JButton b1;
	static int score;
	GuessingNum()
	{
		f1 = new JFrame("Number Guessing Game");
		f1.setSize(800, 630);
		
		l1 = new JLabel("Number Guessing Game");
		l1.setBounds(200, 130, 400, 40);	
		l1.setFont(new Font("Serif",Font.ITALIC,35));
		l1.setForeground(Color.GREEN);

		b1 = new JButton("Let's start the Game");
		b1.setBounds(310, 190, 150, 30);
		b1.addActionListener(this);

		l2 = new JLabel();
		l2.setBounds(280, 250, 400, 30);	
		l2.setFont(new Font("Serif",Font.ITALIC,35));
		l2.setForeground(Color.RED);

		l3 = new JLabel("1. You have five chances ");
		l3.setBounds(200, 300, 300, 50);	
		l3.setFont(new Font("Serif",Font.ITALIC,20));

		l4 = new JLabel("2. If you enter correct number in ");
		l4.setBounds(200, 330, 300, 50);	
		l4.setFont(new Font("Serif",Font.ITALIC,20));

		l5 = new JLabel("3. First attempt Score is 100 ");
		l5.setBounds(200, 360, 300, 50);	
		l5.setFont(new Font("Serif",Font.ITALIC,20));

		l6 = new JLabel("4. For each wrong attempt your score will decrese with 20");
		l6.setBounds(200, 390, 600, 50);	
		l6.setFont(new Font("Serif",Font.ITALIC,20));

		l7 = new JLabel("5. Good Luck.");
		l7.setBounds(200, 420, 300, 50);	
		l7.setFont(new Font("Serif",Font.ITALIC,20));

		f1.add(l1);
		f1.add(l3);
		f1.add(l4);
		f1.add(l5);
		f1.add(l6);
		f1.add(l7);
		f1.add(b1);
		f1.add(l2);

		
		f1.setLayout(null);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		   int compNumber=(int)(Math.random()*100+1);
		   score=100;
	       int Answer=0;
	       System.out.println("CORRECT ANSWER :"+compNumber);
	       int count=0;
	       int MaxCount=4;
	       JOptionPane.showMessageDialog(null , "You have only 5 chances");
	       
	       while(Answer != compNumber)
	       {
	           if(count<=MaxCount)
	           {
	           String response=JOptionPane.showInputDialog(null, " Enter a Number between 1 and 100","Guessing Game",3);
	            Answer=Integer.parseInt(response);
	           count++;
	           JOptionPane.showMessageDialog(null, " "+determiningGuess(Answer,compNumber, count));
	           }
	           else 
			   {
	        	   break;
	           }
	       }
	       
	     
	}
	
	public static String determiningGuess(int Answer, int compNumber, int count)
    {
		if(count==5)
	       {  
	    	   l2.setText("Your Score: "+0);
	    	   b1.setText("Play again");
	       }
        if(Answer <=0 || Answer>100)
        {
        	score-=20;
            return " Your guess is invalid";
        }
		else if(Answer == compNumber)
        {
        	l2.setText("Your Score: "+score);
        	b1.setText("Play again");
            return"Your Choice is CORRECT!! \n Total Attempt :"+count;
        }
        else if(Answer> compNumber)
        {
        	score-=20;
            return " Your guess is HIGH, try again.\n Attempt Num:"+count;
        }
        else if(Answer< compNumber)
        {
        	score-=20;
            return " Your guess is LOW, try again. \n Attempt Num :"+count;
        }
        else 
        {
        	score-=20;
            return " Your guess is INCORRECT \n Try Again :"; 
        }
    }    

	public static void main(String[] args)
	{
		new GuessingNum();
	}

}