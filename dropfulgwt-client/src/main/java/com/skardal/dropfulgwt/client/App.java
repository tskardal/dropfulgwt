package com.skardal.dropfulgwt.client;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.skardal.dropfulgwt.client.services.HelloWorldService;
import com.skardal.dropfulgwt.core.Saying;

public class App implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Defaults.setServiceRoot("/api");
		HelloWorldService helloWorldService = GWT.create(HelloWorldService.class);
		helloWorldService.helloWorld(new MethodCallback<Saying>() {
			
			@Override
			public void onSuccess(Method method, Saying response) {
				RootPanel.get().add(new Label(String.valueOf(response.getId() + " - " + response.getContent())));				
			}
			
			@Override
			public void onFailure(Method method, Throwable exception) {
				RootPanel.get().add(new Label("Something went wrong :-/"));
			}
		});		
	}

}
