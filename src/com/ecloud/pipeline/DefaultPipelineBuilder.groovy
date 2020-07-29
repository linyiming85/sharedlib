package com.ecloud.pipeline

import com.ecloud.context.Context
import com.ecloud.step.BuildImageStep
import com.ecloud.step.CompileStep
import com.ecloud.step.InitBuildStep
import com.ecloud.step.IntegrationTestStep
import com.ecloud.step.PackageStep
import com.ecloud.step.UnitTestStep

class DefaultPipelineBuilder implements PipelineBuilder {
  @Override
  void build(Context context) {
    loadProperties(context)

    buildPipeline(context)
  }

  void loadProperties(Context context) {
    // Load default properties
    String propertiesString = context.jenkins.libraryResource(
        "com/notebook40/jenkins/pipeline/defaultPipeline.properties"
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
