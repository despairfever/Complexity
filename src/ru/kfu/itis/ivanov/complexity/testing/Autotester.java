package ru.kfu.itis.ivanov.complexity.testing;

import ru.kfu.itis.ivanov.complexity.core.Graph;
import ru.kfu.itis.ivanov.complexity.interfaces.IGraph;
import ru.kfu.itis.ivanov.complexity.interfaces.IGraphSearch;

import java.io.File;
import java.io.IOException;

/**
 * Created by Денис on 12.05.2015. Ave furby!
 */
public class Autotester {

    private int testID;
    private final String BASE_DIRECTORY = "testgraphs\\test";
    private final String FILE_FORMAT = ".json";

    private long executionTime;
    private IGraph graph;
    private IGraphSearch igs;

    public Autotester(IGraphSearch igs, IGraph graph) {
        this.igs = igs;
        this.graph = graph;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void test(int id, int start, int finish) throws IOException{

        String filePath = BASE_DIRECTORY + id + FILE_FORMAT;
        graph.readFromFile(filePath);
        igs.setGraph(graph);

        long timeStart = System.nanoTime();
        igs.findDistance(start, finish);
        long timeFinish = System.nanoTime();
        executionTime = timeFinish - timeStart;

    }

    public String getPath(int start, int finish) {
        return igs.getPath(start, finish);
    }

    public void printResults() {
        igs.printResults();
    }
}
