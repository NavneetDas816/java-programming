import java.awt.*;
import java.awt.event.*;


//adding window listener
class mywl implements WindowListener{
	public void windowActivated(WindowEvent ev){}
	public void windowDeactivated(WindowEvent ev){}
	public void windowOpened(WindowEvent ev){}
	public void windowIconified(WindowEvent ev){}
	public void windowDeiconified(WindowEvent ev){}
	public void windowClosed(WindowEvent ev){}
	public void windowClosing(WindowEvent ev){ev.getWindow().dispose();}
} 

//adding toolbox
class toolBox extends Panel{
	toolBox(){
		setSize(200,800);
		setVisible(true);
		setLayout(null);
		setBackground(Color.RED);
	}

}

//making frame
class screen extends Frame implements ActionListener,MouseMotionListener,MouseListener{

//setting veriables
	String label[] = {"pen","line","Rectangle","Circle","Rangom_line","Eraser"};
	Color c1 = new Color(255,255,0);
	Color c2 = new Color(255,255,225);

	Color cc1 = new Color(127,0,255);
	Color cc2 = new Color(255,128,0);
	Color cc3 = new Color(255,255,0);
	Color cc4 = new Color(128,255,0);
	Color cc5 = new Color(0,255,225);
	Color cc6 = new Color(0,0,0);

	Color selected_color = cc3;

