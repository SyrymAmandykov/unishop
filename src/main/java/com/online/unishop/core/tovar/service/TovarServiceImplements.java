package com.online.unishop.core.tovar.service;

import com.online.unishop.core.catalog.model.CatalogModel;
import com.online.unishop.core.catalog.model.CatalogModelRepository;
import com.online.unishop.core.filter.model.FilterModel;
import com.online.unishop.core.filter.model.FilterModelRepository;
import com.online.unishop.core.tovar.dto.TovarDto;
import com.online.unishop.core.tovar.model.TovarModel;
import com.online.unishop.core.tovar.model.TovarModelRepository;
import com.online.unishop.core.user.model.UsersModel;
import com.online.unishop.core.user.model.UsersModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TovarServiceImplements implements TovarService{

    private final TovarModelRepository tovarModelRepository;
    private final CatalogModelRepository catalogModelRepository;
    private final FilterModelRepository filterModelRepository;
    private final UsersModelRepository usersModelRepository;

    @Override
    public void addNewTovar(String name, String description, Double price, Long catalogId, Long filterId, Long userId) {

        List<CatalogModel> catalogModel = new ArrayList<>(); // TODO: 02.11.2023  Спросить правильно ли тут реализовано?!
        catalogModelRepository.findById(catalogId)
                .orElseThrow();
        FilterModel filterModel = filterModelRepository.findById(filterId)
                .orElseThrow();
        UsersModel usersModel = usersModelRepository.findById(userId)
                .orElseThrow();

        tovarModelRepository.save(
                new TovarModel(
                        null,
                        name,
                        description,
                        price,
                        catalogModel,
                        filterModel,
                        usersModel
                )
        );
    }

    @Override
    public List<TovarDto> getAllTovars() {
        return tovarModelRepository.findAll()
                .stream()
                .map(TovarModel::toDto)
                .toList();
    }

    @Override
    public TovarDto getTovarById(Long id) {
        return tovarModelRepository.findById(id)
                .orElseThrow()
                .toDto();
    }

    @Override // TODO: 02.11.2023  Узнать почему ошибка
    public void updateTovar(Long id,String name, String description, Double price, Long catalogId, Long filterId) {
        TovarModel updatedTovarModel = tovarModelRepository.findById(id)
                .orElseThrow();
        List<CatalogModel> updatedCatalogModel = new ArrayList<>();
                catalogModelRepository.findById(catalogId)
                .orElseThrow();
        FilterModel updatedFilterModel = filterModelRepository.findById(filterId)
                .orElseThrow();

        updatedTovarModel.setName(name);
        updatedTovarModel.setDescription(description);
        updatedTovarModel.setPrice(price);
        updatedTovarModel.setCatalogModel(updatedCatalogModel);
        updatedTovarModel.setFilterModel(updatedFilterModel);

        tovarModelRepository.save(
                updatedTovarModel
        );

    }

    @Override
    public void deleteTovar(Long id) {
        tovarModelRepository.deleteById(id);
    }
}
