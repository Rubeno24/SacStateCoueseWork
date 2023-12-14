def bellman_ford(graph, source):
    #final
    #start
    # Create bidirectional edges by duplicating edges in the opposite direction
    bidirectional_edges = []
    for src, dest, weight in graph:
        bidirectional_edges.append((src, dest, weight))
        bidirectional_edges.append((dest, src, weight))
    #end

    # Find the number of unique nodes in the graph
    # We loop through the edges in bidirectional_edges and add them to a set named nodes
    # Since a set doesnt allow dupes the edges that are added are unique
    # Then we call the len method on the set named nodes. That gives us a value
    # and we store that in num_nodes which is the unique number of nodes
    # Start
    nodes = set()
    for src, dest, weight in bidirectional_edges:
        nodes.add(src)
        nodes.add(dest)
    num_nodes = len(nodes)
    # End
    
    # Initialize distance vector with infinity and set distance to self is 0
    # Start
    # Create a vector called distance and setting all the distance to inf except its self
    # We loop through all the nodes and set them to inf except the source node
    distance = {}
    for node in range(1, num_nodes + 1):
        distance[node] = float('inf')
    distance[source] = 0
    # End

    

    # Were iteratively updating the distance vector for the source and destination by
    #  repeatedly checking and updating the shortest paths between paths. The 
    # loops make sure we go through all the edges multiple times. 
    # For each connection, we ask if taking that route would be faster. If
    #  it is, we update our idea of the shortest path. This keeps happening, improving our 
    # understanding of the quickest ways to go from one place to another in the graph. 
    # The goal is to find the shortest paths from the starting point to all the other places.

    for _ in range(num_nodes - 1):
        for source, dest, cost in bidirectional_edges: 
            if distance[source] != float('inf') and distance[source] + cost < distance[dest]:
                distance[dest] = distance[source] + cost

    # Check for negative weight cycles
    # We loop through each node in the graph and examines if there's a way to loop around in a 
    # manner that makes the total cost negative. If we find such a way , we immediately print a message 
    # saying, "Graph contains a negative-weight cycle." After that, it stops doing any further calculations.
    for source, dest, cost in bidirectional_edges:
        if distance[source] != float('inf') and distance[source] + cost < distance[dest]:
            print("Graph contains a negative-weight cycle")
            return None

    return (list(distance.values()))



# Define the undirected graph edges with their costs
#memem
graph = [
    (1, 2, 2),
    (1, 3, 7),
    (2, 3, 1),
]

# Graph with negative weight cycle shown in Figure 2
graph1 = [
    (1, 2, -2),
    (2, 3, -2),
    (3, 1, 1),
 ]
# (source, destination, cost)
bigGraph =[
    (1,2,3),
    (1,3,5),
    (3,4,4),
    (2,4,6),
    (2,5,7),
    (4,5,2),
    
]

# Test the function
shortest_path = bellman_ford(bigGraph, 5)
print(shortest_path)
