package com.ecloud.pipeline

import com.ecloud.context.Context

class  TestPipelineBuilder implements PipelineBuilder {

    @Override
    build(Context context){
        println("hello world")
    }
}