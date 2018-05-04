package io.wizdumb.scaffolding.random.predicate

import java.util.UUID

import io.wizdumb.scaffolding.config.Configuration
import io.wizdumb.scaffolding.random.core.JavaPrimitives
import io.wizdumb.scaffolding.random.types.TypeContainer
import io.wizdumb.scaffolding.utils.Logging

/**
  * Created by dkopel on 12/6/16.
  */
trait PredicateRegistry extends Logging {this: JavaPrimitives =>
    val _predicates: collection.mutable.Map[PredicateType, Set[RandomPredicate[_]]]

    def predicates = _predicates.values.flatten

    def registerCustomPredicate(pred: RandomPredicate[_]) = registerPredicate(CustomPredicate, pred)

    private[random] def registerPredicate[T](predicateType: PredicateType, pred: RandomPredicate[T]) = {
        _predicates(predicateType) = _predicates(predicateType) + pred
    }

    def deregisterPredicate(predicateType: PredicateType, pred: RandomPredicate[_]) = {
        _predicates(predicateType) = _predicates(predicateType) - pred
    }

    def deregisterPredicate(predicateType: PredicateType, id: UUID) = {
        val pred = _predicates(predicateType).find(p => p.id.equals(id))
        if(pred.isDefined) {
            _predicates(predicateType) = _predicates(predicateType) - pred.get
        }
    }

    def findPredicates[T](typeContainer: TypeContainer[T], types: Set[PredicateType]=_predicates.keys.toSet)(implicit conf: Configuration, javaPrimitives: JavaPrimitives): List[RandomPredicate[_]] = {
        _predicates.filterKeys(types.contains)
            .values
            .flatten
            .asInstanceOf[Seq[RandomPredicate[_]]]
            .filter(p => p(RandomContext(
                typeContainer
            )(conf, javaPrimitives)))
            .toList
            .sorted
    }

    def findAndApplyPredicate[T](typeContainer: TypeContainer[T])(implicit javaPrimitives: JavaPrimitives, configuration: Configuration): Option[T] = {
        val preds = findPredicates(typeContainer)
        logger.debug("Found {} predicates", preds.size)
        val tc = TypeContainer[T](typeContainer.clazz, typeContainer.ptc)(configuration)
        if(preds.nonEmpty) {
            val v = preds.head.action.apply(
                RandomContext(tc)(configuration, javaPrimitives)
            ).asInstanceOf[T]
            typeContainer(v)
            Some(v)
        } else {
            Option.empty
        }
    }
}
