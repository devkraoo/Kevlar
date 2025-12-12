package kommand

import kommand.builder.Kommand
import kommand.exceptions.UnknownKommand
import kommand.parser.KommandParser

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
		val kommand = KommandParser.parse(input)
		kommand.execute()
	}

}