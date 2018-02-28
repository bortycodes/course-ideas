package com.teamgp.courses;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Main {
	public static void main(String[] args) {
		get("/hello", (req, res) -> "Hello World");
		
		get("/", (req, res) -> {
			return new ModelAndView(null, "index.hbs");
		}, new HandlebarsTemplateEngine());
		
		post("/sign-in", (req, res) -> {
			Map<String, String> model = new HashMap<>();
			model.put("username", req.queryParams("username"));
			
			
			return new ModelAndView(model, "sign-in.hbs");
		}, new HandlebarsTemplateEngine());
	}
}
