/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className ActiveUserStore.java
   @created 19-Oct-2020
 */
public class ActiveUserStore {
	 public List<String> users;
	 
	    public ActiveUserStore() {
	        users = new ArrayList<String>();
	    }

		public List<String> getUsers() {
			return users;
		}

		public void setUsers(List<String> users) {
			this.users = users;
		}
	    
}
