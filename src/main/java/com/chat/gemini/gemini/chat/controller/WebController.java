package com.chat.gemini.gemini.chat.controller;

import org.springframework.stereotype.Controller;

@Controller
public class WebController {

    public String index() {
        return "index"; // Mengembalikan nama view yang akan dirender
    }

}
