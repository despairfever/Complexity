package ru.kfu.itis.ivanov.complexity;

import ru.kfu.itis.ivanov.complexity.interfaces.IGraph;
import ru.kfu.itis.ivanov.complexity.interfaces.IGraphSearch;

/**
 * Created by Денис on 26.04.2015. Ave furby!
 */
public class DijkstraSearchGraph implements IGraphSearch {

    protected IGraph graph;

    public DijkstraSearchGraph(IGraph graph) {
        this.graph = graph;
    }

    public int findDistance(int start, int finish) {
        Node first = graph.getNodes().get(start);
        first.setValue(0);
        this.mark(first);
        return graph.getNodes().get(finish).getValue();
    }

    private void mark(Node start) {
        start.setMarked(true);
        Node finish;
        for (Link link : start.getAdjacent()) {
            finish = link.getFinish();
            if (finish.getValue() > start.getValue()+link.getLength() || finish.getValue()==(-1)) {
                finish.setValue( start.getValue()+link.getLength() );
            }
            if (!finish.isMarked()) {
                this.mark(finish);
            }
        }
    }

    public void printResults() {
        for (Node node : graph.getNodes()) {
            System.out.println(node.getId()+" - "+node.getValue()+" >>"+node.isMarked());
        }
    }

}
