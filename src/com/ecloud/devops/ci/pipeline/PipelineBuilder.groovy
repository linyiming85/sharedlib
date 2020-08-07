package com.ecloud.devops.ci.pipeline

import com.ecloud.devops.ci.context.Context


interface PipelineBuilder {
  void build(Context context)
}