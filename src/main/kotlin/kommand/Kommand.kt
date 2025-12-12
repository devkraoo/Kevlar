package kommand

import kommand.syntax.ExecutableSyntax
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class Kommand(private val builder: Builder): ReadOnlyProperty<Any?, Kommand.Impl> {
	override fun getValue(thisRef: Any?, property: KProperty<*>): Impl =
		builder.build(property.name)

	data class Impl(
		val name: String,
		val description: String,
		val aliases: List<String>
	)

	class Builder {
		var description: String = ""
		var aliases = listOf<String>()

		operator fun <E: ExecutableSyntax<*>> E.unaryPlus() {  }

		internal fun build(name: String) =
			Impl(
				name,
				description,
				aliases
			)
	}
}

fun kommand(init: Kommand.Builder.() -> Unit) =
	Kommand(Kommand.Builder().apply(init))