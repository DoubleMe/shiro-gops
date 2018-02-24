package com.chm.shop.app.view.func;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.apache.ecs.html.Input;

import java.util.List;
import java.util.UUID;

/**
 * 自定义freemarker 指令
 * <p>生成csrf_token的input隐藏域</p>
 * @author chen-hongmin
 * @since V1.0
 * @date 2018-02-02
 */
public class FreeMarkerCsrfFunction implements TemplateMethodModelEx {
    @Override
    public Object exec(List arguments) throws TemplateModelException {

        Input input = new Input("hidden","csrf_token", UUID.randomUUID().toString());

        return input.toString();
    }
}
