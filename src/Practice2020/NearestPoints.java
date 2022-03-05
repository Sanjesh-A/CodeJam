package Practice2020;

import static java.lang.Math.abs;

public class NearestPoints {

    public Point[] getNearestPoints(Point[] xSorted, int xBegin, int xEnd, Point[] ySorted, int yBegin, int yEnd){

        if(xBegin == xEnd)
            return null;

        if(xEnd-xBegin == 1){
            Point[] points = new Point[2];
            points[0] = new Point(xSorted[xBegin]);
            points[1] = new Point(xSorted[xEnd]);
            return points;
        }

        int xMid = (xBegin + xEnd) /2;

        Point[] nearestLeftPoints = getNearestPoints(xSorted, xBegin, xMid,  ySorted, yBegin, yEnd);
        Point[] nearestRightPoints = getNearestPoints(xSorted, xMid+1, xEnd,  ySorted, yBegin, yEnd);
        int minLeftDist = getDist(nearestLeftPoints);
        int minRightDist = getDist(nearestRightPoints);
        int minDist = (minLeftDist < minRightDist)? minLeftDist : minRightDist;
        Point[] nearestPointsAcrossMid = getNearestPointsACrossMid(xMid, minDist, ySorted);
        int minAcrossMidDist = getDist(nearestPointsAcrossMid);

        if(minAcrossMidDist < minDist){
            return nearestPointsAcrossMid;
        } else if(minLeftDist < minRightDist){
            return nearestLeftPoints;
        } else {
            return nearestRightPoints;
        }

    }

    private int getDist(Point[] nearestLeftPoints) {
        return abs(nearestLeftPoints[0].x -nearestLeftPoints[1].x) +
                abs(nearestLeftPoints[0].y -nearestLeftPoints[1].y);
    }

    private Point[] getNearestPointsACrossMid(int xMid, int minDist, Point[] ySorted) {
        int size = ySorted.length;
        Point[] yLeft = new Point[ySorted.length];
        Point[] yRight = new Point[ySorted.length];
       // getYLeftRight(xMid, minDist, ySorted, yLeft, yRight);
        for(int i =0; i<size; i++ ){
            for(int j = 0; j< size && (yDist(yLeft[i], yRight[j]) < minDist); j++){

            }
        }

        return yLeft;
    }

    private int yDist(Point point, Point point1) {
        return abs(point.y - point1.y);
    }

    private class Point {
        public int x;
        public int y;

        public Point(Point point) {
            x = point.x;
            y = point.y;
        }
    }
}
