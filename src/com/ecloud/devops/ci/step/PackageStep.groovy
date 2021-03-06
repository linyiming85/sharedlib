package com.ecloud.devops.ci.step

import com.ecloud.devops.ci.context.Context


class PackageStep extends MavenStep {
  @Override
  void process(Context context) {
    echo(context, 'package')

    withMaven(context) {
      context.jenkins.sh 'mvn -B -DskipTests package'
      context.jenkins.archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    }
  }
}
