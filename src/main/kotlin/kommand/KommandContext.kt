package kommand

data class KommandContext(private val args: Map<String, Any>) {
	@Suppress("UNCHECKED_CAST")
	fun <T> get(argument: String): T = args[argument] as T
}