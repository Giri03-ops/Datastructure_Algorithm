#It is often helpful to be able to visualise a graph for error checking and to see a graphical representation of a graph data structure. NetworkXLinks to an external site. is an open-source Python package for the creation, manipulation, and study of the structure, dynamics, and functions of complex networks.
import networkx as nx
import matplotlib.pyplot as plt

g = nx.Graph()
g.add_nodes_from(['A', 'B', 'C', 'D', 'E'])
g.add_edges_from([('A', 'B'), ('B', 'E'), ('B', 'C'), ('E', 'C'), ('C', 'D')])
nx.draw_networkx(g, with_labels = True)
plt.show()