package com.example.UserFeedback.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.services.FeedbackService;

@RestController
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;
	
	@PostMapping("/home")
	public Feedback addNewFeedback(@RequestParam("name") String name,@RequestParam("comment") String comment, @RequestParam("rating") int rating) {
		Feedback newFeedback= new Feedback();
		newFeedback.setName(name);
		newFeedback.setComment(comment);
		newFeedback.setRating(rating);
		feedbackService.addFeedback(newFeedback);
		return newFeedback; 
	}
}
