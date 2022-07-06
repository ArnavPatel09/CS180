package homework_12;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.util.Random;

/**
 * Challenge 12 - Paint
 * The Paint is the class that allows you to draw
 * with different colors on a canvas. 
 * 
 * @author Arnav Patel, L12
 * @version November 17, 2021
 *
 */

public class Paint extends JComponent implements Runnable {
	
	Image image; // the canvas
	Graphics2D graphics2D;  // this will enable drawing
	int curX; // current mouse x coordinate
	int curY; // current mouse y coordinate
	int oldX; // previous mouse x coordinate
	int oldY; // previous mouse y coordinate
	
	Paint paint; // variable of the type Paint
	static int red;
	static int green;
	static int blue;
	
	JButton clrButton;
	JButton fillButton;
	JButton eraseButton;
	JButton randomButton;
	JButton hexButton;
	JButton rgbButton;
	JTextField hexText;
	JTextField rText;
	JTextField gText;
	JTextField bText;
	
	 ActionListener actionListener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() == clrButton) {
	                paint.clrButton();
	                hexText.setText("#");
	                rText.setText("");
	                gText.setText("");
	                bText.setText("");
	            }
	            if (e.getSource() == fillButton) {
	                paint.fillButton();
	                hexText.setText("#");
	                rText.setText("");
	                gText.setText("");
	                bText.setText("");
	            }
	            if (e.getSource() == eraseButton) {
	                paint.eraseButton();
	            }
	            if (e.getSource() == randomButton) {
	                paint.randomButton();
	                hexText.setText(String.format("#%02x%02x%02x", red, green, blue));
	                rText.setText(String.valueOf(red));
	                gText.setText(String.valueOf(green));
	                bText.setText(String.valueOf(blue));
	            }
	            
	            
	        }
	 };
	 
	 public void clrButton() { 
		 graphics2D.setPaint(Color.white);
		 graphics2D.setBackground(Color.white);
         graphics2D.fillRect(0, 0, getSize().width, getSize().height);
         graphics2D.setPaint(Color.black);
         repaint();
         
	 }
	 
	 public void fillButton() { 
         graphics2D.fillRect(0, 0, getSize().width, getSize().height);
         graphics2D.setBackground(graphics2D.getColor());
         repaint();
	 }
	 
	 public void eraseButton() { 
		 graphics2D.setPaint(graphics2D.getBackground());
	 }
	 
	 public void randomButton() { 
		 Random rand = new Random();
		 red = rand.nextInt(256);
		 blue = rand.nextInt(256);
		 green = rand.nextInt(256);
		 graphics2D.setPaint(new Color(red, green, blue));
	 }
	
	public static void main(String[] args) { 
		SwingUtilities.invokeLater(new Paint());
		
	}
	
	public void run() { 
		JFrame frame = new JFrame();
		frame.setTitle("Paint Challenge");
		
		
		Container content = frame.getContentPane();
		
		content.setLayout(new BorderLayout());
		paint = new Paint();
		content.add(paint, BorderLayout.CENTER);
		
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
		clrButton = new JButton("clear");
		clrButton.addActionListener(actionListener);
		fillButton = new JButton("fill");
		fillButton.addActionListener(actionListener);
		eraseButton = new JButton("erase");
		eraseButton.addActionListener(actionListener);
		randomButton = new JButton("random");
		randomButton.addActionListener(actionListener);
		
		hexButton = new JButton("hexButton");
		rgbButton = new JButton("rgbButton");
		
		hexText = new JTextField(5);
		hexText.setText("#");
		rText = new JTextField(5);
		gText = new JTextField(5);
		bText = new JTextField(5);
		
		JPanel panelTop = new JPanel();
		JPanel panelBot = new JPanel();
		panelTop.add(clrButton);
		panelTop.add(fillButton);
		panelTop.add(eraseButton);
		panelTop.add(randomButton);
		content.add(panelTop, BorderLayout.NORTH);
		
		panelBot.add(hexText);
		panelBot.add(hexButton);
		panelBot.add(rText);
		panelBot.add(gText);
		panelBot.add(bText);
		panelBot.add(rgbButton);
		content.add(panelBot, BorderLayout.SOUTH);
		
	
		rgbButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				try { 
					if (rText.getText().equals(""))
						red = 0;
					else
						red = Integer.valueOf(rText.getText());
					if (gText.getText().equals(""))
						green = 0;
					else
						green = Integer.valueOf(gText.getText());
					if (bText.getText().equals(""))
						blue = 0;
					else
						blue = Integer.valueOf(bText.getText());
					hexText.setText(String.format("#%02x%02x%02x", red, green, blue));
					paint.rgb();
					
				} catch (NumberFormatException a) {
					 JOptionPane.showMessageDialog(null, "Not a valid RGB Value", "Error", JOptionPane.ERROR_MESSAGE);					
				}
				
			}
		});
		
		hexButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				 try { 
					 System.out.println(hexText.getText());
					 Color color = Color.decode(hexText.getText());
					 red = color.getRed();
					 green = color.getGreen();
					 blue = color.getBlue();
					 
					 rText.setText(String.valueOf(red));
		             gText.setText(String.valueOf(green));
		             bText.setText(String.valueOf(blue));
					 
					 paint.rgb();
				 } catch (NumberFormatException a) { 
					 JOptionPane.showMessageDialog(null, "Not a valid Hex value", "Error", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		
		
		
	}
	
	public void rgb() { 
		graphics2D.setPaint(new Color(red, green, blue));
	}
	
	
	protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);

            // this lets us draw on the image (ie. the canvas)
            graphics2D = (Graphics2D) image.getGraphics();

            // gives us better rendering quality for the drawing lines 
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                       RenderingHints.VALUE_ANTIALIAS_ON);

            // set canvas to white with default paint color 
            graphics2D.setPaint(Color.white);
            graphics2D.setBackground(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            //set the paint brush size to 5
            graphics2D.setStroke(new BasicStroke(5));
            repaint();
        }
        g.drawImage(image, 0, 0, null);
	}
	
	
	
	public Paint() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // set oldX and oldY coordinates to beginning mouse press
                oldX = e.getX();
                oldY = e.getY();
            }
        });


        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // set current coordinates to where mouse is being dragged
                curX = e.getX();
                curY = e.getY();

                // draw the line between old coordinates and new ones
                graphics2D.drawLine(oldX, oldY, curX, curY);

                // refresh frame and reset old coordinates
                repaint();
                oldX = curX;
                oldY = curY;

            }
        });        
	}

}
