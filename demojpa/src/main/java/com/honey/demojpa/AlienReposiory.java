package com.honey.demojpa;


import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class AlienReposiory {
	
	Connection con;
	
	//List<Alien> aliens;
	
	public AlienReposiory() 
	{
		
		
		try {
			String url = "jdbc:mysql://localhost:3306/restapi";
			String user = "root";
			String pass = "2202901540041@#";
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		con =  DriverManager.getConnection(url,user,pass);
		}
		catch (Exception e){
			System.out.println(e);
		}
			
	}

	public List<Alien> getAliens() 
	{
		List<Alien> aliens = new ArrayList<>();
		
		String sql = "select * from restapitable";
		
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Alien a = new Alien();
				a.setName(rs.getString(1));
				a.setAge(rs.getInt(2));
				
				aliens.add(a);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return aliens;
	}
	
	
	
	public Alien getAlien(int id)
	{
		
		Alien a = new Alien();
		
		String sql = "select * from restapitable where age = "+id;
		
		
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				a.setName(rs.getString(1));
				a.setAge(rs.getInt(2));
				
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		return a;
		
	}

	
	public void create(Alien a) {
		
		
		String sql = "insert into restapitable(name,age) values(?,?)";
		
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,a.getName());
			st.setInt(2, a.getAge());
			
			st.executeUpdate();	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		
	}
	
	public void delete(int age)
	{
		String sql = "delete from restapitable where AGE = ?" ;
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, age);
			
			st.executeUpdate();	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
//	aliens = new ArrayList<>();
//	
//Alien a1 = new Alien();
//a1.setName("ayush");
//a1.setAge(20);
//
//Alien a2 = new Alien();
//a2.setName("ayush chaudhary");
//a2.setAge(21);
//
//Alien a3 = new Alien();
//a3.setName("honey");
//a3.setAge(21);
//
//aliens.add(a1);
//aliens.add(a2);
//aliens.add(a3);
//}
	

}
