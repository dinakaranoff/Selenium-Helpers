package com.dina.json;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties (ignoreUnknown = true)
@JsonInclude (JsonInclude.Include.NON_NULL)
@XmlRootElement (name = "Result")
public class Org {
	
	    private User User;
	    private String age;

	    public User getUser ()
	    {
	        return User;
	    }

	    public void setUser (User User)
	    {
	        this.User = User;
	    }

	    public String getAge ()
	    {
	        return age;
	    }

	    public void setAge (String age)
	    {
	        this.age = age;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [User = "+User+", age = "+age+"]";
	    }
	
}
