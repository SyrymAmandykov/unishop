package com.online.unishop.web.tovar;

import com.online.unishop.core.tovar.service.TovarService;
import com.online.unishop.useCase.tovar.add.AddTovar;
import com.online.unishop.useCase.tovar.add.AddTovarInput;
import com.online.unishop.useCase.tovar.delete.DeleteTovar;
import com.online.unishop.useCase.tovar.delete.DeleteTovarInput;
import com.online.unishop.useCase.tovar.update.UpdateTovar;
import com.online.unishop.useCase.tovar.update.UpdateTovarInput;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tovary")
@RequiredArgsConstructor
public class TovarController {

    private final AddTovar addTovar;
    private final UpdateTovar updateTovar;
    private final DeleteTovar deleteTovar;

    private final TovarService tovarService;


    @GetMapping("")
    public String getAllTovars(Model model) {
        model.addAttribute("all_tovars", tovarService.getAllTovars());
        return "tovary";
    }

    @GetMapping("/{tovarId}")
    public String getTovarById(
            @PathVariable("tovarId") Long tovarId,
            Model model
    ) {
        model.addAttribute("tovar_Id",tovarService.getTovarById(tovarId));
        return "tovarDetails";
    }


    @PostMapping("")
    public String addTovar(
            HttpSession httpSession,
            @RequestParam("tovar_name") String name,
            @RequestParam("tovar_description") String description,
            @RequestParam("tovar_price") Double price,
            @RequestParam("tovar_catalogs") List<Long> catalaogIds,
            @RequestParam("tovar_filter") Long filterId
    ) {

        Long userId = (Long) httpSession.getAttribute("current_user");

        addTovar.handle(new AddTovarInput(
                        name,
                        description,
                        price,
                        catalaogIds,
                        filterId,
                        userId
                )
        );
        return "redirect:/tovary";

    }

    @PostMapping("/{tovarId}/update")
    public String updateTovar(
            @RequestParam("tovarId") Long updateTovarId,
            @RequestParam("tovar_name") String updateName,
            @RequestParam("tovar_description") String updateDescription,
            @RequestParam("tovar_price") Double updatePrice,
            @RequestParam("tovar_catalogIds") List<Long> updateCatalogIds,
            @RequestParam("tovar_filterId") Long updateFilterId
    ){
        updateTovar.handle(new UpdateTovarInput(
                updateTovarId,
                updateName,
                updateDescription,
                updatePrice,
                updateCatalogIds,
                updateFilterId
        ));
        return "redirect:/tovaryDetails";
    }

    @PostMapping("/{tovarId}/delete")
    public String deleteTovar(
            @PathVariable("tovarId") Long tovarId
    ) {
        deleteTovar.handle(new DeleteTovarInput(tovarId));
        return "redirect:/tovary";
    }



}
