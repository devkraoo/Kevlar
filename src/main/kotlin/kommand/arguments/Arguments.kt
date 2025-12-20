package kommand.arguments

import kommand.KommandDSLElement
import kotlin.reflect.KProperty

abstract class Arguments : KommandDSLElement {
	operator fun <T: Any> Argument<T>.provideDelegate(thisRef: Arguments, property: KProperty<*>): ArgumentDelegate<T> {
		val delegate = ArgumentDelegate(property.name, this)
		register(delegate)

		return delegate
	}

	private val _delegates = mutableListOf<ArgumentDelegate<*>>()
	val delegates: List<ArgumentDelegate<*>>
		get() = _delegates.toList()

	private fun register(arg: ArgumentDelegate<*>) {
		_delegates += arg
	}
}