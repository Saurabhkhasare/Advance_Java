package pojo;

import java.sql.Date;

public class Player {

	private int playerid; //PK
	private String firstname;
	private String lastname;
	private Date dob;
	private double battingAvg;
	private int wicketTaken;
	private int teamid;  // Fk
	
    public Player() {
		
	}

	public Player( String firstname, String lastname, Date dob, double battingAvg, int wicketTaken,
			int teamid) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketTaken = wicketTaken;
		this.teamid = teamid;
	}
	
	

	public Player(String firstName, String lastName, Date dob, double battingAvg, int wicketsTaken) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketTaken = wicketTaken;
	}

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketTaken() {
		return wicketTaken;
	}

	public void setWicketTaken(int wicketTaken) {
		this.wicketTaken = wicketTaken;
	}

	public int getTeamid() {
		return teamid;
	}

	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}

	@Override
	public String toString() {
		return "Player [playerid=" + playerid + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", battingAvg=" + battingAvg + ", wicketTaken=" + wicketTaken + ", teamid=" + teamid + "]";
	}
	
	
    
	
}
