package PACKAGE

import java.util.UUID

import io.wizdumb.scaffolding.knowledge._
import io.wizdumb.scaffolding.knowledge.context._
import io.wizdumb.scaffolding.knowledge.rule._

class CLASSNAME(override val criteria: Map[String, CriteriaContainer]) extends CriteriaRule {
    override val id = UUID.randomUUID
    override val name = "CLASSNAME"
    override def knowledgePackage: KnowledgePackage = { null }

    override def evaluate(implicit kc: KnowledgeContext): Boolean = {
        require(kc!=null)
        try {
            CODE
        } catch {
            case e: IllegalArgumentException => throw new IllegalArgumentException
        }
    }
}