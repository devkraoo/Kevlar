package kommand.builder

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class KommandDelegate(val name: String, val kommand: Kommand): ReadOnlyProperty<Any?, Kommand.Impl> {
	override fun getValue(thisRef: Any?, property: KProperty<*>): Kommand.Impl =
		kommand.impl
}