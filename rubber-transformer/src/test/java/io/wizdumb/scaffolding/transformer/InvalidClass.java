package io.wizdumb.scaffolding.transformer;

import io.wizdumb.scaffolding.transformer.limitation.MaxLength;
import io.wizdumb.scaffolding.transformer.support.Limitation;
import io.wizdumb.scaffolding.transformer.support.Transformation;

/**
 * Created by dkopel on 11/22/16.
 */
public class InvalidClass {
    @Transformation(limits = {
        @Limitation(value=MaxLength.class, args={"10"}, classes={Integer.class})
    })
    private String invalid;

    public String getInvalid() {
        return invalid;
    }
}
