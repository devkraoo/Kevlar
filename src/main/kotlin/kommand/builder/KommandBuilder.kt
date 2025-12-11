package kommand.builder

import kommand.syntax.ExecutableSyntax

class KommandBuilder(override val impl: Builder) : Kommand {
	class Builder: Kommand.Impl() {
		operator fun <E: ExecutableSyntax<*>> E.unaryPlus() {  }
	}
}

fun kommand(init: KommandBuilder.Builder.() -> Unit) =
	KommandBuilder(KommandBuilder.Builder().apply(init))