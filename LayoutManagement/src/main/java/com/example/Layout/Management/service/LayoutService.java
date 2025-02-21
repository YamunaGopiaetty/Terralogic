package com.example.Layout.Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Layout.Management.dto.Layout;
import com.example.Layout.Management.dto.User;
import com.example.Layout.Management.dto.UserLayout;
import com.example.Layout.Management.repository.LayoutRepository;
import com.example.Layout.Management.repository.UserLayoutRepository;
import com.example.Layout.Management.repository.UserRepository;

@Service
public class LayoutService {
	
	  @Autowired
	  private  LayoutRepository layoutRepository ;
	
	   @Autowired
	   private   UserRepository userRepository;
	
	   @Autowired
	   private  UserLayoutRepository userLayoutRepository;

	    public List<Layout> getAllLayouts() {
	        return layoutRepository.findAll();
	    }

	    public void assignLayoutToUser(Long userId, Long layoutId) {
	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User not found"));
	        Layout layout = layoutRepository.findById(layoutId)
	                .orElseThrow(() -> new RuntimeException("Layout not found"));

	        UserLayout userLayout = userLayoutRepository.findByUser(user)
	                .orElse(new UserLayout());
	        userLayout.setUser(user);
	        userLayout.setLayout(layout);
	        
	        userLayoutRepository.save(userLayout);
	    }

	    public Layout getUserLayout(Long userId) {
	        User user = userRepository.findById
	        		(userId)
	                .orElseThrow(() -> new RuntimeException("User not found"));
	        return userLayoutRepository.findByUser(user)
	                .map(UserLayout::getLayout)
	                .orElseThrow(() -> new RuntimeException("No layout assigned"));
	    }
}

