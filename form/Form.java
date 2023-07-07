import java.awt.*;
import java.awt.event.*;

class Id_pannel extends Frame{
	Id_pannel( String name,String f_name, String  id, String email, String number, String addr){
		
		Font font3 = new Font("serif",Font.BOLD,20);
		Font font4 = new Font("serif",Font.BOLD,20);

		String data[] = {name,f_name,email,id,number,addr};
		String label[] = {"name","father","email","id","phone_no","address"};
		Label l[] = new Label[6];
		Label la[] = new Label[6];
		for(int i = 0;i<6;i++){
			l[i] = new Label(data[i]);
			l[i].setFont(font3);
			l[i].setBounds(130,50+(40*i),270,20);
			add(l[i]);
			la[i] = new Label(label[i]+" :-");
			la[i].setFont(font3);
			la[i].setBounds(50,50+(40*i),270,20);
			add(la[i]);
		}

		setSize(600,400);
		setTitle("ID");
		setBackground(Color.lightGray);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
	}
}
//------------------------------------------------------------------------------------------		
//------------------------------------------------------------------------------------------		
class mywl implements WindowListener{
	public void windowActivated(WindowEvent ev){
		System.out.println("Activated");
	}
	public void windowDeactivated(WindowEvent ev){
		System.out.println("Deactivated");
	}
	public void windowOpened(WindowEvent ev){
		System.out.println("Opened");
	}
	public void windowIconified(WindowEvent ev){
		System.out.println("Iconified");
	}
	public void windowDeiconified(WindowEvent ev){
		System.out.println("Deiconified");
	}
	public void windowClosed(WindowEvent ev){
		System.out.println("Closed");
	}
	public void windowClosing(WindowEvent ev){
		System.out.println("Closing");
		ev.getWindow().dispose();
	}
}
//------------------------------------------------------------------------------------------		
//------------------------------------------------------------------------------------------		

