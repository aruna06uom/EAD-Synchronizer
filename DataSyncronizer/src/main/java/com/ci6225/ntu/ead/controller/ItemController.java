package com.ci6225.ntu.ead.controller;

import com.ci6225.ntu.ead.model.ExpiredItem;
import com.ci6225.ntu.ead.service.ItemService;
import com.ci6225.ntu.ead.service.HibernateSearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private HibernateSearchService searchservice;

    @Autowired
    private ItemService cardservice;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String search(@RequestParam(value = "search", required = false) String q, Model model) {
        List<ExpiredItem> searchResults = null;
        try {
            cardservice.syncDbDetails();
            searchResults = searchservice.fuzzySearch(q);

        } catch (Exception ex) {
        }
        model.addAttribute("search", searchResults);
        return "index";

    }
    
    

}
