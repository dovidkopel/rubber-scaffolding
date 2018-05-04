package io.wizdumb.scaffolding.transformer.graph.reader

import io.wizdumb.scaffolding.transformer.graph.{DefaultEdge, DefaultVertex}

/**
  * Created by dkopel on 10/27/16.
  */
case class GraphReaderOpts(
    verticesRequireClass: Boolean = true,
    edgesRequireClass: Boolean = false,
    verticesDefaultClass: Class[_] = classOf[DefaultVertex],
    edgesDefaultClass: Class[_] = classOf[DefaultEdge]
)