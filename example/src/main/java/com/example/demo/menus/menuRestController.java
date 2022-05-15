package com.example.demo.menus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/menus")
public class menuRestController {

    @Autowired
    private menuRepository menusRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<menu> findAll() {
        return menusRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{menusId}")
    public menu findOne(@PathVariable Long menusId) {
        return menusRepository.findOne(menusId);
    }
//
//	@RequestMapping(method = RequestMethod.POST)
//    public menus add(@RequestBody menu menus) {
//        return menusRepository.save(menus);
//    }
//
//	@RequestMapping(method = RequestMethod.PUT)
//    public menus update(@RequestBody menus menus) {
//        return menusRepository.save(menus);
//    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{menusId}")
    public void delete(@PathVariable Long menusId) {
        menusRepository.delete(menusId);
    }
	
}

