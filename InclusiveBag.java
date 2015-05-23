/*
 * You are given a bag with N balls (where the value o N is unknown).
 * Each ball in the bag is uniquely numbered with a value between 1 to N
 * (inclusive) i.e. for each number between 1 and N, 
 * there is only one ball with that number.
 * Now you pick a ball from the bag and see its number.
 * You repeat this experiment K times.
 * What is the best possible estimate fo the value of N (the number of balls
 * in the bag) you can make from the above experiment (of taking out a ball
 * from the bag K times) in the following cases.
 * a) With replacement
 * b) Without replacement
 */

/**
 *
 * @author Daniel Mercado
 */
import java.util.*;

public class InclusiveBag {

    private ArrayList<Integer> bag;
    private int N;
    Random randomBallGenerator = new Random(System.currentTimeMillis());

    public InclusiveBag() {
        
        bag = new ArrayList<Integer>();
        N = 0;
    }

    public InclusiveBag(int N) {
        
        this.N = N;
        bag = new ArrayList<Integer>();
        for (int i = 1; i < N + 1; i++) {
            bag.add(i);
        }
    }
    public InclusiveBag(int[] balls) {
        
        Integer[] ballsObject = new Integer[balls.length];
        for (int i = 0; i < balls.length; i++) {
            ballsObject[i] = balls[i];
        }
        bag = new ArrayList<Integer>(Arrays.asList(ballsObject));
    }
    
    public void add(int ball) {
        bag.add(ball);
        N++;
    }
    
    public int pick() {
        
        int x = randomBallGenerator.nextInt(N) + 1;
        
        /* 
         * WARNING: 
         * Be careful it doesn't remove by index instead of value.
         */
        
        return bag.remove(x);
    }
    
    public int peek() {
        int x = randomBallGenerator.nextInt(N) + 1;
        return bag.get(x);
    }
}
