package no.dervis.jsonreverse

import arrow.optics.Lens
import arrow.optics.Optional
import arrow.optics.optics

interface Node
@optics data class StringNode(val value: String): Node { companion object }
@optics data class MapNode(val value: Map<String, Node>): Node { companion object }
@optics data class ListNode(val value: List<Node>): Node { companion object }
@optics data class IntNode(val value: Int): Node { companion object }

fun main(args: Array<String>) {

    val data = MapNode(
        mapOf("a" to ListNode(listOf(
            IntNode(1),
            MapNode(mapOf("b" to ListNode(listOf(
                IntNode(2),
                MapNode(mapOf("c" to StringNode("Hello,"))),
                MapNode(mapOf("c" to StringNode("world!")))
            )))))))
    )

    val mapVal: Optional<MapNode, Map<String, Node>> = MapNode.value
    val listVal: Optional<ListNode, List<Node>> = ListNode.value
    val intVal: Optional<IntNode, Int> = IntNode.value
    val stringVal: Optional<StringNode, String> = StringNode.value

    // val reversedString: Lens<MapNode, String> = // work in progress
}