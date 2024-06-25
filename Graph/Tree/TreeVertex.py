class TreeVertex:

    def __init__ (self, value = None):
        # User domain payload of the TreeVertex
        self._value = value
        
        # Left and right sided children
        self._left = None
        self._right = None
        
    def get_value (self):
        return self._value
    
    def set_value (self, value):
        self._value = value
        
    def get_left (self):
        return self._left

    def set_left (self, new_left):
        self._left = new_left
        
    def get_right (self):
        return self._right
    
    def set_right (self, new_right):
        self._right = new_right
        
    def __str__(self):
        return self._value
    
    def pre_order(self):
        """ Pre-order traversal (Root, Left, Right) """
        yield self._value
        if self._left:
            yield from self._left.pre_order()
        if self._right:
            yield from self._right.pre_order()
            
    def in_order(self):
        """ In-order traversal (Left, Root, Right) """
        if self._left:
            yield from self._left.in_order()
        yield self._value
        if self._right:
            yield from self._right.in_order()
            
    def post_order(self):
        """ Post-order traversal (Left, Right, Root) """
        if self._left:
            yield from self._left.post_order()
        if self._right:
            yield from self._right.post_order()
        yield self._value
    