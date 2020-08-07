package com.ecloud.devops.ci.pipeline

import com.ecloud.devops.ci.context.Context
import com.ecloud.devops.ci.step.BuildImageStep
import com.ecloud.devops.ci.step.CompileStep
import com.ecloud.devops.ci.step.InitBuildStep
import com.ecloud.devops.ci.step.IntegrationTestStep
import com.ecloud.devops.ci.step.PackageStep
import com.ecloud.devops.ci.step.UnitTestStep


class DefaultPipelineBuilder implements PipelineBuilder {
  @Override
  void build(Context context) {
    println("build")
    loadProperties(context)

    buildPipeline(context)
  }

  void loadProperties(Context context) {
    // Load default properties
    String propertiesString = context.jenkins.libraryResource(
        "com/ecloud/jenkins/pipeline/defaultPipeline.properties"
    )
    Properties properties = new Properties()
    properties.load(new StringReader(propertiesString))

    // Override default properties with passed in parameters
    if (context.pipelineParameters != null) {
      properties.putAll(context.pipelineParameters)
    }
    context.pipelineParameters = properties
  }

  void buildPipeline(Context context) {
    def jenkins = context.jenkins

    jenkins.node {
      jenkins.stage('init build') {
        new InitBuildStep().execute(context)
      }

      jenkins.stage('compile app') {
        new CompileStep().execute(context)
      }

      jenkins.stage('unit test') {
        new UnitTestStep().execute(context)
      }

      jenkins.stage('integration test') {
        new IntegrationTestStep().execute(context)
      }

      jenkins.stage('package') {
        new PackageStep().execute(context)
      }

      jenkins.stage('build image') {
        new BuildImageStep().execute(context)
      }
    }
  }
}
