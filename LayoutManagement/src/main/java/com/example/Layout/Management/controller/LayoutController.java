package com.example.Layout.Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Layout.Management.service.LayoutService;
import com.example.Layout.Management.dto.AssignLayoutRequest;
import com.example.Layout.Management.dto.Layout;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/layouts")
@RequiredArgsConstructor
public class LayoutController {
	
	private  final LayoutService layoutService;
	
	 @Autowired  // Injecting LayoutService
	    public LayoutController(LayoutService layoutService) {
	        this.layoutService = layoutService;
	    }

    @GetMapping
    public ResponseEntity<List<Layout>> getLayouts() {
        return ResponseEntity.ok(layoutService.getAllLayouts());
    }

    @PostMapping("/assign")
    public ResponseEntity<String> assignLayout(@RequestBody AssignLayoutRequest request) {
        layoutService.assignLayoutToUser(request.getUserId(), request.getLayoutId());
        return ResponseEntity.ok("Layout assigned successfully");
    }

        
    @PutMapping("/update")
    public ResponseEntity<String> updateLayout(@RequestParam Long userId, @RequestParam Long layoutId) {
        layoutService.assignLayoutToUser(userId, layoutId);
        return ResponseEntity.ok("Layout updated successfully");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Layout> getUserLayout(@PathVariable Long userId) {
        return ResponseEntity.ok(layoutService.getUserLayout(userId));
    }

}
