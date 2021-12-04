/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog3;
import java.awt.Graphics;

/**
 *
 * Ricardo Estrella
 * PID: 6071900
 */
public class SimplePolygon extends GeometricObject {
    private Point[] vertexList;
    private int[] x;
    private int[] y;
    private int size;
    private int vertNumber;
    
    public SimplePolygon(int n) {
        vertexList = new Point[n];
        vertNumber = 0;
    }
    
    public void addVertex(Point v) {
        if(vertNumber < vertexList.length) {
            vertexList[vertNumber] = new Point(v.getX(), v.getY());
            vertNumber++;
            size++;
        }
    }
    
    public double area() {
        if(vertNumber < 4) {
            return Double.NaN;
        }
        
        double sum1 = 0.0, sum2 = 0.0;
        Point v1, v2;
        
        for(int i = 0; i < vertNumber; i++) {
            v1 = vertexList[i];
            v2 = vertexList[(i + 1) % vertNumber];
            sum1 += v1.getX() * v2.getY();
        }
        
        double area = 0.5 * Math.abs(sum1 - sum2);
        return area;
    }
    
    /*public Rectangle boundingRectangle() {
        
    }*/
    
    public void draw(Graphics g) {
        for(int i = 0; i < vertNumber; i++) {
            x[i] = (int)vertexList[i].getX();
            y[i] = (int)vertexList[i].getY();
        }
        g.setColor(getInteriorColor());
        g.fillPolygon(x, y, vertNumber);
        
        g.setColor(getBoundaryColor());
        g.drawPolygon(x, y, vertNumber);
    }
    
    public LineSegment[] getEdges() {
        LineSegment[] edges = new LineSegment[vertNumber];
        return edges;
    }
    
    public int getNumberOfVertices() {
        return vertNumber;
    }
    
    public Point[] getVertices() {
        Point[] vertices = new Point[vertNumber];
        return vertices;
    }
    
    public double greatestX() {
        int i = 0;
        double max = vertexList[i].getX();
        for(int j = 1; j < vertNumber; j++) {
            if(vertexList[j].getX() > max) {
                max = vertexList[j].getX();
            }
        }
        return max;
    }
    
    public double greatestY() {
        int i = 0;
        double max = vertexList[i].getY();
        for(int j = 1; j < vertNumber; j++) {
            if(vertexList[j].getY() > max) {
                max = vertexList[j].getY();
            }
        }
        return max;
    }
    
    boolean isPointInSimplePolygon(Point p) {
        double x = p.getX();
        double y = p.getY();
        if ( (smallestX() <= x && x <= greatestX()) &&
                (smallestY() <= y && y <= greatestY()) )
            return true;
        else
            return false;
    }
    
    public double smallestX() {
        int i = 0;
        double min = vertexList[i].getX();
        for(int j = 1; j < vertNumber; j++) {
            if(vertexList[j].getX() < min) {
                min = vertexList[j].getX();
            }
        }
        return min;
    }
    
    public double smallestY() {
        int i = 0;
        double min = vertexList[i].getY();
        for(int j = 1; j < vertNumber; j++) {
            if(vertexList[j].getY() < min) {
                min = vertexList[j].getY();
            }
        }
        return min;
    }
    
    public String toString() {
        String s = "";
        for(int i = 0; i < vertNumber; i++) {
            s += ("Vertex " + i + ": " + vertexList[i] + "\n");
        }
        return s;
    }
    
    public void translate(Vector v) {
        vertexList[vertNumber].translate(v);
    }
}
