package kommand.arguments

import kommand.KommandDSLElement

abstract class Arguments : KommandDSLElement {
	private val _delegates = mutableListOf<ArgumentDelegate<*>>()
	val delegates: List<ArgumentDelegate<*>>
		get() = _delegates.toList()

	internal fun register(arg: ArgumentDelegate<*>) {
		_delegates += arg
	}
}