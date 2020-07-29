package com.ecloud.pipeline

import com.ecloud.context.Context

interface PipelineBuilder {
  void build(Context context)
}