package com.teamgp.courses;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

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
	}
}
