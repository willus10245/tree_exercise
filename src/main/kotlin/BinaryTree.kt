class BinaryTree(rootValue: Int, private val rootNode: Node = Node(rootValue)) {

    fun insert(newValue: Int, node: Node = rootNode) {
        when {
            newValue < node.value && node.left == null  -> node.left = Node(newValue)
            newValue < node.value && node.left != null  -> insert(newValue, node.left!!)
            newValue > node.value && node.right == null -> node.right = Node(newValue)
            newValue > node.value && node.right != null -> insert(newValue, node.right!!)
            else -> throw IllegalArgumentException("A node with that value already exists!")
        }
    }

//    fun depthFirstSearch(searchValue: Int) = inOrderTraversal().contains(searchValue)

    fun depthFirstSearch(searchValue: Int, node: Node? = rootNode): Boolean {
        return when {
            node == null -> false
            searchValue == node.value -> true
            depthFirstSearch(searchValue, node.left) -> true
            depthFirstSearch(searchValue, node.right) -> true
            else -> false
        }
    }

    fun inOrderTraversal(node: Node = rootNode, currentList: MutableList<Int> = mutableListOf()): List<Int> {
        if (node.left != null) inOrderTraversal(node.left!!, currentList)

        currentList.add(node.value)

        if (node.right != null) inOrderTraversal(node.right!!, currentList)

        return currentList
    }
}

data class Node(val value: Int) {
    var left: Node? = null
    var right: Node? = null
}