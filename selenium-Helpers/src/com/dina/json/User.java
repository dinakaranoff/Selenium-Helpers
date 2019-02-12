
package com.dina.json;

public class User  {  
	   public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	@Override
	public String toString(){
		return "id :"+id +"\n "+"name :"+ name+"\n "+"profession :"+profession;
		
	}
	   private int id; 
	   private String name; 
	   private String profession; 
	   
}	   
