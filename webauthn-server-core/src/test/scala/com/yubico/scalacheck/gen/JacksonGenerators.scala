package com.yubico.scalacheck.gen

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode
import org.scalacheck.Arbitrary
import org.scalacheck.Arbitrary.arbitrary

import scala.collection.JavaConverters._


object JacksonGenerators {

  private def jsonFactory: JsonNodeFactory = JsonNodeFactory.instance
  implicit val arbitraryJsonNode: Arbitrary[JsonNode] = Arbitrary(arbitrary[String] map (value => jsonFactory.textNode(value)))
  implicit val arbitraryObjectNode: Arbitrary[ObjectNode] = Arbitrary(arbitrary[Map[String, _ <: JsonNode]] map (exts => { val o = jsonFactory.objectNode(); o.setAll(exts.asJava); o }))

}
