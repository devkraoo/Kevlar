package kommand.syntax

import kommand.KommandContext
import kommand.arguments.ArgumentDelegate
import kommand.arguments.Arguments

class Syntax<A: Arguments> internal constructor(
	private val arguments: A
) {
	val delegates: List<ArgumentDelegate<*>>
		get() = arguments.delegates

	fun execute(executor: ArgumentExecutor<A>, context: KommandContext) {
		with(context) { arguments.executor() }
	}
}