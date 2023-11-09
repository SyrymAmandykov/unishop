package com.online.unishop.useCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class UseCaseAbstract<INPUT, OUTPUT> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    protected abstract OUTPUT doLogic(INPUT input);

    public final OUTPUT handle(INPUT input) { /* handle будет вызываться с контроллеров ,
    это нужно для уверенности что методы которые пройдут через handle обработуются без ошибки */
        try {
            logger.info("Executing use case with input" + input.toString());
            return doLogic(input); /* если ошибо нет то метод который придет с сервиса попадет в doLogic */
        } catch (Exception e) {
            logger.error("Failed to execute use case with input" + input.toString() + ", error message: " + e.getMessage(), e); /* если вылезит ошбика то логгер отобразит общую ошибку,
            а точечная будет обьявлена внутри самих методов*/
            throw e;
        }
    }

}
