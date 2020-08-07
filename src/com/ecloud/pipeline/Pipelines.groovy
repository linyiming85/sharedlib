package com.ecloud.pipeline

import com.ecloud.context.Context

class Pipelines {
  static def buildCommonPipeline(jenkins, Map pipelineParameters) {
    Context context = new Context(jenkins, pipelineParameters)
    String jobName=jenkins.evn.JOB_NAME
    String jobType=getJobType(jobName)
    switch (jobType){
      case jobType == "verify":
            println("verifyci")
            new CCIPipelineBuilder().build(context)
      default:
            println("defaultci")
            new DefaultPipelineBuilder().build(context)
    }
  }

  String getJobType(String jobName){
    String [] jobSplit=jobName.split("_");
    int jobSplitLength=jobSplit.length;
    String jobType=jobSplit[jobSplitLength-1]
    println("jobType==" + jobType)
    return jobType
  }
}
