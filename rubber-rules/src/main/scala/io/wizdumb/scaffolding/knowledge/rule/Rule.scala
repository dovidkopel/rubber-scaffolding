package io.wizdumb.scaffolding.knowledge.rule

import java.util.UUID

import io.wizdumb.scaffolding.knowledge.KnowledgePackage
import io.wizdumb.scaffolding.knowledge.context.KnowledgeContext
import io.wizdumb.scaffolding.messaging.response.Response

/**
  * Created by dkopel on 19/05/16.
  */
trait Rule {
    val id: UUID
    val name: String
    def knowledgePackage: KnowledgePackage

    val positiveReactions: List[Function[KnowledgeContext, Response[_]]] = Nil
    val negativeReactions: List[Function[KnowledgeContext, Response[_]]] = Nil

    def precondition: Option[Rule] = Option.empty

    def evaluate(implicit kc: KnowledgeContext): Boolean
}