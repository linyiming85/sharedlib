package com.ecloud.step

import com.ecloud.context.Context
import sun.tools.jstat.Closure

abstract class MavenStep extends AbstractStep {
  Closure withMaven(Context context, Closure cl) {
    context.jenkins.withDockerContainer(
        "image": mavenImageName(context),
        "args": mavenImageArgs(context)) {
      cl()
    }
  }

  String mavenImageName(Context context) {
    return context.pipelineParameters["maven.image.name"]
  }

  String mavenImageArgs(Context context) {
    return context.pipelineParameters["maven.image.args"]
  }
}
