package com.hcl.taskmanager.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.taskmanager.entities.EndUser;
import com.hcl.taskmanager.entities.Task;
import com.hcl.taskmanager.exceptions.UserNotFoundException;
import com.hcl.taskmanager.services.EndUserService;
import com.hcl.taskmanager.services.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private EndUserService endUserService;

	Logger logger = LoggerFactory.getLogger(TaskController.class);

	@PostMapping(value = "/createtasks")
	public String createTask(ModelMap model, @RequestParam("email") String email, @RequestParam("name") String name,
			@RequestParam("startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
			@RequestParam("description") String description, @RequestParam("severity") String severity) {
		// logger.info("About to register user");
		List<EndUser> resultList = endUserService.searchByEmail(email);
		EndUser theUser = resultList.get(0);
		Task newTask = new Task();
		newTask.setName(name);
		newTask.setDescription(description);
		newTask.setEmail(email);
		newTask.setStartDate(startDate);
		newTask.setEndDate(endDate);
		newTask.setSeverity(severity);
		newTask.setEndUser(theUser);
		taskService.saveTask(newTask);
		String result = "Task created!";
		model.addAttribute("message", result);
		return "createtask";
	}

	@GetMapping(value = "/display")
	public String displayTask(ModelMap model) {
		Iterable<Task> displayResult = taskService.getAllTasks();
		model.addAttribute("tasks", displayResult);
		return "displaytask";

	}

	@PostMapping(value = "/deletetasks")
	public String deleteTask(ModelMap model, @RequestParam("id") int id) {
		logger.info("Get id");
		Task displayResult = taskService.getTaskbyId(id);
		taskService.deleteTask(displayResult);
		String result = "Task Deleted!";
		model.addAttribute("message", result);

		return "deletetask";
	}

	@PostMapping(value = "updatetasks")
	public String updateTask(ModelMap model, @RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
			@RequestParam("description") String description, @RequestParam("severity") String severity) {
		logger.info("Get parameters");
		Task updateTask = taskService.getTaskbyId(id);
		logger.info("Setting values");
		updateTask.setDescription(description);
		updateTask.setStartDate(startDate);
		updateTask.setEndDate(endDate);
		updateTask.setName(name);
		updateTask.setSeverity(severity);
		taskService.saveTask(updateTask);
		logger.info("Values set");
		String result = "Task Updated!";
		model.addAttribute("message", result);
		return "updatetask";
	}

}
