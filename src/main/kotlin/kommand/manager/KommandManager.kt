package kommand.manager

import kommand.Kommand
import kommand.exceptions.UnknownKommand
import kommand.parser.KommandParser
import kommand.parser.ParseAttempt

object KommandManager {
	private val kommands = HashMap<String, Kommand>()

	fun register(kommand: Kommand) {
		kommands[kommand.name] = kommand

		kommand.aliases.forEach {
			kommands[it] = kommand
		}

	}

	fun find(name: String): Kommand =
		kommands[name] ?: throw UnknownKommand("Command '$name' not found")

	fun execute(input: String) {
		when (val kommand = KommandParser.parse(input)) {
			is ParseAttempt.Valid -> kommand.parsed.execute()
			is ParseAttempt.Invalid -> throw UnknownKommand("Invalid detailed command")
		}
	}

}