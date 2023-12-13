package br.com.exemplo.demo.controller;

import br.com.exemplo.demo.domain.Person;

import br.com.exemplo.demo.producer.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public void sendPerson(@RequestBody Person person) {
        personService.sendPersonMessage(person);
    }

}

