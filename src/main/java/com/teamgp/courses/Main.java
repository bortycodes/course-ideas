package com.teamgp.courses;

import static spark.Spark.get;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Main {
	public static void main(String[] args) {
		get("/hello", (req, res) -> "Hello World");
		
		get("/", (req, res) -> {
			return new ModelAndView(null, "index.hbs");
		}, new HandlebarsTemplateEngine());
	}
}
