package ch_11_fx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel extends JPanel implements ActionListener {
	
	//�ʵ�
	JTextField a, b, c;
	double A, B, C;
	
	//������
	public MyPanel() {
		a = new JTextField("1.0", 10);
		b = new JTextField("-5.0", 10);
		c = new JTextField("6.0", 10);
		add(a);
		add(b);
		add(c);
		JButton button  = new JButton("DRAW");
		add(button);
		button.addActionListener(this);

	}
	
	
	//�׸��� �޼ҵ� 
	@Override
	protected void paintComponent(Graphics g) {
		// TODO �ڵ� ������ �޼ҵ� ����
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawLine(0, 200, 400, 200);
		g2.drawLine(200, 0, 200, 400);
		g2.setPaint(Color.red);
		for(int i = -20; i< 20; i++) {
			int x = i;
			int y = (int)(A*x*x - B*x + C);
			g2.fillOval(200 + x - 2, 200- (y-2), 4, 4);
		}
	}

	//�̺�Ʈ �޼ҵ� 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �ڵ� ������ �޼ҵ� ����
		A = Double.parseDouble(a.getText());
		B = Double.parseDouble(b.getText());
		C = Double.parseDouble(c.getText());
		repaint();
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MyPanel());
		f.setSize(500, 400);
		f.setVisible(true);

	}

}