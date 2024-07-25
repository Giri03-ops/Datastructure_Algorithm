class Vertex:

    def __init__(self, vertex_id):
        self.id = vertex_id
        self.adjacent = {} # dictionary for each vertex to add its neighbours 
        
    def __str__(self):
        return 'id: ' + str(self.id) + ', adjacent: ' + str([x.id for x in self.adjacent.values()])

    def add_neighbour(self, neighbour : object, edge : object):
        self.adjacent[neighbour.id] = (neighbour,edge)

    def get_connections(self):
        return self.adjacent.values()  

    def get_id(self):
        return self.id