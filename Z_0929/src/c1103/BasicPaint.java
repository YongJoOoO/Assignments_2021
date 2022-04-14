package c1103;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasicPaint {

	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����

		JFrame f = new JFrame("�׷��� ���� ���α׷�");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MyPanel());
		
		f.setSize(300,200);
		f.setVisible(true);
		
	}

}

class MyPanel extends JPanel{
	
	private int squareX = 50; 
	private int squareY = 50;
	private int squareW = 20;
	private int squareH = 20;
	
	public MyPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}
		});
		
	}
	
	private void moveSquare(int x, int y) {
		int OFFSET = 1;
		if((squareX != x) || (squareY != y)) {
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
			squareX = x; 
			squareY = y;
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO �ڵ� ������ �޼ҵ� ����
		super.paintComponent(g);
		g.drawString("���콺�� Ŭ���ϸ� �簢���� �׷����ϴ�", 10, 20);
		g.setColor(Color.RED);
		g.fillRect(squareX, squareY, squareW, squareH);
		g.setColor(Color.BLACK);
		g.drawRect(squareX, squareY, squareW, squareH);
	}
	
	
}