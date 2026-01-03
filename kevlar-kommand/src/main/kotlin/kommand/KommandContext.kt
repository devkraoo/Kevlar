package kommand

import kommand.arguments.ArgumentDelegate

data class KommandContext(
	private val args: Map<ArgumentDelegate<*>, Any>
) {
	@Suppress("UNCHECKED_CAST")
	fun <T: Any> get(argument: ArgumentDelegate<T>): T = args[argument] as T
}