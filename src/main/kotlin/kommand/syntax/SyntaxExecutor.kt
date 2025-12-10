package kommand.syntax

import kommand.KommandContext

typealias SyntaxExecutor<S> = context(KommandContext) S.() -> Unit