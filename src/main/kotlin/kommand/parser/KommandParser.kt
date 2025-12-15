package kommand.parser

import kommand.KommandManager
import kommand.arguments.ArgumentDelegate
import kommand.builder.Kommand
import kommand.syntax.SyntaxBinding

object KommandParser {

	fun parse(input: String): SyntaxBinding<*> {
		val tokens = input.trim().split(Regex("\\s+"))

		val kommand = KommandManager.find(tokens[0].removePrefix("/"))
		val args = tokens.drop(1)

		return parse(kommand, args)
	}

	fun parse(kommand: Kommand, tokens: List<String>): SyntaxBinding<*> {

		kommand.syntaxes.forEach {

			try {
				return trySyntax(it, tokens)
			} catch(_: Exception) {
				return@forEach
			}

		}

		throw InvalidSyntax("Tokens $tokens don't match syntaxes.")
	}

	private fun trySyntax(syntax: SyntaxBinding<*>, tokens: List<String>): SyntaxBinding<*> {
		val arguments = syntax.scope.arguments

		val requiredArguments = arguments.filter {
			!it.config.optional && it.config.default == null
		}

		if (requiredArguments.size > tokens.size) {
			throw InvalidSyntax("Not enough arguments.")
		}

		if (arguments.size < tokens.size) {
			throw InvalidSyntax("Too many arguments.")
		}

		val parse = { arguments: List<ArgumentDelegate<*>> ->

			arguments
				.zip(tokens)
				.associate { (arg, token) ->
					arg.name to arg.parse(token)
				}

		}

		val parsedArguments = try {
			parse(arguments)
		} catch(_: Exception) {
			parse(requiredArguments)
		}

		val test = Result
		syntax.scope.context = CommandContext(parsedArguments)
		return syntax
	}

}