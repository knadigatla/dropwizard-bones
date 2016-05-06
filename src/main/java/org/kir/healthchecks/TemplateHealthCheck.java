package org.kir.healthchecks;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by kiran on 5/6/16.
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return HealthCheck.Result.healthy();
    }
}
