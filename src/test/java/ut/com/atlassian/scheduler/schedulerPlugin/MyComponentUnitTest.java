package ut.com.atlassian.scheduler.schedulerPlugin;

import org.junit.Test;
import com.atlassian.scheduler.schedulerPlugin.api.MyPluginComponent;
import com.atlassian.scheduler.schedulerPlugin.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}