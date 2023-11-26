package pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="teams")
public class Team {
   
	@Column(name="team_id",length=20)
	private int teamid;
	@Column(name="team_name",length = 30)//varchar(30)
	private String teamname;
	@Column(name="team_abbri",length = 30)//varchar(30)
	private String abbreviation;
	@Column(name="owner_name",length = 30)//varchar(30)
	private String owner;
	@Column(name="max_age",length = 30)//varchar(30)
	private int maxAge;
	@Column(name="Min_battigAvg",length = 30)//varchar(30)
	private double minBattingAvg;
	@Column(name="Min_Wicket",length = 30)//varchar(30)
	private int minWicketsTaken;
	// + association property
		// Team 1--->* player
	@OneToMany(mappedBy = "myteam")
	private List<Player> players = new ArrayList<Player>();
	
	public Team() {
		
	}

	public Team(int teamid, String teamname, String abbreviation, String owner, int maxAge, double minBattingAvg,
			int minWicketsTaken) {
		super();
		this.teamid = teamid;
		this.teamname = teamname;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}

	public int getTeamid() {
		return teamid;
	}

	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
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

	@Override
	public String toString() {
		return "Team [teamid=" + teamid + ", teamname=" + teamname + ", abbreviation=" + abbreviation + ", owner="
				+ owner + ", maxAge=" + maxAge + ", minBattingAvg=" + minBattingAvg + ", minWicketsTaken="
				+ minWicketsTaken + "]";
	}
	
	// add helper method to establish a bi dir asso between entities
		public void addPlayer(Player p) {
			players.add(p);//Dept --> Emp
			p.setMyteam(this);;//Emp --> Dept
		}
	
	
}
