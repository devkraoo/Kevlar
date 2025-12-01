package kommand.syntax

import kommand.KommandContext

typealias SyntaxExecutor<S> = S.(context: KommandContext) -> Unit