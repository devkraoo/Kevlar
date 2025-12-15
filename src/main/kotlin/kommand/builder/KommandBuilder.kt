package kommand.builder

import kommand.dsl.KommandDSLElement
import kommand.syntax.ExecutableSyntax
import kommand.syntax.Syntax
import kommand.syntax.SyntaxExecutor
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class KommandBuilder(private val builder: Builder): ReadOnlyProperty<Any?, Kommand> {
	override fun getValue(thisRef: Any?, property: KProperty<*>): Kommand =
		builder.build(property.name)

	class Builder : KommandDSLElement {
		var description: String = ""
		var aliases = listOf<String>()
		val syntaxes = mutableListOf<ExecutableSyntax<*>>()

		infix fun <S: Syntax> S.executes(executor: SyntaxExecutor<S>) {
			syntaxes += ExecutableSyntax(this, executor)
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