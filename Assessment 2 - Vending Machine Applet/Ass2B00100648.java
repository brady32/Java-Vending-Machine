//Programmer: Emma Brady
//Stident ID: B00100648
//Date Written: 23rd November 2017
//Function: Prompt user for vending machine options
//Note: Design an applet that continually allows the user to select optins from a vending machine and terminates when option 5 is chosen.


import java.util.Scanner; 	//importing scanner class
import java.applet.Applet;  //Import Applet
import java.awt.*; 			//Import Text class
import java.awt.event.*; 	//Import Event class
import java.awt.Graphics;	//Import Graphics class

public class Ass2B00100648 extends Applet implements ActionListener
{
			// Declare Labels
			Label Prompt,outputText;

			//Declare TextFields
			TextField Prompttext;

			//Declare variables
			double Item;
			int Coffee = 0, Tea = 0, Soup = 0, Water = 0, Finsh  = 0;
			int Choice;
			double Total = 0.00;


		public void init()
			{
				//Create Labels & TextFields
				Prompt = new Label(" Please enter your chosen item ");
				Prompttext = new TextField(10);
				outputText = new Label(" ");


				Prompttext.addActionListener(this);

				//Add Labels & TextFields to Applet
				add( Prompt );
				add( Prompttext );
				add( outputText );
				Prompttext.addActionListener(this);

				setBackground(Color.pink); //Setting the background colour
			}

		public void paint ( Graphics g ) // Painting the options on the screen
			{
				g.drawString( "Please choose an option 1-5 ", 150, 50 );
				g.drawString( "1. Coffee is €2.00: ", 150, 75 );
				g.drawString( "2. Tea is €2.00: ", 150, 90 );
				g.drawString( "3. Soup is €2.00: ", 150, 105 );
				g.drawString( "4. Water is €1.50: ", 150, 120 );
				g.drawString( "5. Finish & Pay: ", 150, 135 );
				g.drawString( " Your total is: €"+Double.toString (Total),150,200);
			}

		//Process user's action
		public void actionPerformed ( ActionEvent e )
			{
			// Get the number and convert it to an integer
			Choice = Integer.parseInt(Prompttext.getText());


			switch(Choice) //Implementation of Switch statement
				{
				case 1: Coffee++; showStatus("The item you have chosen is " +Coffee+ " Coffee(s) " );Prompttext.setText(""); break;
				case 2: Tea++; showStatus("The item you have chosen is " +Tea+ " Tea(s) "); Prompttext.setText(""); break;
				case 3: Soup++; showStatus("The item you have chosen is " +Soup+ " Soup(s) " ); Prompttext.setText(""); break;
				case 4: Water++; showStatus("The item you have chosen is " +Water+ " Water(s) "); Prompttext.setText(""); break;
				case 5: showStatus("Thank you for your custom!! "); Prompttext.setText(""); exit(); break;
				default: showStatus("Please choose an item 1-5 ");Prompttext.setText(""); break;
				}

			totDue(Coffee,Tea,Soup,Water);

			repaint();
			}


		public Double totDue(int par1,int par2,int par3,int par4)
		{
			//Implementation of total amount
			Total = (par1*2.00) + (par2*2.00) + (par3*2.00) + (par4*1.50);
			return(Total);
		}

		public void exit()
		{
			 //Setting the values to 0 so that the repaint method will set it back to 0.
			 Coffee = 0; Tea = 0; Soup = 0; Water = 0; Finsh = 0; Total = 0.00;
			 repaint();

		}

}//End class



