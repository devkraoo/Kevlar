package kommand.builder

import kommand.exceptions.KommandBuildException
import kommand.syntax.ExecutableSyntax

class KommandBuilder {
	var name: String? = null
	var description: String? = null
	var aliases: List<String>? = null

	operator fun <E: ExecutableSyntax<*>> E.unaryPlus() {  }

	fun build() =
		Kommand(
			name ?: throw KommandBuildException(""),
			description,
			aliases
		)
}

fun kommand(init: KommandBuilder.() -> Unit): Kommand =
	KommandBuilder().apply(init).build()