package com.online.unishop.core.catalog.service;

import com.online.unishop.core.catalog.dto.CatalogDto;
import com.online.unishop.core.catalog.model.CatalogModel;
import com.online.unishop.core.catalog.model.CatalogModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogServiceImplements implements CatalogService {

    private final CatalogModelRepository catalogModelRepository;

    @Override
    public CatalogDto addNewCatalog(String name) {
        return catalogModelRepository.save(
                new CatalogModel(
                        null,
                        name
                )
        ).toDto();
    }

    @Override
    public List<CatalogDto> getAllCatalogByIds(List<Long> ids) {
        return catalogModelRepository
                .findAllByIdIn(ids)
                .stream()
                .map(CatalogModel::toDto)
                .toList();
    }

    @Override
    public List<CatalogDto> getAllCatalogs(){
        return catalogModelRepository.findAll()
                .stream()
                .map(CatalogModel::toDto)
                .toList();
    }

    @Override
    public CatalogDto getCatalogById(Long id) {
        return catalogModelRepository
                .findById(id)
                .orElseThrow()
                .toDto();
    }

    @Override
    public CatalogDto getCatalogByName(String name){ /* здесь мы ищем в бд каталог по имени и ставим доп условие,
    Если у каталога name==null то верни просто null,если нет то пусть catalogModel запишет себе name ДТО */
        CatalogModel catalogModel=  catalogModelRepository.findCatalogByName(name);

        return catalogModel == null ? null: catalogModel.toDto();
    }

    @Override
    public void updateCatalog(Long id, String name) {
        CatalogModel updatedCatalogModel = catalogModelRepository
                .findById(id)
                .orElseThrow();

        updatedCatalogModel.setName(name);

        catalogModelRepository.save(updatedCatalogModel);
    }

    @Override
    public void deleteCatalog(Long id){
        catalogModelRepository.deleteById(id);
    }
}
