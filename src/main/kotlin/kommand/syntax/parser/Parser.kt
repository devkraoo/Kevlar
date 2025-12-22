package kommand.syntax.parser

import kommand.KommandContext
import kommand.arguments.ArgumentDelegate
import kommand.syntax.Syntax

fun Syntax<*>.parse(tokens: List<String>): SyntaxAttempt {
	val requiredArguments = arguments.filter {
		!it.config.optional && it.config.default == null
	}

	if (arguments.size > tokens.size) {
		return SyntaxAttempt.Invalid("Too many arguments.")
	}

	val parsedArguments = runCatching { arguments.parse(tokens) }.onFailure { requiredArguments.parse(tokens) }.getOrNull()
	if (parsedArguments == null) {
		return SyntaxAttempt.Invalid("Too many arguments.")
	}

	val context = KommandContext(parsedArguments)
	return SyntaxAttempt.Valid(context)
}

fun List<ArgumentDelegate<*>>.parse(tokens: List<String>) =
	this
		.zip(tokens)
		.associate { (arg, token) ->
			arg to arg.parse(token)
		}