package water;

import hex.DeepLearningIrisTest;
import hex.DeepLearningProstateTest;
import hex.DeepLearningSpiralsTest;
import hex.MRUtilsTest;
import hex.deeplearning.DropoutTest;
import hex.deeplearning.NeuronsTest;
import org.junit.internal.TextListener;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import water.deploy.NodeCL;
import water.util.Log;
import water.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class JUnitRunnerDebug {
  public static final int NODES = 3;

  public static void main(String[] args) throws Exception {
    int[] ports = new int[NODES];
    for( int i = 0; i < ports.length; i++ )
      ports[i] = 54321 + i * 2;

    String flat = "";
    for( int i = 0; i < ports.length; i++ )
      flat += "127.0.0.1:" + ports[i] + "\n";
    flat = Utils.writeFile(flat).getAbsolutePath();

    for( int i = 0; i < ports.length; i++ ) {
      Class c = i == 0 ? UserCode.class : H2O.class;
      new NodeCL(c, ("-ip 127.0.0.1 -port " + ports[i] + " -flatfile " + flat).split(" ")).start();
    }
  }

  public static class UserCode {
    public static void userMain(String[] args) {
      H2O.main(args);
      TestUtil.stall_till_cloudsize(NODES);

      List<Class> tests = new ArrayList<Class>();

      // Classes to test:
      // tests = JUnitRunner.all();

      // Neural Net - deprecated
//      tests.add(NeuralNetSpiralsTest.class); //compare NeuralNet vs reference
//      tests.add(NeuralNetIrisTest.class); //compare NeuralNet vs reference

      // Deep Learning tests
//      tests.add(DeepLearningVsNeuralNet.class); //only passes for NODES=1, not clear why
      tests.add(DeepLearningSpiralsTest.class); //test Deep Learning convergence
      tests.add(DeepLearningIrisTest.Short.class); //compare Deep Learning vs reference
//      tests.add(DeepLearningIrisTest.Long.class); //compare Deep Learning vs reference
      tests.add(DeepLearningProstateTest.Short.class); //test Deep Learning
//      tests.add(DeepLearningProstateTest.Long.class); //test Deep Learning
      tests.add(NeuronsTest.class); //test Deep Learning
      tests.add(MRUtilsTest.class); //test MR sampling/rebalancing
      tests.add(DropoutTest.class); //test NN Dropput

//      tests.add(GLMTest2.class);
//      tests.add(DRFTest.class);
//      tests.add(GBMTest.class);
//      tests.add(KMeans2Test.class);
//      tests.add(PCATest.class);

      // Uncomment this to sleep here and use the browser.
      // try { Thread.sleep(10000000); } catch (Exception _) {}

      JUnitCore junit = new JUnitCore();
      junit.addListener(new LogListener());
      Result result = junit.run(tests.toArray(new Class[0]));
      if( result.getFailures().size() == 0 ) {
        Log.info("SUCCESS!");
        System.exit(0);
      }
      else {
        Log.info("FAIL!");
        System.exit(1);
      }
    }
  }

  static class LogListener extends TextListener {
    LogListener() {
      super(System.out);
    }

    @Override public void testRunFinished(Result result) {
      printHeader(result.getRunTime());
      printFailures(result);
      printFooter(result);
    }

    @Override public void testStarted(Description description) {
      Log.info("");
      Log.info("Starting test " + description);
    }

    @Override public void testFailure(Failure failure) {
      Log.info("Test failed " + failure);
    }

    @Override public void testIgnored(Description description) {
      Log.info("Ignoring test " + description);
    }
  }
}
