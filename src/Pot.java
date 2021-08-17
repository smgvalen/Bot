import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Pot {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        boolean boosted = false;
        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            int nextCheckpointY = in.nextInt(); // y position of the next check point
            int nextCheckpointDist = in.nextInt(); // distance to the next checkpoint
            int nextCheckpointAngle = in.nextInt(); // angle between your pod orientation and the direction of the next checkpoint
            int opponentX = in.nextInt();
            int opponentY = in.nextInt();
            String thrust = "100";

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            /*if (nextCheckpointDist < 10 ) {
                thrust = "40";
            } 
            if (nextCheckpointDist < 5 ) {
                thrust = "25";
            } */

            thrust = String.valueOf(
                    Math.min(
                            calculateThrustByDistance(nextCheckpointDist),
                            calculateThrustByAngle(nextCheckpointAngle)));
            if (nextCheckpointDist > 6000 && !boosted && Math.abs(nextCheckpointAngle) < 15) {
                thrust = "BOOST";

            }
            // You have to output the target position
            // followed by the power (0 <= thrust <= 100)
            // i.e.: "x y thrust"
            System.out.println(nextCheckpointX + " " + nextCheckpointY + " " + thrust);
        }
    }

    public static int calculateThrustByDistance(int distance) {
        int thrust = 100;
        if (distance < 700 && distance > 600) {
            thrust = distance - 600;
        }
        if (distance < 600) {
            thrust = 100;
        }
        return Math.max(thrust, 10);
    }

    public static int calculateThrustByAngle(int nextCheckpointAngle) {
        int thrust = 100;
        int angle = Math.abs(nextCheckpointAngle);
        if (angle > 30) {
            int substraction = ((angle / 180) * 100);
            thrust = 100 - substraction;
        }
        return Math.max(thrust, 10);
    }
}