package taskthree;

import com.taskthree.TaskThreeExecutors;
import com.taskthree.TaskThreeParallelStreams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@RunWith(MockitoJUnitRunner.class)
public class TaskThreeParallelStreamTest {

    @Test
    public void shouldCalculateFactorial() throws InterruptedException, ExecutionException {
        //TaskThreeExecutors target = new TaskThreeExecutors();
        //executor.submit(new TaskThreeExecutors.FactorialThread(4));
        TaskThreeParallelStreams target = new TaskThreeParallelStreams();
        assertThat(target.calculateFactorial(5), is(120));
    }

    @Test
    public void shouldSumAllFactorialThreads() throws InterruptedException, ExecutionException {
        TaskThreeExecutors target = new TaskThreeExecutors();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        assertThat(executor.submit(new TaskThreeExecutors.FactorialThread(3)).get(), is(6));
    }

}
