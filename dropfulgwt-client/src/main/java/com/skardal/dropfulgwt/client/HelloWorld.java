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

    interface Binder extends UiBinder<Widget, HelloWorld> {
    }

    public HelloWorld() {
        initWidget(((Binder) GWT.create(Binder.class)).createAndBindUi(this));
    }

    @UiHandler("sayHello")
    void onSayHello(ClickEvent event) {
        Defaults.setServiceRoot("/api");
        HelloWorldService helloWorldService = GWT.create(HelloWorldService.class);
        String theName = name.getText();
        
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

        FluentIterable.from(Arrays.asList(1, 2, 3));

        if (Strings.isNullOrEmpty(theName)) {
            helloWorldService.helloWorld(callback);
        } else {
            helloWorldService.helloWorld(name.getText(), callback);
        }
    }
}