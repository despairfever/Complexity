package ru.kfu.itis.ivanov.complexity.interfaces;

import ru.kfu.itis.ivanov.complexity.core.Node;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Денис on 27.04.2015. Ave furby!
 */
public interface IGraph {

    public void readFromFile(String path)  throws IOException;

    public ArrayList<Node> getNodes();

    public boolean isDirected();

    public int getSize();

    public void print();

}
