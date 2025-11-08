package kommand

import kommand.arguments.boolean
import kommand.arguments.string
import kommand.builder.kommand
import kommand.syntax.Syntax
import kommand.syntax.executes
import kotlin.test.Test

class KommandDslTest {

	@Test
	fun `kommand DSL builds without throwing an exception`() {

		val testCommand = kommand {
			name = "test"
			description = "nga"
			aliases = listOf("hi")

			+object : Syntax() {
				val flag by string { }
				val text by string { }
			}
				.executes {
					println("First Syntax: $flag, $text")
				}

			+object : Syntax() {
				val flag by boolean { }
				val flag2 by boolean { default = true }
			}
				.executes {
					println("Second Syntax: $flag, $flag2")
				}
		}

	}
}