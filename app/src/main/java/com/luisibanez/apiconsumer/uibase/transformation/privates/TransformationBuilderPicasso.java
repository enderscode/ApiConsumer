package com.luisibanez.apiconsumer.uibase.transformation.privates;

import com.luisibanez.apiconsumer.uibase.transformation.TransformationBuilder;
import com.squareup.picasso.Transformation;

import javax.inject.Inject;

public class TransformationBuilderPicasso implements TransformationBuilder {

    @Inject
    public TransformationBuilderPicasso(){

    }
    public Transformation createAvatarTransformation(){
       return new RoundAvatarTransformation();
    }
}
