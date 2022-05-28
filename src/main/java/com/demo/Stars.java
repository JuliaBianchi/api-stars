package com.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stars {
	
	@Id @GeneratedValue
	private Long Id;
	private String name;
	private String scientificName;
	private String constellation;
	private String age;
	private String type;
	private String distanceEarth;
	
	public Long getId() { return Id; }
	
	public void setId(Long id) { Id = id; }
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public String getScientificName() {return scientificName;}
	
	public void setScientificName(String ScientificName) { this.scientificName = ScientificName; }
	
	public String getConstellation() { return constellation; }
	
	public void setConstellation(String constellation) { this.constellation = constellation; } 
	
	public String getAge() { return age; }
	
	public void setAge(String age) { this.age = age; }
	
	public String getType() { return type; }
	
	public void setType(String type) { this.type = type; }
	
	public String getDistanceEarth() { return distanceEarth; }
	
	public void setDistanceEarth(String distanceEarth) { this.distanceEarth = distanceEarth; }

	  Stars() {}

	public Stars(Long id, String name, String scientificName, String constellation, String age, String type,
			String distanceEarth) {
		super();
		Id = id;
		this.name = name;
		this.scientificName = scientificName;
		this.constellation = constellation;
		this.age = age;
		this.type = type;
		this.distanceEarth = distanceEarth;
	}

	@Override
	public String toString() {
		return "Stars [Id=" + Id + ", name=" + name + ", scientificName=" + scientificName + ", constellation="
				+ constellation + ", age=" + age + ", type=" + type + ", distanceEarth=" + distanceEarth + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, age, constellation, distanceEarth, name, scientificName, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stars other = (Stars) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(age, other.age)
				&& Objects.equals(constellation, other.constellation)
				&& Objects.equals(distanceEarth, other.distanceEarth) && Objects.equals(name, other.name)
				&& Objects.equals(scientificName, other.scientificName) && Objects.equals(type, other.type);
	}
	
	


}
