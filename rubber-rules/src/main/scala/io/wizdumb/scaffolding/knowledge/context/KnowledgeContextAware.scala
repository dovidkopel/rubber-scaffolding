package io.wizdumb.scaffolding.knowledge.context

/**
  * Created by dkopel on 19/05/16.
  */
trait KnowledgeContextAware extends Serializable {
    def knowledgeContext: KnowledgeContext
}