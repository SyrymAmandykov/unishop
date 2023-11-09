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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TovarServiceImplements implements TovarService {

    private final TovarModelRepository tovarModelRepository;
    private final CatalogModelRepository catalogModelRepository;
    private final FilterModelRepository filterModelRepository;
    private final UsersModelRepository usersModelRepository;

    @Override
    public TovarDto addNewTovar(String name, String description, Double price,
                            List<Long> catalogIds, Long filterId, Long userId) {

        List<CatalogModel> catalogModel = catalogModelRepository.findAllByIdIn(catalogIds);
        FilterModel filterModel = filterModelRepository.findById(filterId)
                .orElseThrow();
        UsersModel usersModel = usersModelRepository.findById(userId)
                .orElseThrow();

       return tovarModelRepository.save(
                new TovarModel(
                        null,
                        name,
                        description,
                        price,
                        catalogModel,
                        filterModel,
                        usersModel
                )
        ).toDto();
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

    @Override
    public List<TovarDto> getAllTovarsByCatalog(Long catalogId){
        CatalogModel catalogModel = catalogModelRepository.findById(catalogId)
                .orElseThrow();

        ArrayList<CatalogModel> catalogModels = new ArrayList<>();
        catalogModels.add(catalogModel);
        return tovarModelRepository.findAllByCatalogModel(catalogModels)
                .stream()
                .map(TovarModel::toDto)
                .toList();
    }

    @Override
    public void updateTovar(Long id, String name, String description, Double price,
                            List<Long> catalogId, Long filterId) {

        TovarModel updatedTovarModel = tovarModelRepository.findById(id)
                .orElseThrow();
        List<CatalogModel> updatedCatalogModel = catalogModelRepository.findAllByIdIn(catalogId);
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
