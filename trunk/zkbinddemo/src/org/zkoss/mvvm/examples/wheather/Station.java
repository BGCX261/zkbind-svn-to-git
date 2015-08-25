package org.zkoss.mvvm.examples.wheather;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.zkoss.bind.annotation.DependsOn;
import org.zkoss.bind.annotation.NotifyChange;

/*
Originate from zktodo2 of ZK.forge  by Simon Massey.
 */
public class Station {
	private String name = "";
	private Date date = new Date();
	private int target = 0;
	private int actual = 0;
	private boolean confirmed = false;
	public boolean getConfirmed() {
		return confirmed;
	}

	@NotifyChange
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	@DependsOn({"target", "actual"})
	public int getVariance() {
		return actual - target;
	}
	
	public String getName() {
		return name;
	}

	@NotifyChange
	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	@NotifyChange
	public void setDate(Date date) {
		this.date = date;
	}

	public int getTarget() {
		return target;
	}

	@NotifyChange
	public void setTarget(int target) {
		this.target = target;
	}

	public int getActual() {
		return actual;
	}

	@NotifyChange
	public void setActual(int actual) {
		this.actual = actual;
	}

	public static Station random() {
		Random random = new Random();
		Station station = new Station();
		StringBuilder builder = new StringBuilder();
		for( int i = 0; i < 2; i++ ){
			char randC = randomUpperCaseLetter();
			builder.append(randC);
		}
		builder.append((int) (Math.random() * 999));
		station.name = builder.toString();
		station.date = new GregorianCalendar(2010, random.nextInt(12), random.nextInt(29)).getTime();
		station.target = random.nextInt(80);
		station.actual = random.nextInt(80);
		station.confirmed = (random.nextInt(100) >= 50)?true:false;
		return station;
	}
	private static char randomUpperCaseLetter() {
		final int asciiUpperMax = 90;
		final int asciiUpperMin = 65;
		int range = asciiUpperMax-asciiUpperMin;
		int rand = (int) (Math.random() * range) + asciiUpperMin;
		char[] randCs = Character.toChars(rand);
		char randC = randCs[0];
		return randC;
	}
}
