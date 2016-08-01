package taskone;

import com.taskone.TaskOneAtomic;
import com.taskone.TaskOneSync;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class TaskOneAtomicTest {
    int value = 0;

    @Test
    public void shouldReturnValueSeventyWhenRunningTheThreeThreadsCombined() throws InterruptedException {
        TaskOneAtomic target = new TaskOneAtomic();
        target.init();

        assertThat(target.value.get(), is(70));
    }


}
