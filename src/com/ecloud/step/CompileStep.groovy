package com.ecloud.step

import com.ecloud.context.Context

class CompileStep extends MavenStep {
  @Override
  void process(Context context) {
    echo(context, "compile application")

    withMaven(context) {
      context.jenkins.sh 'mvn -B clean compile'
    }
  }
}
