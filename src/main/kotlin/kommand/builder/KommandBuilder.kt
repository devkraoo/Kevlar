package kommand.builder

import kommand.dsl.KommandDSLElement
import kommand.syntax.ExecutableSyntax
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class KommandBuilder(private val builder: Builder): ReadOnlyProperty<Any?, Kommand> {
	override fun getValue(thisRef: Any?, property: KProperty<*>): Kommand =
		builder.build(property.name)

	class Builder : KommandDSLElement {
		var description: String = ""
		var aliases = listOf<String>()
		val syntaxes = mutableListOf<ExecutableSyntax<*>>()

		operator fun <E: ExecutableSyntax<*>> E.unaryPlus() {
			syntaxes.add(this)
		}
	}

	private fun Builder.build(name: String): Kommand =
		Kommand(
			name,
			description,
			aliases,
			syntaxes
		)
}

fun kommand(init: KommandBuilder.Builder.() -> Unit) =
	KommandBuilder(KommandBuilder.Builder().apply(init))