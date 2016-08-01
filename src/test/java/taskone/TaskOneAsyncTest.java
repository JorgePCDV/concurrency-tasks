package taskone;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.taskone.TaskOneAsync;
import org.hamcrest.core.IsNot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@RunWith(MockitoJUnitRunner.class)
public class TaskOneAsyncTest {

    @Test
    public void shouldGetInconsistentResultsNotSeventy() throws InterruptedException {
        TaskOneAsync target = new TaskOneAsync();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(target.addOne);
        executor.submit(target.substractOne);
        executor.submit(target.addSeven);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        assertThat(target.value, is(not(70)));
    }

}
