package com.ecloud.devops.ci.step

import com.ecloud.devops.ci.context.Context


class CompileStep extends MavenStep {
  @Override
  void process(Context context) {
    echo(context, "compile application")

    withMaven(context) {
      context.jenkins.sh 'mvn -B clean compile'
    }
  }

}
