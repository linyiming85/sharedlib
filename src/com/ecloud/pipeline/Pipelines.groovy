package com.ecloud.pipeline

import com.ecloud.context.Context

class Pipelines {
  static def buildCommonPipeline(jenkins, Map pipelineParameters) {
    Context context = new Context(jenkins, pipelineParameters)

    //new DefaultPipelineBuilder().build(context)
    println "hello pipe"
    new TestPipelineBuilder().build(context)
  }
}
