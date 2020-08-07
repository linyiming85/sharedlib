package com.ecloud.devops.ci.pipeline

import com.ecloud.devops.ci.context.Context


class Pipelines {
  static def buildCommonPipeline(jenkins, Map pipelineParameters) {
    Context context = new Context(jenkins, pipelineParameters)
    String jobName=jenkins.env.JOB_NAME
    String jobType=getJobType(jobName)
    switch (jobType){
      case "verify":
            jenkins.echo "verifyci"
            new CCIPipelineBuilder().build(context)
      default:
            jenkins.echo "defaultci"
            new DefaultPipelineBuilder().build(context)
    }
  }

  static String getJobType(String jobName){
    String [] jobSplit=jobName.split("-");
    int jobSplitLength=jobSplit.length;
    String jobType=jobSplit[jobSplitLength-1]
    return jobType
  }
}
