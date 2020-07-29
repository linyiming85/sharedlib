package com.ecloud.step

import com.ecloud.context.Context

class InitBuildStep extends AbstractStep {
  @Override
  void process(Context context) {
    echo(context, "Init build")

    printParameters(context)

    context.jenkins.checkout context.jenkins.scm
  }
}
