package pojo;
import org.hibernate.*;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name ="players")
public class Player {
	
	@Column(name="player_id",length=20)
	private int playerid; //PK
	@Column(name="first_name",length = 30)//varchar(30)
	private String firstname;
	@Column(name="last_name",length = 30)//varchar(30)
	private String lastname;
	@Column(name="player_dob",length=20)
	private Date dob;
	@Column(name="batting_Avg",length=20)
	private double battingAvg;
	@Column(name="wicket_taken",length=20)
	private int wicketTaken;
	@Column(name="team_id",length=20)
	private int teamid;  // Fk
	// + association property
		// player *--->1 Team
	@ManyToOne
	@JoinColumn(name="teamID")
	private Team myteam;
	
    public Team getMyteam() {
		return myteam;
	}

	public void setMyteam(Team myteam) {
		this.myteam = myteam;
	}

	public Player() {
    	System.out.println("in def ctor of emp");
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
