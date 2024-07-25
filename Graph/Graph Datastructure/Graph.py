import Vertex
import Edge

class Graph:
    
    def __init__(self, vertices = []):
        self.vertex_dict = {}
        for vid in vertices:
            self.add_vertex(vid)
        
    def print_graph(self):
        for v in self.vertex_dict.values():
            print (v)

    def add_vertex(self, vertex_id):
        VertexObject = Vertex(vertex_id)
        self.vertex_dict[vertex_id] = VertexObject
        return VertexObject
    
    def get_vertex(self, vertex_id):
        return self.vertex_dict[vertex_id]

    def get_vertex_dict (self):
        return self.vertex_dict
    
    def add_edge (self, VertexOne : object, VertexTwo : object, weight : int):

        EdgeVertex = Edge(VertexOne , VertexTwo , weight = 0)

        VertexOne.add_neighbour (VertexTwo , EdgeVertex)
        VertexTwo.add_neighbour (VertexOne , EdgeVertex)