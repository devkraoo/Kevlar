package kommand.builder

import kommand.syntax.ExecutableSyntax

class KommandBuilder(val builder: Builder) : Kommand {

	context(name: String)
	override val impl: Kommand.Impl
		get() = builder.build(name)

	class Builder {
		var description: String = ""
		var aliases = listOf<String>()

		operator fun <E: ExecutableSyntax<*>> E.unaryPlus() {  }

		internal fun build(name: String) =
			Kommand.Impl(
				name,
				description,
				aliases
			)
	}
}

fun kommand(init: KommandBuilder.Builder.() -> Unit) =
	KommandBuilder(KommandBuilder.Builder().apply(init))