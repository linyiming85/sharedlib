package com.ecloud.pipeline

import com.ecloud.context.Context

class CCIPipelineBuilder implements   PipelineBuilder{
    @Override
    void build(Context context) {
        println("CCIPipelineBuilder")
    }
}
