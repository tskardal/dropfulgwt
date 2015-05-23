package com.skardal.dropfulgwt.client;

import java.util.Arrays;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.skardal.dropfulgwt.client.services.HelloWorldService;
import com.skardal.dropfulgwt.core.Saying;

public class HelloWorld extends Composite {

    @UiField
    TextBox name;
    @UiField
    Button sayHello;
    @UiField
    SimplePanel result;
    
    private final HelloWorldService helloWorldService;

    interface Binder extends UiBinder<Widget, HelloWorld> {
    }

    public HelloWorld() {
        initWidget(((Binder) GWT.create(Binder.class)).createAndBindUi(this));
        helloWorldService = GWT.create(HelloWorldService.class);
    }

    @UiHandler("sayHello")
    void onSayHello(ClickEvent event) {
        final MethodCallback<Saying> callback = new MethodCallback<Saying>() {
            @Override
            public void onSuccess(Method method, Saying response) {
                result.setWidget(new Label(response.getContent()));
            }
            
            @Override
            public void onFailure(Method method, Throwable exception) {
                result.setWidget(new Label("Something went wrong :-/"));
            }
        };

        if (Strings.isNullOrEmpty(name.getText())) {
            helloWorldService.helloWorld(callback);
        } else {
            helloWorldService.helloWorld(name.getText(), callback);
        }
    }
}