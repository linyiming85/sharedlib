import com.ecloud.pipeline.Pipelines

def call(Map params){
    Pipelines.buildCommonPipeline(this,params)
}