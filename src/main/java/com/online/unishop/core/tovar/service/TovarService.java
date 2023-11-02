package com.online.unishop.core.tovar.service;

import com.online.unishop.core.catalog.dto.CatalogDto;
import com.online.unishop.core.catalog.model.CatalogModel;
import com.online.unishop.core.tovar.dto.TovarDto;

import java.util.List;

public interface TovarService {

        /* userId чтоб понимать какой именно пользователь добавляет товар
           filterId чтоб привязать товар к определенному фильтру
           catalogId чтоб привязать к определенному каталогу
        */

        void addNewTovar(String name,String description,Double price,Long catalogId, Long filterId, Long userId);
        List<TovarDto> getAllTovars();
        TovarDto getTovarById(Long id);
        void updateTovar(String name, String description, Double price,Long catalogId, Long filterId);
        void deleteTovar(Long id);


}
