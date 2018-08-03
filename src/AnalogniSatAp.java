import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.time.LocalTime;

public class AnalogniSatAp extends Applet implements Runnable {

	/**
	* 
	*/
	private static final long serialVersionUID = 5352614777646158384L;
	Thread t = new Thread();
	int ss = 2;
	Point tacka;

	// TODO Auto-generated method stub
	@SuppressWarnings("null")
	public void init() {

		this.setSize(400, 400);

	}

	public void start() {
		t = new Thread(this, "AnalogniSatAp");

		t.start();
	}

	public void run() {
		while (Thread.currentThread() == t) {

			try {

				repaint();
				Thread.sleep(1000);

			} catch (InterruptedException e) {
			}
		}

	}

	public void paint(Graphics g) {
		// LocalTime lokalno=LocalTime.now();
		// int ss=lokalno.getSecond();
		tacka = new Point();
		LocalTime lokalno = LocalTime.now();
		if (lokalno.getSecond() > -1 && lokalno.getSecond() < 16) {
			tacka = getCoo1(lokalno.getSecond());
		} else if (lokalno.getSecond() > 15 && lokalno.getSecond() < 31) {
			tacka = getCoo2(lokalno.getSecond());
		} else if (lokalno.getSecond() > 30 && lokalno.getSecond() < 46) {
			tacka = getCoo3(lokalno.getSecond());
		} else if (lokalno.getSecond() > 45 && lokalno.getSecond() < 60) {
			tacka = getCoo4(lokalno.getSecond());
		}
		
		g.setColor(Color.BLACK);
		g.drawOval(50, 50, 300, 300);
		g.drawOval(40, 40, 320, 320);
		g.drawLine(200, 200, (int) tacka.getX(), (int) tacka.getY());
		g.drawString(String.valueOf(tacka.getX()), 50, 50);
		g.drawString(String.valueOf(tacka.getY()), 100, 50);
		g.drawString(String.valueOf(lokalno.getSecond()), 50, 70);
		g.setColor(Color.red);
		g.drawLine(310, 200, 350, 200);
		g.drawLine(200, 310, 200, 350);
		g.drawLine(50, 200, 90, 200);
		g.drawLine(200, 50, 200, 90);
		g.setColor(Color.BLACK);
		g.drawLine(255, 104, 275, 70);
		g.drawLine(145, 104, 125, 70);
		g.drawLine(275, 330, 255, 296);
		g.drawLine(125, 330, 145, 296);
		g.drawLine(296, 145, 330, 125);
		g.drawLine(296, 255, 330, 275);
		g.drawLine(104, 255, 70, 275);
		g.drawLine(104, 145, 70, 125);
		if (lokalno.getMinute() > -1 && lokalno.getMinute() < 16) {
			tacka = getCoo1(lokalno.getMinute());
		} else if (lokalno.getMinute() > 15 && lokalno.getMinute() < 31) {
			tacka = getCoo2(lokalno.getMinute());
		} else if (lokalno.getMinute() > 30 && lokalno.getMinute() < 46) {
			tacka = getCoo3(lokalno.getMinute());
		} else if (lokalno.getMinute() > 45 && lokalno.getMinute() < 60) {
			tacka = getCoo4(lokalno.getMinute());
		}
		g.setColor(Color.GREEN);
		g.drawLine(200, 200, (int) tacka.getX(), (int) tacka.getY());
		if(lokalno.getHour()==1||lokalno.getHour()==13)
		{
			tacka=getCoo1(5);
		}
		else if(lokalno.getHour()==2||lokalno.getHour()==14)
		{
			tacka=getCoo1(10);
		}
		else if(lokalno.getHour()==3||lokalno.getHour()==15)
		{
			tacka=getCoo1(15);
		}
		else if(lokalno.getHour()==4||lokalno.getHour()==16)
		{
			tacka=getCoo2(20);
		}
		else if(lokalno.getHour()==5||lokalno.getHour()==17)
		{
			tacka=getCoo2(25);
		}
		else if(lokalno.getHour()==6||lokalno.getHour()==18)
		{
			tacka=getCoo3(30);
		}
		else if(lokalno.getHour()==7||lokalno.getHour()==19)
		{
			tacka=getCoo3(35);
		}
		else if(lokalno.getHour()==8||lokalno.getHour()==20)
		{
			tacka=getCoo3(40);
		}
		else if(lokalno.getHour()==9||lokalno.getHour()==21)
		{
			tacka=getCoo4(45);
		}
		else if(lokalno.getHour()==10||lokalno.getHour()==22)
		{
			tacka=getCoo4(50);
		}
		else if(lokalno.getHour()==11||lokalno.getHour()==23)
		{
			tacka=getCoo4(55);
		}
		else if(lokalno.getHour()==0)
		{
			tacka=getCoo1(0);
		}
		g.setColor(Color.BLUE);
		g.drawLine(200, 200, (int) tacka.getX(), (int) tacka.getY());
	}

	public Point getCoo1(int ss) {
		double SS = 15 - ss;
		double angle1 = SS * 6;
		Point tacka = new Point();
		double x = 200 + (150 * (Math.cos(Math.toRadians(angle1))));

		double y = 50 + (150 - ((Math.cos(Math.toRadians(90 - angle1))) * 150));
		tacka.setLocation(x, y);
		return tacka;
	}

	public Point getCoo2(int ss) {
		double SS = 30 - ss;
		double angle1 = SS * 6;
		Point tacka = new Point();
		double x = 350 - (150 - (150 * (Math.cos(Math.toRadians(90 - angle1)))));

		double y = 200 + (((Math.cos(Math.toRadians(angle1))) * 150));
		tacka.setLocation(x, y);
		return tacka;
	}

	public Point getCoo3(int ss) {
		double SS = 45 - ss;
		double angle1 = SS * 6;
		Point tacka = new Point();
		double x = 200 - (150 * (Math.cos(Math.toRadians(angle1))));

		double y = 350 - (150 - ((Math.cos(Math.toRadians(90 - angle1))) * 150));
		tacka.setLocation(x, y);
		return tacka;
	}

	public Point getCoo4(int ss) {
		double SS = 60 - ss;
		double angle1 = SS * 6;
		Point tacka = new Point();
		double y = 200 - (150 * (Math.cos(Math.toRadians(angle1))));

		double x = 50 + (150 - ((Math.cos(Math.toRadians(90 - angle1))) * 150));
		tacka.setLocation(x, y);
		return tacka;
	}

}
