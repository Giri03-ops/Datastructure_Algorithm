import TreeVertex


class BinaryTree:
    def __init__(self, root_value=None):
        if root_value is not None:
            self._root = TreeVertex(root_value)
        else:
            self._root = None

    def get_root(self):
        return self._root

    def set_root(self, root):
        self._root = root