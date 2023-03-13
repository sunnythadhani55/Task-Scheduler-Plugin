package com.atlassian.scheduler.servlet;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.plugin.spring.scanner.annotation.imports.JiraImport;
import com.atlassian.templaterenderer.TemplateRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Scanned
public class IndexServlet extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(IndexServlet.class);

//    @JiraImport
//    private IssueService issueService;
//    @JiraImport
//    private ProjectService projectService;
//    @JiraImport
//    private SearchService searchService;

    private TemplateRenderer templateRenderer=ComponentAccessor.getOSGiComponentInstanceOfType(TemplateRenderer.class);

    private static final String INDEX_PAGE_TEMPLATE = "/templates/index.vm";
    private static final String VIEW_TASKS_TEMPLATE = "/templates/viewTasks.vm";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = Optional.ofNullable(req.getParameter("actionType")).orElse("");

        log.error("It's doGet Method starting");

        Map<String, Object> context = new HashMap<>();
        resp.setContentType("text/html;charset=utf-8");
        switch (action) {
            case "index":
                templateRenderer.render(INDEX_PAGE_TEMPLATE, context, resp.getWriter());
                break;
            case "viewTasks" :
                templateRenderer.render(VIEW_TASKS_TEMPLATE, context, resp.getWriter());
            default:
                templateRenderer.render(INDEX_PAGE_TEMPLATE, context, resp.getWriter());
                break;
        }

        log.error("It's doGet Method ending");

    }

}