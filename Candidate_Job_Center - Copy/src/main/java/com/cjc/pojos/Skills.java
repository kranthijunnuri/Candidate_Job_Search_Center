package com.cjc.pojos;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int skillId;
	
	@Column(nullable=false)
	private String skillName;
	
	
	
	public Skills() {
	}



	public Skills(int skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		
	}





	



	public Skills(String skillName) {
		super();
		this.skillName = skillName;
	}



	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	





	@Override
	public String toString() {
		return "Skills [skillId=" + skillId + ", skillName=" + skillName + "]";
	}





	
	
	

}
