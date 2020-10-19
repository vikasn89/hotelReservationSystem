/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.util;

import java.util.List;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.stereotype.Component;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className LoggedUser.java
   @created 19-Oct-2020
 */
@Component
public class LoggedUser implements HttpSessionBindingListener {
 
    private String username; 
    private ActiveUserStore activeUserStore;
    
    public LoggedUser(String username, ActiveUserStore activeUserStore) {
        this.username = username;
        this.activeUserStore = activeUserStore;
    }
    
    public LoggedUser() {}
 
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        List<String> users = activeUserStore.getUsers();
        LoggedUser user = (LoggedUser) event.getValue();
        if (!users.contains(user.getUsername())) {
            users.add(user.getUsername());
        }
    }
 
    /**
	 * @Param
	   @return
	 */
	private String getUsername() {
		return null;
	}

	@Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        List<String> users = activeUserStore.getUsers();
        LoggedUser user = (LoggedUser) event.getValue();
        if (users.contains(user.getUsername())) {
            users.remove(user.getUsername());
        }
	}
        public ActiveUserStore getActiveUserStore() {
        	return activeUserStore;
        }
        
        public void setActiveUserStore(ActiveUserStore activeUserStore) {
        	this.activeUserStore = activeUserStore;
        }
        
        public void setUsername(String username) {
        	this.username = username;
        }
        
    }

