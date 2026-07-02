class MyStack() {

    private var top: Node? = null

    fun push(x: Int) {
        var newTop = Node(x, this.top)
        this.top = newTop
    }

    fun pop(): Int {
        var currTop = this.top!!
        this.top = currTop.prev
        return currTop.value
    }

    fun top(): Int {
        return this.top!!.value
    }

    fun empty(): Boolean {
        return this.top == null
    }

    private class Node(var value: Int, var prev: Node?)
}

/**
 * Your MyStack object will be instantiated and called as such:
 * val obj = MyStack()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.top()
 * val param_4 = obj.empty()
 */
