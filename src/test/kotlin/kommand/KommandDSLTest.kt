package kommand

import kommand.arguments.types.string
import kommand.builder.kommand
import kommand.syntax.Syntax
import kotlin.test.Test

class KommandDslTest {

	@Test
	fun `kommand DSL builds without throwing an exception`() {

		val fly by kommand {
			description = "nga"
			aliases = "hi" / "hi" / "e"

			object : Syntax() {
				val flag by string { description = "flag"; greedy = true }
				val text by string { }
			} executes {
				println("First Syntax: ${flag.value}, ${text.v}")
			}

			object : Syntax() {
				val flag by string { description = "flag"; greedy = true }
				val text by string { }
			} executes {
				println("First Syntax: ${flag.value}, ${text.v}")
			}
		}
	}
}