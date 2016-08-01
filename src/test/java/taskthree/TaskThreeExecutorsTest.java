package taskthree;

import com.taskone.TaskOneAsync;
import com.taskthree.TaskThreeExecutors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@RunWith(MockitoJUnitRunner.class)
public class TaskThreeExecutorsTest {

    @Test
    public void shouldCalculateFactorial() throws InterruptedException, ExecutionException {
        TaskThreeExecutors target = new TaskThreeExecutors();
        ExecutorService executor = Executors.newCachedThreadPool();
        //List<Integer> list = new List
        //executor.submit()
    }

    @Test
    public void shouldSumAllFactorialThreads() throws InterruptedException, ExecutionException {
        TaskThreeExecutors target = new TaskThreeExecutors();
        //executor.submit(new TaskThreeExecutors.FactorialThread(4));

        ExecutorService executor = Executors.newFixedThreadPool(3);
        assertThat(executor.submit(new TaskThreeExecutors.FactorialThread(3)).get(), is(6));
    }



}
