package tasktwo;

import com.taskone.TaskOneAsync;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@RunWith(MockitoJUnitRunner.class)
public class DeadlockTest {
    int value = 0;

    @Test
    public void shouldGetConsistentResults() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        TaskOneAsync target = new TaskOneAsync();
        Executors.newSingleThreadExecutor().execute(target.addOne);
        executor.submit(target.addOne);
        executor.submit(target.substractOne);
        executor.submit(target.addSeven);

    }

}
