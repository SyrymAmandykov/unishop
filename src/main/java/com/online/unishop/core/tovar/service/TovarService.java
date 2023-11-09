package com.online.unishop.core.tovar.service;

import com.online.unishop.core.tovar.dto.TovarDto;

import java.util.List;

public interface TovarService {

        /* userId чтоб понимать какой именно пользователь добавляет товар
           filterId чтоб привязать товар к определенному фильтру
           catalogId чтоб привязать к определенному каталогу
        */

    TovarDto addNewTovar(String name, String description, Double price, List<Long> catalogIds, Long filterId, Long userId);

    List<TovarDto> getAllTovars();

    TovarDto getTovarById(Long id);

    List<TovarDto> getAllTovarsByCatalog(Long catalogId);

    void updateTovar(Long catalogId, String name, String description, Double price, List<Long> catalogIds, Long filterId);

    void deleteTovar(Long id);


}
