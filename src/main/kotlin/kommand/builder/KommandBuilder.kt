package kommand.builder

import kommand.syntax.ExecutableSyntax
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class KommandBuilder(private val builder: Builder): ReadOnlyProperty<Any?, Kommand> {
	override fun getValue(thisRef: Any?, property: KProperty<*>): Kommand =
		builder.build(property.name)

	class Builder {
		var description: String = ""
		var aliases = listOf<String>()

		operator fun <E: ExecutableSyntax<*>> E.unaryPlus() {  }
	}

	private fun Builder.build(name: String): Kommand =
		Kommand(
			name,
			description,
			aliases
		)
}

fun kommand(init: KommandBuilder.Builder.() -> Unit) =
	KommandBuilder(KommandBuilder.Builder().apply(init))