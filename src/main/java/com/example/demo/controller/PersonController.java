package com.example.demo.controller;

import com.example.demo.dao.PersonDao;
import com.example.demo.util.ThreadPoolUtil;
import com.example.demo.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@RestController
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @GetMapping(value = "/queryInfo")
    public Person queryOneById(@RequestParam("id") Integer id) {
        Person person = personDao.findById(id).orElse(null);
        return person;
    }

    @GetMapping(value = "/queryInfo1/{id}")
    public Person queryOneById1(@PathVariable("id") Integer id) {
        Person person = personDao.findById(id).orElse(null);
        return person;
    }

    @PostMapping(value = "/createPerson")
    public Person insertPerson(@RequestParam String name) {
        Person person = new Person();
        person.setName(name);
        return personDao.save(person);
    }

    /**
     * 参数传对象
     *
     * @param person
     * @returncc
     */
    @PostMapping(value = "/createPerson1")
    public Person insertPerson2(@RequestBody Person person) {
        return personDao.save(person);
    }


    @PostMapping(value = "/createPerson2")
    public Person insertPerson3(@RequestBody Map map) {
        Person person = new Person();
        person.setName((String) map.get("name"));
        return personDao.save(person);
    }



}
