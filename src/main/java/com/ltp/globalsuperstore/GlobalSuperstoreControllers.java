package com.ltp.globalsuperstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GlobalSuperstoreControllers {

    private List<Item> items = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model){
       model.addAttribute("CATEGORIES",Constants.CATEGORIES);
       model.addAttribute("item",new Item());
       return "form";
   }
   @GetMapping("/inventory")
    public String getInventory(Model model){

        model.addAttribute("items", items);
       return "inventory";
   }

    @PostMapping("/handlesubmit")
    public String submitForm(Item item){
        System.out.println("here");
        items.add(item);
        System.out.println(items.toString());

    return "redirect:/inventory";
   }
}

