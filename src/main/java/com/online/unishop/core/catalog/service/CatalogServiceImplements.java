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
public class CatalogServiceImplements implements CatalogService{

    private final CatalogModelRepository catalogModelRepository;

    @Override
    public void addNewCatalog(String name) {
        catalogModelRepository.save(
                new CatalogModel(
                        null,
                        name
                )
        );
    }

    @Override
    public List<CatalogDto> getAllCatalog() {
        return catalogModelRepository
                .findAll()
                .stream()
                .map(CatalogModel::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CatalogDto getCatalogById(Long id) {
        return catalogModelRepository
                .findById(id)
                .orElseThrow()
                .toDto();
    }

    @Override
    public void updateCatalog(Long id, String name) {
        CatalogModel updatedCatalogModel = catalogModelRepository
                .findById(id)
                .orElseThrow();

        updatedCatalogModel.setName(name);

        catalogModelRepository.save(updatedCatalogModel);
    }
}
