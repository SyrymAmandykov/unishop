package com.online.unishop.useCase.tovar.delete;

import com.online.unishop.core.tovar.service.TovarService;
import com.online.unishop.useCase.UseCaseAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteTovar extends UseCaseAbstract<DeleteTovarInput,Object> {

    private final TovarService tovarService;

    @Override
    protected Object doLogic(DeleteTovarInput deleteTovarInput){
        tovarService.deleteTovar(deleteTovarInput.getId());
        return null;
    }
}
