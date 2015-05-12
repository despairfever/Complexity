package ru.kfu.itis.ivanov.complexity;

import ru.kfu.itis.ivanov.complexity.core.Link;
import ru.kfu.itis.ivanov.complexity.core.Node;
import ru.kfu.itis.ivanov.complexity.interfaces.IGraph;
import ru.kfu.itis.ivanov.complexity.interfaces.IGraphSearch;

import java.util.ArrayList;

/**
 * Created by Денис on 26.04.2015. Ave furby!
 */
public class DijkstraSearchGraph implements IGraphSearch {

    protected IGraph graph;
    protected ArrayList<Node> roots;

    public DijkstraSearchGraph() {}

    public DijkstraSearchGraph(IGraph graph) {
        this.graph = graph;
        roots = new ArrayList<Node>(graph.getSize());
        for (int i=0; i<graph.getSize(); i++) {
            roots.add(new Node(-1));
        }
    }

    public void setGraph(IGraph graph) {
        this.graph = graph;
        roots = new ArrayList<Node>(graph.getSize());
        for (int i=0; i<graph.getSize(); i++) {
            roots.add(new Node(-1));
        }
    }

    @Override
    public int findDistance(int start, int finish) {
        Node first = graph.getNodes().get(start);
        first.setValue(0);
        this.mark(first);
        return graph.getNodes().get(finish).getValue();
    }

    @Override
    public String getPath(int start, int finish) {
        this.findDistance(start, finish);
        String path = "";
        Node current = graph.getNodes().get(finish);
        while (current.getId() != -1) {
            path = "["+current.getId()+"] - "+path;
            current = roots.get(current.getId());
        }
        return path;
    }

    private void mark(Node start) {
        start.setMarked(true);
        Node finish;
        for (Link link : start.getAdjacent()) {
            finish = link.getFinish();
            if (finish.getValue() > start.getValue()+link.getLength() || finish.getValue()==(-1)) {
                roots.set(finish.getId(), start);
                finish.setValue( start.getValue()+link.getLength() );
            }
            if (!finish.isMarked()) {
                this.mark(finish);
            }
        }
    }

    public void printResults() {
        for (Node node : graph.getNodes()) {
            System.out.println(node.getId()+" - "+node.getValue());
        }
    }

}
