import java.awt.*;

class First_page extends Frame{
	First_page(){
	Label firstname = new Label("it should be printed");
	firstname.setBounds(150,150,150,150);

	add(firstname);

	setSize(300,300);
	setLayout(null);
	setVisible(true);
	}
}


class Form{
	public static void main(String a[]){
		First_page one = new First_page();	
	}
}