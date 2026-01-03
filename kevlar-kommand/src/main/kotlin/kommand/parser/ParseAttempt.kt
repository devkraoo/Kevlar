package kommand.parser

sealed interface ParseAttempt {
	data class Valid(
		val parsed: ParsedCommand<*>
	) : ParseAttempt

	data class Invalid(
		val reason: String
	) : ParseAttempt
}