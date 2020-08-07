import com.ecloud.devops.ci.pipeline.Pipelines

def call(Map params){
    Pipelines.buildCommonPipeline(this,params)
}