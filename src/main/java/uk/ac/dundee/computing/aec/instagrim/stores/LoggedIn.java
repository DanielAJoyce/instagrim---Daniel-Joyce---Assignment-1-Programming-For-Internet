/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.stores;


/**
 *
 * @author Administrator
 */
public class LoggedIn {
    boolean logedin=false;
    String Username=null;
    String email=null;
    String sex=null;
    String firstName=null;
    String lastName=null;
    public void LogedIn(){
        
    }
    
    public void setUsername(String name){
        this.Username=name;
    }
    public String getUsername(){
        return Username;
    }
    public String getEmail()
    {
    	return email;
    }
    public void setEmail(String value)
    {
    	this.email =value;
    }
    public String getFirstName()
    {
    	return firstName;
    }
    public void setFirstName(String value)
    {
    	this.firstName = value;
    }
    public String getLastName()
    {
    	return lastName;
    }
    public void setLastName(String value)
    {
    	this.lastName = value;
    }
    public String getSex()
    {
    	return sex;
    	
    }
    public void setSex(String value)
    {
    	this.sex = value;
    }
    
    public void setLogedin(){
        logedin=true;
    }
    public void setLogedout(){
        logedin=false;
    }
    
    public void setLoginState(boolean logedin){
        this.logedin=logedin;
    }
    public boolean getlogedin(){
        return logedin;
    }
}


