package com.ltp.globalsuperstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GlobalSuperstoreControllers {

    private List<Item> items = new ArrayList<>();

    private int getItemIndex(String id){
        // this method will getItemIndex using the Id of the item passed

        for(int i= 0;i<items.size();i++){
            if(items.get(i).getId().equals(id)) {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id){

        // this set index to not found constant when it comes without an id
        int index= id==null?Constants.NOT_FOUND:getItemIndex(id);
        //this sends categories from constants to select category element
        model.addAttribute("CATEGORIES",Constants.CATEGORIES);
       model.addAttribute("item",(index == Constants.NOT_FOUND) ? new Item() : items.get(index));
       return "form";
   }
   @GetMapping("/inventory")
    public String getInventory(Model model){

        model.addAttribute("items", items);
       return "inventory";
   }

    @PostMapping("/handlesubmit")
    public String submitForm(Item item, RedirectAttributes redirectAttributes){
            int index = getItemIndex(item.getId());
        if(index==Constants.NOT_FOUND){
            items.add(item);
            redirectAttributes.addFlashAttribute("message",true);
        }else{
            items.set(index,item);
            redirectAttributes.addFlashAttribute("message",true);
        }


    return "redirect:/inventory";
   }
}

