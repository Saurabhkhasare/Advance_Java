package beans;

import java.sql.Date;

public class DepartmentBean {

	private String chooseTeam;
	private String name;
	private Date dob;
	private double minBattingAvg;
	private int minWicketsTaken;
	
	public DepartmentBean(String chooseTeam, String name, Date dob, double minBattingAvg, int minWicketsTaken) {
		super();
		this.chooseTeam = chooseTeam;
		this.name = name;
		this.dob = dob;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}

	public String getChooseTeam() {
		return chooseTeam;
	}

	public void setChooseTeam(String chooseTeam) {
		this.chooseTeam = chooseTeam;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getMinBattingAvg() {
		return minBattingAvg;
	}

	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}

	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}

	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}
	
	
	
}
