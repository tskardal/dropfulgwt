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
		RootPanel.get().add(new HelloWorld());
	}

}
