import javax.annotation.processing.SupportedOptions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
	String depolama = "";
	String tempDepolama = "";
	int func = 0;
	int sayi = 0;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[7];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, clrButton;
	JPanel alt_panel;
	JPanel ust_panel;

	double num1 = 0, num2 = 0, result = 0;
	char operator;
	int number_of_operators;

	public Calculator() {

		setTitle("calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 1000); 
		setLayout(null);
		setResizable(false);
		ust_panel = new JPanel();
		ust_panel.setBounds(0, 0, 800, 250);

		setButtons();
		clrButton.setBounds(50, 250, 700, 50);

		setAltPanel();

		add(clrButton);
		add(alt_panel);
		add(ust_panel);
		setVisible(true);
	}

	public void setButtons() {
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("÷");
		decButton = new JButton(".");
		equButton = new JButton("=");
		clrButton = new JButton("C");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = clrButton;

		for (int i = 0; i < 7; i++) {
			functionButtons[i].setFont(new Font("Arial", Font.PLAIN, 30));

			functionButtons[i].setBackground(Color.BLUE);
			functionButtons[i].addActionListener(this);
			functionButtons[i].setOpaque(true);
			functionButtons[i].setBackground(Color.BLUE);
			functionButtons[i].setForeground(Color.WHITE);
			functionButtons[i].setBorderPainted(false);

			// functionButtons[i].setFocusable(false);
		}

		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 40));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setOpaque(true);
			numberButtons[i].setBackground(Color.BLUE);
			numberButtons[i].setForeground(Color.WHITE);
			numberButtons[i].setBorderPainted(false);
			// numberButtons[i].setFocusable(false);
		}

	}

	public void setAltPanel() {
		alt_panel = new JPanel();// 425
		alt_panel.setBounds(50, 300, 700, 500);// 500->725
		alt_panel.setLayout(new GridLayout(4, 4, 10, 10));

		alt_panel.add(numberButtons[7]);
		alt_panel.add(numberButtons[8]);
		alt_panel.add(numberButtons[9]);
		alt_panel.add(addButton);
		alt_panel.add(numberButtons[4]);
		alt_panel.add(numberButtons[5]);
		alt_panel.add(numberButtons[6]);
		alt_panel.add(subButton);
		alt_panel.add(numberButtons[1]);
		alt_panel.add(numberButtons[2]);
		alt_panel.add(numberButtons[3]);
		alt_panel.add(mulButton);
		alt_panel.add(numberButtons[0]);
		alt_panel.add(decButton);
		alt_panel.add(equButton);
		alt_panel.add(divButton);

	}

	public static void main(String[] args) {

		Calculator calc = new Calculator();
	}

	public void paint(Graphics g) {// 50,25-700,50
		super.paint(g);// ???
		g.clearRect(0, 0, 800, 250);
		



		if(depolama.length()>=10){
			//cizdir(depolama.substring(0, 10),g);
			if(sayi==0){
				
					cizdir(depolama.substring(0, 10), g);
			}
			else{
				cizdir(tempDepolama.substring(0, 10), g);
			}
		}
		else{
			//cizdir(depolama, g);
			if(sayi==0){
				cizdir(depolama, g);
			}
			else{
				cizdir(tempDepolama, g);
			}
		}
		

	
	}
	public static boolean isInteger(double number){
		return Math.ceil(number) == Math.floor(number); 
	}
	public void cizdir(String depolama,Graphics g){
		if (depolama != null) {
			for (int i = depolama.length()-1; i >= 0; i--) {
				boolean A = false, B = false, C = false, D = false, E = false,
							 F = false, G = false, H = false, I = false;;
				switch (depolama.charAt(i)) {
					case '0':
						A = true;
						B = true;
						C = true;
						D = true;
						E = true;
						F = true;
						break;
					case '1':
						B = true;
						C = true;
						break;
					case '2':
						A = true;
						B = true;
						D = true;
						E = true;
						G = true;
						break;
					case '3':
						A = true;
						B = true;
						C = true;
						D = true;
						G = true;
						break;
					case '4':
						B = true;
						C = true;
						F = true;
						G = true;
						break;
					case '5':
						A = true;
						C = true;
						D = true;
						F = true;
						G = true;
						break;
					case '6':
						A = true;
						C = true;
						D = true;
						E = true;
						F = true;
						G = true;
						break;
					case '7':
						A = true;
						B = true;
						C = true;
						break;
					case '8':
						A = true;
						B = true;
						C = true;
						D = true;
						E = true;
						F = true;
						G = true;
						break;
					case '9':
						A = true;
						B = true;
						C = true;
						D = true;
						F = true;
						G = true;
						break;
					case '.':
						H = true;
						break;
					case '-':
						I = true;
						break;
				}// Ally+1,
				
				if (A) {// A
					g.fillRect(740-80*(depolama.length()-1-i), 44, 45, 7);
				}
				if (B) { // B
					g.fillRect(785-80*(depolama.length()-1-i), 54, 7, 45);
				}
				if (C) { // C
					g.fillRect(785-80*(depolama.length()-1-i), 112 , 7, 45);
				}
				if (D) { // D
					g.fillRect(740-80*(depolama.length()-1-i), 160, 45, 7);
				}
				if (E) { // E
					g.fillRect(733-80*(depolama.length()-1-i), 112, 7, 45);
				}
				if (F) { // F
					g.fillRect(733-80*(depolama.length()-1-i), 54, 7, 45);
				}
				if (G) { // G
					g.fillRect(740-80*(depolama.length()-1-i), 102, 45, 7);
				}
				if (H) {
					g.fillRect(740-80*(depolama.length()-1-i), 160 , 7, 7);
				}
				if (I) {
					g.fillRect(740-80*(depolama.length()-1-i), 102 , 50, 7);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		validate();
		repaint();
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				func = 0;
				depolama = depolama + i;
				tempDepolama = depolama;
			}
		}
		if (e.getSource() == decButton) {
			depolama = depolama + ".";
			tempDepolama = depolama;
		}


		if (e.getSource() == addButton) {
			func++;
			sayi++;
			num1 = Double.parseDouble(depolama);
			tempDepolama = depolama;
			operator = '+';
			depolama = "";
		}
		if (e.getSource() == subButton) {
			func++;
			sayi++;
			num1 = Double.parseDouble(depolama);
			tempDepolama = depolama;
			operator = '-';
			depolama = "";
		}
		if (e.getSource() == mulButton) {
			func++;
			sayi++;
			num1 = Double.parseDouble(depolama);
			tempDepolama = depolama;
			operator = '*';
			depolama = "";
		}
		if (e.getSource() == divButton) {
			func++;
			sayi++;
			num1 = Double.parseDouble(depolama);
			tempDepolama = depolama;
			operator = '÷';
			depolama = "";
		}
		if (e.getSource() == equButton) {
			sayi = 0;
			func++;
			num2 = Double.parseDouble(depolama);
			
				
			
			if(operator == '+')
				result = num1 + num2;
			if(operator == '-')
				result = num1 - num2;
			if(operator == '*')
				result = num1 * num2;
			if(operator == '÷')
				result = num1 / num2;
			
			
			/*
			switch (operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '÷':
					result = num1 / num2;
					break;
				
			}*/

			
			
			
			
			if(result == Math.floor(result))
				//depolama = Integer.toString((int)result);
				depolama = (int)result+"";
			else
				//depolama = Double.toString(result);
				depolama = result+"";

			
			//depolama = result + "";
			num1 = result;
			
			
			
			
			
			
		}
		if (e.getSource() == clrButton) {
			func = 0;
			depolama = "";
			tempDepolama = depolama;
		}
		

		validate();
		repaint();
		// System.out.println(textfield.getText());
		ust_panel.validate();
		ust_panel.repaint();

	}

}
