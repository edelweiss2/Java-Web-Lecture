package ch07;

import java.time.LocalDate;

public class Player {
	private int backNumber;
	private String name;
	private String position;
	private LocalDate bday;
	private int height;
	private int isDeleted;
	
	Player() {}

	Player(int backNumber, String name, String position, LocalDate bday, int height) {
		super();
		this.backNumber = backNumber;
		this.name = name;
		this.position = position;
		this.bday = bday;
		this.height = height;
	}


	Player(int backNumber, String name) {
		super();
		this.backNumber = backNumber;
		this.name = name;
	}

	Player(int backNumber, String name, String position, LocalDate bday, int height, int isDeleted) {
		super();
		this.backNumber = backNumber;
		this.name = name;
		this.position = position;
		this.bday = bday;
		this.height = height;
		this.isDeleted = isDeleted;
	}

	public int getBackNumber() {
		return backNumber;
	}

	public void setBackNumber(int backNumber) {
		this.backNumber = backNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LocalDate getBday() {
		return bday;
	}

	public void setBday(LocalDate bday) {
		this.bday = bday;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Player [backNumber=" + backNumber + ", name=" + name + ", position=" + position + ", bday=" + bday
				+ ", height=" + height + ", isDeleted=" + isDeleted + "]";
	}
	
}


