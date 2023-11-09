package com.online.unishop.web.catalog;

import com.online.unishop.core.catalog.service.CatalogService;
import com.online.unishop.core.tovar.dto.TovarDto;
import com.online.unishop.core.tovar.service.TovarService;
import com.online.unishop.useCase.catalog.add.AddCatalog;
import com.online.unishop.useCase.catalog.add.AddCatalogInput;
import com.online.unishop.useCase.catalog.delete.DeleteCatalog;
import com.online.unishop.useCase.catalog.delete.DeleteCatalogInput;
import com.online.unishop.useCase.catalog.update.UpdateCatalog;
import com.online.unishop.useCase.catalog.update.UpdateCatalogInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final AddCatalog addCatalog;
    private final DeleteCatalog deleteCatalog;
    private final UpdateCatalog updateCatalog;

    private final TovarService tovarService;

    private final CatalogService catalogService;


    @GetMapping
    public String getAllCatalogs(Model model){
        model.addAttribute("catalogs",catalogService.getAllCatalogs());
        return "cacatalog";
    }

    @GetMapping("/{catalogId}/tovary")
    public String getAllTovaryByCatalogId( 
            @PathVariable("catalogId") Long catalogId,
            Model model
    ) {
        model.addAttribute("all_tovars", tovarService.getAllTovarsByCatalog(catalogId));
        return "tovary";
    }

    @PostMapping("")
    public String addCatalog(
            @RequestParam("catalog_name") String catalogName
            ){
        addCatalog.handle(new AddCatalogInput(catalogName));
        return "redirect:/tovary";
    }

    @PostMapping("/{catalogId}/delete")
    public String deleteCatalog(
            @PathVariable("catalogId") Long catalogId
    ) {
        deleteCatalog.handle(new DeleteCatalogInput(catalogId));
        return "redirect:/tovary";
    }

    @PostMapping("/{catalogId}/update")
    public String updateCatalog(
            @PathVariable("catalogId") Long catalogId,
            @RequestParam("catalogName") String catalogName
    ){
        updateCatalog.handle(new UpdateCatalogInput(catalogId,catalogName));
        return "redirect:/tovary";
    }
}
