package com.sqli.test.evelator.entities;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hamcrest.core.IsInstanceOf;

import com.sqli.test.evelator.State.StopedState;
import com.sqli.test.evelator.factory.FactoryEvelator;

/**
 * @author rout
 *
 * Nov 19, 2019
 * @param <Evelator>
 *
 * @project evelator
 */

public class Building {

	private int nombreflore;
	private List<Evelator> listevelators ;
	
	public Building(int Nombreflore, String ...idEvleator) {
		
		this.setNombreflore(Nombreflore);
		this.setListevelators(new LinkedList<>());
		addEvelators(idEvleator);
		
	}

	private void addEvelators(String[] idEvleator) {
		
		for (int i = 0; i < idEvleator.length; i++) {
			StringBuilder e  =new StringBuilder(idEvleator[i]);
			int flore = Integer.parseInt(e.charAt(e.length()-1)+"");
			String idev = e.substring(0,e.length()-2);
			Evelator evelator = new FactoryEvelator().getInstance(idev);
			evelator.setFlore(flore);
			
			this.listevelators.add(evelator);
			
		}		
		
	}

	public int getNombreflore() {
		return nombreflore;
	}

	public void setNombreflore(int nombreflore) {
		this.nombreflore = nombreflore;
	}

	public List<Evelator> getListevelators() {
		return listevelators;
	}

	public void setListevelators(List<Evelator> listevelators) {
		this.listevelators = listevelators;
	}

 /////////////////////////////////////////////////////////////////////	
	
	public String requestElevator() {
		
	      Evelator  ev =  null;
          int flore = 0;
          String idev = "walo";
		
          List<Evelator> listevstopped =  new LinkedList<>();
          listevstopped = listevelators.stream()
        		  .filter(e-> e.getState().toString().equals("stopped"))
        		  .collect(Collectors.toList());

          
          List<Evelator> listevup =  new LinkedList<>();
          listevup = listevelators.stream()
        		  .filter(e-> e.getState().toString().equals("up"))
        		  .collect(Collectors.toList());
          List<Evelator> listevdown =  new LinkedList<>();
          listevdown = listevelators.stream()
        		  .filter(e-> e.getState().toString().equals("down"))
        		  .collect(Collectors.toList());
//          System.out.println(listevstopped);
//           System.out.println(listevup);
//           System.out.println(listevdown);

       if(! listevstopped.isEmpty()) {
          
          ev =  listevstopped.get(0);
          flore = ev.getFlore();
          idev = ev.getId();
          
          for (Evelator evelator : listevstopped) {
			 if (evelator.getFlore()<flore ) {
				 ev = evelator;
			    flore = ev.getFlore();
			    idev = ev.getId();
			 }
          }
       }else {
				   if(! listevdown.isEmpty()) {
				       
				       ev =  listevdown.get(0);
				       flore = ev.getLastFlore();
				       idev = ev.getId();
				       for (Evelator evelator : listevdown) {
						 if (evelator.getLastFlore()<flore ) {
							 ev = evelator;
						       flore = ev.getLastFlore();
						    idev = ev.getId();
						 }
				      }
				        
		}else {
	          if(! listevup.isEmpty()) {
	              
	              ev =  listevup.get(0);
	              flore = ev.getLastFlore();
	              idev = ev.getId();
	              for (Evelator evelator : listevup) {
	        			 if (evelator.getLastFlore()>flore ) {
	        				 ev = evelator;
	  				       flore = ev.getLastFlore();
	        			    idev = ev.getId();
	        			 }
	        		}
	           }
		}
       
       }

             

		
		return idev;
	}

	public void move(String idev, String Derection) {
		// TODO Auto-generated method stub

		Evelator ev = serchEvelator(idev);
		
		if(ev != null) {

		if(Derection.equalsIgnoreCase("UP")) {
			ev.Up(10);
			}
		if(Derection.equalsIgnoreCase("DOWN")) {
			ev.Down(0);}
		}
	
	}

	
	public String requestElevator(int dest) {
		
	    Evelator  ev =  null;
        int flore = 0;
        String idev = "walo";
		
        List<Evelator> listevstopped =  new LinkedList<>();
        listevstopped = listevelators.stream()
      		  .filter(e-> e.getState().toString().equals("stopped"))
      		  .collect(Collectors.toList());

        
        List<Evelator> listevup =  new LinkedList<>();
        listevup = listevelators.stream()
      		  .filter(e-> e.getState().toString().equals("up"))
      		  .collect(Collectors.toList());
        List<Evelator> listevdown =  new LinkedList<>();
        listevdown = listevelators.stream()
      		  .filter(e-> e.getState().toString().equals("down"))
      		  .collect(Collectors.toList());


     if(! listevstopped.isEmpty()) {
        
        ev =  listevstopped.get(0);
        flore = (ev.getFlore() - dest)<0 ? -(ev.getFlore() - dest) : (ev.getFlore() - dest);
        idev = ev.getId();
        
        for (Evelator evelator : listevstopped) {
			 if ((evelator.getFlore()-dest)<flore ) {
				 ev = evelator;
			    flore = (ev.getFlore() - dest)<0 ? -(ev.getFlore() - dest) : (ev.getFlore() - dest);
			    idev = ev.getId();
			 }
        }
     }else {
				   if(! listevdown.isEmpty()) {
				       
				       ev =  listevdown.get(0);
				      flore = (ev.getLastFlore() - dest)<0 ? -(ev.getLastFlore() - dest) : (ev.getLastFlore() - dest);

				       idev = ev.getId();
				       for (Evelator evelator : listevdown) {
						 if (evelator.getLastFlore()<flore ) {
							 ev = evelator;
						      flore = (ev.getLastFlore() - dest)<0 ? -(ev.getLastFlore() - dest) : (ev.getLastFlore() - dest);
						    idev = ev.getId();
						 }
				      }
				        
		}else {
	          if(! listevup.isEmpty()) {
	              
	              ev =  listevup.get(0);
			      flore = (ev.getLastFlore() - dest)<0 ? -(ev.getLastFlore() - dest) : (ev.getLastFlore() - dest);
	              idev = ev.getId();
	              for (Evelator evelator : listevup) {
	        			 if (evelator.getLastFlore()>flore ) {
	        				 ev = evelator;
	   				      flore = (ev.getLastFlore() - dest)<0 ? -(ev.getLastFlore() - dest) : (ev.getLastFlore() - dest);
	        			    idev = ev.getId();
	        			 }
	        		}
	           }
		}
     
     }

           

		
		return idev;
	}
	
	public Evelator serchEvelator(String id) {
	    Evelator ev = listevelators.stream()
	    		.filter(e -> e.getId().equals(id))
	    		.findAny().orElse(null);
		return ev;
	}
	
}
