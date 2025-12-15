package kommand.entrypoint

import kommand.KommandDSLElement
import kommand.Kommand
import kommand.syntax.SyntaxBinding
import kommand.syntax.Syntax
import kommand.syntax.SyntaxExecutor
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class KommandDSLEntrypoint(private val builder: Builder): ReadOnlyProperty<Any?, Kommand> {
	override fun getValue(thisRef: Any?, property: KProperty<*>): Kommand =
		builder.build(property.name)

	class Builder : KommandDSLElement {
		var description: String = ""
		var aliases = listOf<String>()
		val syntaxes = mutableListOf<SyntaxBinding<*>>()

		operator fun String.div(other: String) =
			listOf(this) + other

		operator fun List<String>.div(other: String) =
			this + other

		infix fun <S: Syntax> S.executes(executor: SyntaxExecutor<S>) {
			syntaxes += SyntaxBinding(this, executor)
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

fun kommand(init: KommandDSLEntrypoint.Builder.() -> Unit) =
	KommandDSLEntrypoint(KommandDSLEntrypoint.Builder().apply(init))