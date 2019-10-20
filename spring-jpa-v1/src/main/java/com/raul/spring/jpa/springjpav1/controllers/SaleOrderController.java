package com.raul.spring.jpa.springjpav1.controllers;

import com.raul.spring.jpa.springjpav1.models.entity.Partner;
import com.raul.spring.jpa.springjpav1.models.entity.Product;
import com.raul.spring.jpa.springjpav1.models.entity.SaleOrder;
import com.raul.spring.jpa.springjpav1.models.service.IPartnerRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/saleorder")
@SessionAttributes("saleOrder") //with this the object saleOrder save into an session
public class SaleOrderController {

    @Autowired
    private IPartnerRepoService partnerRepoService;

    @GetMapping("/sale-order/{partnerId}")
    public String createSaleOrder(
            @PathVariable(value = "partnerId") Long partnerId,
            Map<String, Object> model,
            RedirectAttributes flash){
        Partner partner ;
        SaleOrder saleOrder ;
        try{
            partner = partnerRepoService.findOne(partnerId);
            if(partner == null) {
                flash.addFlashAttribute("error","The partner does not exist");
                return "redirect:/list";
            }

            saleOrder = new SaleOrder();
            saleOrder.setPartner(partner);

            model.put("saleOrder", saleOrder);
            model.put("title","Create a new sale order !");

        }catch (Exception e){
            e.printStackTrace();
            flash.addFlashAttribute("error",e.getMessage());
            return "redirect:/list";
        }

        return "/saleorder/new-sale-order";
    }

    @GetMapping(value="/charge-products/{term}", produces = {"application/json"})
    public @ResponseBody List<Product> chargeProducts(@PathVariable String term){
        return partnerRepoService.findByProductName(term);
    }

}
