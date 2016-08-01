package taskone;
import com.taskone.TaskOneAsync;
import com.taskone.TaskOneSync;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class TaskOneSyncTest {
    int value = 0;

    @Test
    public void shouldReturnValueTenWhenRunningAddOne() throws InterruptedException {
        TaskOneSync target = new TaskOneSync();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(target.addOne);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        assertThat(target.value, is(10));
    }

    @Test
    public void shouldReturnValueMinusTenWhenRunningSubstractOne() throws InterruptedException {
        TaskOneSync target = new TaskOneSync();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(target.substractOne);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        assertThat(target.value, is(-10));
    }

    @Test
    public void shouldReturnValueSeventyWhenRunningAddSeven() throws InterruptedException {
        TaskOneSync target = new TaskOneSync();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(target.addSeven);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        assertThat(target.value, is(70));
    }

    @Test
    public void shouldReturnValueSeventyWhenRunningTheThreeThreadsCombined() throws InterruptedException {
        TaskOneSync target = new TaskOneSync();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(target.addOne);
        executor.submit(target.substractOne);
        executor.submit(target.addSeven);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        assertThat(target.value, is(70));
    }

}
