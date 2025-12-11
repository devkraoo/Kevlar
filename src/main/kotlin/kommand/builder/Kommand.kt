package kommand.builder

import kotlin.properties.PropertyDelegateProvider
import kotlin.reflect.KProperty

sealed interface Kommand: PropertyDelegateProvider<Any?, KommandDelegate> {
	override fun provideDelegate(thisRef: Any?, property: KProperty<*>): KommandDelegate =
		KommandDelegate(property.name, this)

	val impl: Impl

	abstract class Impl {
		context(property: KProperty<*>)
		val name: String
			get() = property.name
		var description: String? = null
		var aliases: List<String>? = null
	}
}