class Form extends Frame implements ActionListener{
	int Height = 30 , Width = 170 , Margen = 150 , labels= 150 , spacebetween = 50;
	Button submit , cancel ,clear;
	TextField name_textfield , f_name_textfield , id_textfield , email_textfield , number_textfield , addr_textfield;
	Checkbox chkmale;
	CheckboxGroup cg;
	Form(){
		
	
		Font font1 = new Font("serif",Font.BOLD,20);
		Font font2 = new Font("serif",Font.BOLD,40);
//------------------------------------------------------------------------------------------
		Label title = new Label("Sample_Form");
		title.setForeground(Color.blue);
		title.setFont(font2);
		title.setBounds(Margen+20,40,Width+100,Height+50);
		add(title);
//------------------------------------------------------------------------------------------

		Label name = new Label("NAME");
		name.setFont(font1);
		name.setBounds(Margen,labels,Width,Height);
		add(name);

		name_textfield = new TextField();
		name_textfield.setBounds(Margen+Width,labels,Width,Height);
		add(name_textfield);

//------------------------------------------------------------------------------------------

		Label f_name = new Label("FATHER_NAME");
		f_name.setFont(font1);
		f_name.setBounds(Margen,labels+30+spacebetween,Width,Height);
		add(f_name);

		f_name_textfield = new TextField();
		f_name_textfield.setBounds(Margen+Width,labels+30+spacebetween,Width,Height);
		add(f_name_textfield);

//------------------------------------------------------------------------------------------

		Label id = new Label("ID");
		id.setFont(font1);
		id.setBounds(Margen,labels+60+spacebetween*2,Width,Height);
		add(id);

		id_textfield = new TextField();
		id_textfield.setBounds(Margen+Width,labels+60+spacebetween*2,Width,Height);
		add(id_textfield);

//------------------------------------------------------------------------------------------

		Label email = new Label("E-MAIL");
		email.setFont(font1);
		email.setBounds(Margen,labels+90+spacebetween*3,Width,Height);
		add(email);

		email_textfield = new TextField();
		email_textfield.setBounds(Margen+Width,labels+90+spacebetween*3,Width,Height);
		add(email_textfield);

//------------------------------------------------------------------------------------------

		Label number = new Label("PHONE_NUMBER");
		number.setFont(font1);
		number.setBounds(Margen,labels+120+spacebetween*4,Width,Height);
		add(number);

		number_textfield = new TextField();
		number_textfield.setBounds(Margen+Width+50,labels+120+spacebetween*4,Width-50,Height);
		add(number_textfield);
		
		Choice country = new Choice();
		for(int r=80 ; r<100 ; r++){
			country.add("+"+r);
		}
		country.setBounds(Margen+Width,labels+120+spacebetween*4,50,Height);
		add(country);

//------------------------------------------------------------------------------------------

		Label addr = new Label("Address");
		addr.setFont(font1);
		addr.setBounds(Margen,labels+150+spacebetween*5,Width,Height);
		add(addr);

		addr_textfield = new TextField();
		addr_textfield.setBounds(Margen+Width,labels+150+spacebetween*5,Width,Height);
		add(addr_textfield);

//------------------------------------------------------------------------------------------

		Label gender = new Label("Gender");
		gender.setFont(font1);
		gender.setBounds(Margen,labels+180+spacebetween*6,Width,Height);
		add(gender);

		cg = new CheckboxGroup();

		chkmale = new Checkbox("male",cg,true);
		chkmale.setBounds(Margen+Width,labels+180+spacebetween*6,Width-100,Height);
		add(chkmale);

		Checkbox chkfemale = new Checkbox("female",cg,false);
		chkfemale.setBounds(Margen+Width+80,labels+180+spacebetween*6,Width-100,Height);
		add(chkfemale);

		Checkbox others = new Checkbox("others",cg,false);
		others.setBounds(Margen+Width+160,labels+180+spacebetween*6,Width,Height);
		add(others);

//------------------------------------------------------------------------------------------

		Label category = new Label("Category");
		category.setFont(font1);
		category.setBounds(Margen,labels+210+spacebetween*7,Width,Height);
		add(category);

		Choice c = new Choice();
		c.add("GENERAL");
		c.add("SC");
		c.add("ST");
		c.add("OBC");
		c.setBounds(Margen+Width,labels+210+spacebetween*7,Width,Height);
		add(c);

//------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------
		submit = new Button("Submit");
		submit.setBounds(Margen+Width+80,labels+210+spacebetween*9,Width,Height);
		add(submit);
		submit.addActionListener(this);
//------------------------------------------------------------------------------------------
		cancel = new Button("Cancel");
		cancel.setBounds(Margen-Width+50,labels+210+spacebetween*9,Width,Height);
		add(cancel);
		cancel.addActionListener(this);
//------------------------------------------------------------------------------------------
		clear = new Button("clear");
		clear.setBounds(Margen+65,labels+210+spacebetween*9,Width,Height);
		add(clear);
		clear.addActionListener(this);
//------------------------------------------------------------------------------------------
		setSize(600,900);
		setTitle("FORM");
		setBackground(Color.lightGray);
		setLayout(null);
		setVisible(true);
	}
//------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == submit){
			Id_pannel ip = new Id_pannel(name_textfield.getText() , f_name_textfield.getText() , id_textfield.getText() , email_textfield.getText() , number_textfield.getText() , addr_textfield.getText());
			setVisible(false);
			System.out.println("submit");
			System.out.println(String.valueOf(cg.getSelectedCheckbox()));
			ip.addWindowListener(new mywl());
			
		}
		else if (e.getSource() == cancel){
			System.out.println("cancel");
			System.exit(0);
		}
		else if (e.getSource() == clear){
			name_textfield.setText(" ");
			f_name_textfield.setText(".");
			id_textfield.setText(".");
			email_textfield.setText(".");
			number_textfield.setText(".");
			addr_textfield.setText(".");
			
			System.out.println("cleared");
		}
	}

//------------------------------------------------------------------------------------------		
	public static void main(String[] a){
		Form f = new Form();
		
		mywl window = new mywl();
		f.addWindowListener(window);
	}
}