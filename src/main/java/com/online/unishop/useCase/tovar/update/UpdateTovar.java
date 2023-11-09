package com.online.unishop.useCase.tovar.update;

import com.online.unishop.core.tovar.dto.TovarDto;
import com.online.unishop.core.tovar.service.TovarService;
import com.online.unishop.core.user.dto.UsersDto;
import com.online.unishop.core.user.service.UsersService;
import com.online.unishop.useCase.UseCaseAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateTovar extends UseCaseAbstract<UpdateTovarInput,Object>{

    private final TovarService tovarService;

    @Override
    protected Object doLogic(UpdateTovarInput updateTovarInput){
        if (updateTovarInput.getUpdatedName().isEmpty() || updateTovarInput.getUpdatedDescription().isEmpty())
            throw new IllegalArgumentException("Invalid input data");

        TovarDto tovarId = tovarService.getTovarById(updateTovarInput.getId());

        tovarService.updateTovar(
                tovarId.getId(),
                updateTovarInput.getUpdatedName(),
                updateTovarInput.getUpdatedDescription(),
                updateTovarInput.getUpdatedPrice(),
                updateTovarInput.getCatalogIds(),
                updateTovarInput.getFilterIds()
        );
        return null;
    }
}
