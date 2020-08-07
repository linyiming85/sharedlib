package com.ecloud.devops.ci.step

import com.ecloud.devops.ci.context.Context

class IntegrationTestStep extends MavenStep {
  @Override
  void process(Context context) {
    echo(context, 'integration test')

    // TODO to be tested.
    withMaven(context) {
      try {
        context.jenkins.sh 'maven integration-test'
      } finally {
        context.jenkins.junit 'target/surefire-reports/TEST-*.xml'
      }
    }
  }

  @Override
  boolean preStep(Context context) {
    if (!super.preStep(context)) {
      return false
    }

    if (context.pipelineParameterBooleanValue("skipIntegrationTest")) {
      echo(context, 'Integration test is skipped by pipeline parameters')
      return false
    }

    return true
  }
}
