package com.willbrom.spark.example;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/hello/:name", (request, response) -> request.params("name"));

        get("/", (request, response) -> new ModelAndView(null, "index.hbs"), new HandlebarsTemplateEngine());
    }
}
