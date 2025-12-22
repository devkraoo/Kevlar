package kommand

import kommand.arguments.Arguments
import kommand.arguments.types.boolean
import kommand.arguments.types.string
import kommand.entrypoint.kommand
import kommand.manager.KommandManager
import kotlin.test.Test

class KommandDSLTest {

	@Test
	fun `kommand DSL builds without throwing an exception`() {

		val fly by kommand {
			description = "nga"
			aliases = "hi" / "hi" / "e"

			object : Arguments() {
				val flag by string { description = "flag"; greedy = true }
				val text by string { }
			} executes {
				println("First Syntax: ${flag.value}, ${text.v}")
			}

			object : Arguments() {
				val bool by boolean { description = "bool" }
			} executes {
				println("Second Syntax: ${bool.value}")
			}
		}

		KommandManager.register(fly)
		KommandManager.execute("/fly hello world")
	}
}