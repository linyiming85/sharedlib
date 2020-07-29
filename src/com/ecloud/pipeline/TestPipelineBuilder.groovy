package com.ecloud.pipeline

import com.ecloud.context.Context

class  TestPipelineBuilder implements PipelineBuilder {
    @Override
    void build(Context context) {
        println("hello world for sharedlib")
    }
}