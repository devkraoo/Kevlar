package kommand.builder

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

sealed interface Kommand: ReadOnlyProperty<Any?, Kommand.Impl> {
	override fun getValue(thisRef: Any?, property: KProperty<*>): Impl =
		with(property.name) { impl }

	context(_: String)
	val impl: Impl

	data class Impl(
		val name: String,
		val description: String,
		val aliases: List<String>
	)
}