	Font font1 = new Font("serif",Font.BOLD,20);
	toolBox p1;
	Button b[] = new Button[6];
	Button colour_choice[] = new Button[6];
	int pen_state,line_state,Rectangle_state,Circle_state,Polygon_state,Eraser_state=0;
	int lastX,lastY;
	Choice size,shape,state;
	Label width,show;
	
//-------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------
//making frame constructer
	screen(){
		setSize(1000,800);
		setVisible(true);
		setLayout(new BorderLayout());
		addMouseMotionListener(this);
		addMouseListener(this);


		p1 = new toolBox();
		add(p1,BorderLayout.WEST);

		for(int i=0;i<6;i++){
			b[i] = new Button(label[i]);
			b[i].setBounds(5,70*(i+1),190,50);
			b[i].addActionListener(this);
			p1.add(b[i]);
		}
		// setting subtools
		size = new Choice();
		for(int i=8;i<100;i=i+8){
			size.add(String.valueOf(i));
		}
		size.setBounds(95,140,100,50);
		width = new Label("Width :-");
		width.setFont(font1);
		width.setBounds(15,125,70,40);
		shape = new Choice();
		shape.add("boll");
		shape.add("sharpen");
		shape.setBounds(5,165,190,50);

		for(int i=0;i<6;i++){
			colour_choice[i] = new Button();
			colour_choice[i].addActionListener(this);
		}
		colour_choice[0].setBackground(cc1);
		colour_choice[1].setBackground(cc2);
		colour_choice[2].setBackground(cc3);
		colour_choice[3].setBackground(cc4);
		colour_choice[4].setBackground(cc5);
		colour_choice[5].setBackground(cc6);
		show = new Label();
		show.setBackground(c1);

		state = new Choice();
		state.add("Empty");
		state.add("Solid");
	}
	
//-------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------
//adding mouseMotion listener
	public void mouseDragged(MouseEvent e){
		if(pen_state==1){
			Graphics g=getGraphics(); 
			g.setColor(selected_color);  
			if(shape.getSelectedItem()=="boll"){
				g.fillOval(e.getX(),e.getY(),Integer.parseInt(size.getSelectedItem()),Integer.parseInt(size.getSelectedItem()));
			}
			else if (shape.getSelectedItem()=="sharpen"){
				g.drawLine(e.getX(),e.getY(),e.getX()+Integer.parseInt(size.getSelectedItem()),e.getY()+Integer.parseInt(size.getSelectedItem()));
			} 
		}
		else if(Eraser_state==1){
			Graphics g=getGraphics();  
    		g.setColor(Color.WHITE);  
    		g.fillRect(e.getX(),e.getY(),Integer.parseInt(size.getSelectedItem()),Integer.parseInt(size.getSelectedItem()));
		}
	}
	public void mouseMoved(MouseEvent e){}

//-------------------------------------------------------------------------------------------
//adding mouse listener
	public void mousePressed(MouseEvent ev){
		System.out.println("mouse pressed");
		lastX=ev.getX();
		lastY=ev.getY();
	}
	public void mouseReleased(MouseEvent ev){
		System.out.println("mouse released");
		if(line_state==1){
			System.out.println("drowing line");
			Graphics g = getGraphics();
			g.setColor(selected_color);
			g.drawLine(lastX,lastY,ev.getX(),ev.getY());
		}
		else if(Rectangle_state==1){
			System.out.println("drowing rectangle");
			Graphics g=getGraphics();   
			if(state.getSelectedItem()=="Empty"){
				g.setColor(selected_color);
				g.drawRect(lastX,lastY,ev.getX()-lastX,ev.getY()-lastY);
			}
			else if(state.getSelectedItem()=="Solid"){
				g.setColor(selected_color);
				g.fillRect(lastX,lastY,ev.getX()-lastX,ev.getY()-lastY);
			}
		}
		else if(Circle_state==1){
			System.out.println("drowing circle");
			Graphics g=getGraphics();   
			if(state.getSelectedItem()=="Empty"){
				g.setColor(selected_color);
				g.drawOval(lastX,lastY,ev.getX()-lastX,ev.getY()-lastY);
			}
			else if(state.getSelectedItem()=="Solid"){
				g.setColor(selected_color);
				g.fillOval(lastX,lastY,ev.getX()-lastX,ev.getY()-lastY);
			}
		}
		else if(Polygon_state==1){
			System.out.println("drowing polygon");
			Graphics g = getGraphics();
			int[] x = { lastX, lastX*2, lastX*3, ev.getX(), lastX*3, lastX*2};
        		int[] y1 = { lastY, lastY+20, lastY-20, ev.getY(), ev.getY()+20, ev.getY()-20 };
			if(state.getSelectedItem()=="Empty"){
				g.setColor(selected_color);
				g.drawPolygon(x, y1, 6);
			}
			else if(state.getSelectedItem()=="Solid"){
				g.setColor(selected_color);
				g.fillPolygon(x, y1, 6);
			}
		}
	}
	public void mouseClicked(MouseEvent ev){
		System.out.println("mouse clicked");
	}
	public void mouseEntered(MouseEvent ev){
		System.out.println("mouse entered");
	}
	public void mouseExited(MouseEvent ev){
		System.out.println("mouse exited");
	}

//-------------------------------------------------------------------------------------------
// Adding action performed
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		if(e.getActionCommand()=="pen" && line_state+Rectangle_state+Circle_state+Polygon_state+Eraser_state==0){
			if(pen_state==0){
				b[0].setBackground(c1);
				pen_state=1;
				for(int i=1;i<6;i++){
					b[i].setBounds(5,70*(i+1)+100,190,50);
				}
				p1.add(width);
				p1.add(size);
				p1.add(shape);
				show.setBounds(150,195,45,30);
				p1.add(show);
				for(int i=0;i<6;i++){
					colour_choice[i].setBounds(3*(i*7+5),195,20,30);
					p1.add(colour_choice[i]);
				}
			}
			else{
				b[0].setBackground(c2);
				pen_state=0;
				for(int i=1;i<6;i++){
					b[i].setBounds(5,70*(i+1),190,50);
				}
				p1.remove(width);
				p1.remove(size);
				p1.remove(shape);
				p1.remove(show);
				for(int i=0;i<6;i++){
					p1.remove(colour_choice[i]);
				}
			}
		}
		else if(e.getActionCommand()=="line" && pen_state+Rectangle_state+Circle_state+Polygon_state+Eraser_state==0){
			if(line_state==0){
				b[1].setBackground(c1);
				line_state=1;
				for(int i=2;i<6;i++){
					b[i].setBounds(5,70*(i+1)+100,190,50);
				}
				show.setBounds(150,240,45,30);
				p1.add(show);
				for(int i=0;i<6;i++){
					colour_choice[i].setBounds(3*(i*7+5),240,20,30);
					p1.add(colour_choice[i]);
				}
			}
			else{
				b[1].setBackground(c2);
				line_state=0;
				for(int i=2;i<6;i++){
					b[i].setBounds(5,70*(i+1),190,50);
				}
				p1.remove(show);
				for(int i=0;i<6;i++){
					p1.remove(colour_choice[i]);
				}
			}
		}
		else if(e.getActionCommand()=="Rectangle" && line_state+pen_state+Circle_state+Polygon_state+Eraser_state==0){
			if(Rectangle_state==0){
				b[2].setBackground(c1);
				Rectangle_state=1;
				for(int i=3;i<6;i++){
					b[i].setBounds(5,70*(i+1)+100,190,50);
				}
				state.setBounds(5,270,190,50);
				p1.add(state);
				show.setBounds(150,325,45,30);
				p1.add(show);
				for(int i=0;i<6;i++){
					colour_choice[i].setBounds(3*(i*7+5),325,20,30);
					p1.add(colour_choice[i]);
				}
			}
			else{
				b[2].setBackground(c2);
				Rectangle_state=0;
				for(int i=3;i<6;i++){
					b[i].setBounds(5,70*(i+1),190,50);
				}
				p1.remove(show);
				p1.remove(state);
				for(int i=0;i<6;i++){
					p1.remove(colour_choice[i]);
				}
			}
		}
		else if(e.getActionCommand()=="Circle" && line_state+Rectangle_state+pen_state+Polygon_state+Eraser_state==0){
			if(Circle_state==0){
				b[3].setBackground(c1);
				Circle_state=1;
				for(int i=4;i<6;i++){
					b[i].setBounds(5,70*(i+1)+100,190,50);
				}
				state.setBounds(5,350,190,50);
				p1.add(state);
				show.setBounds(150,400,45,30);
				p1.add(show);
				for(int i=0;i<6;i++){
					colour_choice[i].setBounds(3*(i*7+5),400,20,30);
					p1.add(colour_choice[i]);
				}
			}
			else{
				b[3].setBackground(c2);
				Circle_state=0;
				for(int i=4;i<6;i++){
					b[i].setBounds(5,70*(i+1),190,50);
				}
				p1.remove(show);
				p1.remove(state);
				for(int i=0;i<6;i++){
					p1.remove(colour_choice[i]);
				}
			}
		}
		else if(e.getActionCommand()=="Rangom_line" && line_state+Rectangle_state+Circle_state+pen_state+Eraser_state==0){
			if(Polygon_state==0){
				b[4].setBackground(c1);
				Polygon_state=1;
				for(int i=5;i<6;i++){
					b[i].setBounds(5,70*(i+1)+100,190,50);
				}
				state.setBounds(5,420,190,50);
				p1.add(state);
				show.setBounds(150,460,45,30);
				p1.add(show);
				for(int i=0;i<6;i++){
					colour_choice[i].setBounds(3*(i*7+5),460,20,30);
					p1.add(colour_choice[i]);
				}
			}
			else{
				b[4].setBackground(c2);
				Polygon_state=0;
				for(int i=5;i<6;i++){
					b[i].setBounds(5,70*(i+1),190,50);
				}
				p1.remove(show);
				p1.remove(state);
				for(int i=0;i<6;i++){
					p1.remove(colour_choice[i]);
				}
			}
		}
		else if(e.getActionCommand()=="Eraser" && line_state+Rectangle_state+Circle_state+Polygon_state+pen_state==0){
			if(Eraser_state==0){
				b[5].setBackground(c1);
				Eraser_state=1;
				width.setBounds(5,460,90,50);
				size.setBounds(100,475,90,50);
				p1.add(width);
				p1.add(size);
			}
			else{
				b[5].setBackground(c2);
				Eraser_state=0;
				p1.remove(width);
				p1.remove(size);
			}
		}
		else if(e.getSource()==colour_choice[0]){
			show.setBackground(cc1);
			selected_color=cc1;
		}
		else if(e.getSource()==colour_choice[1]){
			show.setBackground(cc2);
			selected_color=cc2;
		}
		else if(e.getSource()==colour_choice[2]){
			show.setBackground(cc3);
			selected_color=cc3;
		}
		else if(e.getSource()==colour_choice[3]){
			show.setBackground(cc4);
			selected_color=cc4;
		}
		else if(e.getSource()==colour_choice[4]){
			show.setBackground(cc5);
			selected_color=cc5;
		}
		else if(e.getSource()==colour_choice[5]){
			show.setBackground(cc6);
			selected_color=cc6;
		}
	}
}

//main class
class ndpaint{
	public static void main(String[] a){
		screen s = new screen();

		mywl window = new mywl();
		s.addWindowListener(window);
	}
}