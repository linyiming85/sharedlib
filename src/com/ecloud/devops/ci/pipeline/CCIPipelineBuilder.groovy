package com.ecloud.devops.ci.pipeline

import com.ecloud.context.Context

class CCIPipelineBuilder implements   PipelineBuilder{
    @Override
    void build(Context context) {
        println("CCIPipelineBuilder")
    }
}
