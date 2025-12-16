package kommand.arguments

sealed interface Argument<T> {
	val config: Config<T>

	abstract class Config<T> {
		var description: String? = null
		var optional: Boolean = false
		var default: T? = null
	}

	fun parse(token: String): T
}