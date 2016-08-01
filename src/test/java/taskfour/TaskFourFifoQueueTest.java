package taskfour;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.taskone.TaskOneAsync;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@RunWith(MockitoJUnitRunner.class)
public class TaskFourFifoQueueTest {

    @Test
    public void shouldGetInconsistentResults() throws InterruptedException {


        /*ExecutorService executor = Executors.newFixedThreadPool(3);

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("Thread%d").build();

        TaskOneAsync target = new TaskOneAsync();
        executor.execute(target.addOne);
        executor.execute(target.substractOne);
        executor.execute(target.addSeven);

        assertThat(target.value, is(not(70)));*/
    }

}
