package ru.goga59.onlineshop.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactsController {

    @GetMapping("/contacts")
    public String goToContacts() {
        return "contacts";
    }

}
