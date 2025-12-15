package kommand.parser

sealed interface ParseResult {

	data class Success(
		val kommand: ParsedKommand
	) : ParseResult

	sealed interface Failure : ParseResult {
		val reason: Reason

		enum class Reason {
			NOT_ENOUGH_ARGUMENTS,
			TOO_MANY_ARGUMENTS,
			INVALID_ARGUMENT
		}
	}
}