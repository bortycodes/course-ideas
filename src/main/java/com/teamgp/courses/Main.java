package com.teamgp.courses;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import java.util.HashMap;
import java.util.Map;

import com.teamgp.courses.model.CourseIdea;
import com.teamgp.courses.model.CourseIdeaDAO;
import com.teamgp.courses.model.SimpleCourseIdeaDAO;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Main {
	public static void main(String[] args) {
		staticFileLocation("/public");
		
		CourseIdeaDAO dao = new SimpleCourseIdeaDAO();
		
		get("/hello", (req, res) -> "Hello World");
		
		get("/", (req, res) -> {
			Map<String, String> model = new HashMap<>();
			model.put("username", req.cookie("username"));
			return new ModelAndView(model, "index.hbs");
		}, new HandlebarsTemplateEngine());
		
		post("/sign-in", (req, res) -> {
			Map<String, String> model = new HashMap<>();
			String username = req.queryParams("username");
			res.cookie("username", username);
			model.put("username", username);
			return new ModelAndView(model, "sign-in.hbs");
		}, new HandlebarsTemplateEngine());
		
		get("/ideas", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("ideas", dao.findAll());
			return new ModelAndView(model, "ideas.hbs");
		}, new HandlebarsTemplateEngine());
		
		post("/ideas", (req, res) -> {
			String title = req.queryParams("title");
			//TO DO: This username is tied to the cookie implementation
			CourseIdea idea = new CourseIdea(title, req.cookie("username"));
			dao.add(idea);
			res.redirect("/ideas");
			return null;
		});
	}
}
