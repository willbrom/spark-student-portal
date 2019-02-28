package com.willbrom.spark.example;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        get("/hello/:name", (request, response) -> request.params("name"));

        get("/", (request, response) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", request.cookie("username"));

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sign-in", ((request, response) -> {
            Map<String, String> model = new HashMap<>();

            String username = request.queryParams("username");
            response.cookie("username", username);
            model.put("username", username);

            return new ModelAndView(model, "sign-in.hbs");
        }), new HandlebarsTemplateEngine());
    }
}
