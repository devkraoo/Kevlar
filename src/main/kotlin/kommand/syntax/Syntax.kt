package kommand.syntax

import kommand.KommandContext
import kommand.arguments.ArgumentDelegate
import kommand.arguments.Arguments

class Syntax<A: Arguments> internal constructor(
	private val holder: A
) {
	val arguments = holder.delegates

	fun execute(executor: ArgumentExecutor<A>, context: KommandContext) = with(context) {
		holder.executor()
	}
}