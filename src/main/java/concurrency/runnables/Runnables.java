package concurrency.runnables;

import concurrency.Job;
import concurrency.Threading;
import java.util.Arrays;
import java.util.List;

public class Runnables extends Threading {
  public static void main(String[] args) {
    Job doIt = new Job("Do it!");
    Job makeIt = new Job("Make it!");
    Job workIt = new Job("Work it!");
    Job makesUs = new Job("Makes us!");

    Job harder = new Job("Harder!");
    Job better = new Job("Better!");
    Job faster = new Job("Faster!");
    Job stronger = new Job("Stronger!");

    List<Job> jobs = Arrays.asList(doIt, makeIt, workIt, makesUs, harder, better, faster, stronger);

    jobs.forEach(Runnables::start);
  }
}
