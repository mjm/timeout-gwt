package net.moriaritys.timeout.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 *
 */
public interface TimeoutBundle extends ClientBundle {
    @Source("Timeout.css")
    TimeoutCss css();

    public static interface TimeoutCss extends CssResource {

    }
}
