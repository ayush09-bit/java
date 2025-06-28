package com.honey.demojpa;



import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("aliens")
public class AlienResourse {
	
	AlienReposiory repo = new AlienReposiory();
	
	@GET
	 @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})     //.APPLICATION_JSON)
	public List<Alien> getresourse()
	{
		
		return repo.getAliens();
	}
	
	
	@GET
	@Path("alien/{id}")
	 @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})    // this is called content negotiation the server send data according to user preference
	public Alien getresourses(@PathParam ("id") int id)
	{
		
		return repo.getAlien(id);
	}
	
	
	@POST
	@Path("alien")  // to access this -> aliens/alien
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien createrepo(Alien a)
	{   System.out.println(a);
		repo.create(a);
		return a;
	}
	
	
	@DELETE
	@Path("alien/{id}")
	public Alien KillAlien(@PathParam("id") int id)
	{
		Alien a = repo.getAlien(id);
		if(a.getAge() != 0)
		 repo.delete(id);
		return a;
		
	}
	
	
	
	
	
	
	
	
	
	
	
//	public List<Alien> getresourse()
//	{
//		Alien a1 = new Alien();
//		a1.setName("ayush");
//		a1.setAge(20);
//		
//		Alien a2 = new Alien();
//		a2.setName("ayush chaudhary");
//		a2.setAge(21);
//		
//		List<Alien> aliens = Arrays.asList(a1,a2);
//		
//		return aliens;
//	}
	
	

}
