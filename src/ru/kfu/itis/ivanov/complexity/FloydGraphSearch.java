package ru.kfu.itis.ivanov.complexity;

import ru.kfu.itis.ivanov.complexity.interfaces.IGraph;
import ru.kfu.itis.ivanov.complexity.interfaces.IGraphSearch;

/**
 * Created by Денис on 27.04.2015. Ave furby!
 */
public class FloydGraphSearch implements IGraphSearch {

    protected IGraph graph;

    public FloydGraphSearch(IGraph graph) {
        this.graph = graph;
    }

    @Override
    public int findDistance(int atart, int finish) {

        return 11037;
    }

    @Override
    public String getPath(int start, int finish) {
        return null;
    }

    public void printResults(){


    }

}
