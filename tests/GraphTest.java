import DataStructures.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {

    Graph<String> graph;

    @BeforeEach
    void setUp(){
        graph = new DirectedGraph<>();
    }

    void addTestDataSet1(){
        graph.addEdge("u","x");
        graph.addEdge("u","v");
        graph.addEdge("x","v");
        graph.addEdge("v","y");
        graph.addEdge("y","x");
        graph.addEdge("w","y");
        graph.addEdge("w","z");
        graph.addEdge("z","z");
    }

    void addTestDataSet2(){
        graph.addEdge("y","x");
        graph.addEdge("z","y");
        graph.addEdge("w","x");
        graph.addEdge("x","z");
        graph.addEdge("z","w");
        graph.addEdge("s","z");
        graph.addEdge("s","w");
        graph.addEdge("z","w");
        graph.addEdge("v","w");
        graph.addEdge("v","s");
        graph.addEdge("t","v");
        graph.addEdge("t","u");
        graph.addEdge("u","v");
    }

    void addTestDataSet3(){
        graph.addEdge("s","v");
        graph.addEdge("v","w");
        graph.addEdge("w","s");
        graph.addEdge("q","s");
        graph.addEdge("q","w");
        graph.addEdge("q","t");
        graph.addEdge("t","x");
        graph.addEdge("x","z");
        graph.addEdge("z","x");
        graph.addEdge("t","y");
        graph.addEdge("y","q");
        graph.addEdge("r","y");
        graph.addEdge("u","y");
        graph.addEdge("r","u");
    }
}

class DirectedGraphTest extends GraphTest{
    @Test
    void testVerticesSet1(){

    }

    @Test
    void testVerticesSet2(){

    }

    @Test
    void testVerticesSet3(){

    }

    @Test
    void testEdgeSet1(){

    }

    @Test
    void testEdgeSet2(){

    }

    @Test
    void testEdgeSet3(){

    }
}