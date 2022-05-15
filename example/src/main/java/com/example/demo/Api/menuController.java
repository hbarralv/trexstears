package com.example.demo.Api;

import java.util.List;

import com.example.demo.menus.menu;
import com.example.demo.menus.menuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class menuController {

  @Autowired
  private menuRepository menusRepository;

  @GetMapping("/menus")
  public List<menu> listMenus(Model model) {
    return menusRepository.findAll();
  }


	@RequestMapping(method = RequestMethod.GET, value = "/menus/{menusId}")
    public menu findOne(@PathVariable Long menusId) {
        return menusRepository.findOne(menusId);
    }
//
//	@RequestMapping(method = RequestMethod.POST)
//    public menus add(@RequestBody menus menus) {
//        return menusRepository.save(menus);
//    }
//
//	@RequestMapping(method = RequestMethod.PUT)
//    public menus update(@RequestBody menus menus) {
//        return menusRepository.save(menus);
//    }

  @RequestMapping(method = RequestMethod.DELETE, value = "/borrarmenu/{menusId}")
  public void delete(@PathVariable Long menusId) {
    menusRepository.delete(menusId);
  }

}