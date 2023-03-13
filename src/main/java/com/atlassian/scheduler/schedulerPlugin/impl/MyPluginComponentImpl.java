package com.atlassian.scheduler.schedulerPlugin.impl;

import com.atlassian.sal.api.ApplicationProperties;
import com.atlassian.scheduler.schedulerPlugin.api.MyPluginComponent;
import com.atlassian.templaterenderer.RenderingException;
import com.atlassian.templaterenderer.TemplateRenderer;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;


public class MyPluginComponentImpl implements MyPluginComponent
{
        private final ApplicationProperties applicationProperties;

        public MyPluginComponentImpl(final ApplicationProperties applicationProperties)
    {
        this.applicationProperties = applicationProperties;
    }

    public String getName()
    {
        if(null != applicationProperties)
        {
            return "myComponent:" + applicationProperties.getDisplayName();
        }
        return "myComponent";
    }
}