package com.deep.test.spring.annotation.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author hudepin
 * @Description
 * @ClassName HelloWorldImportSelector
 * @create_date 2020.09.01 21:02
 * @since 1.2.0
 */
public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.deep.test.spring.annotation.enable.HelloWorldConfiguration"};
    }
}
