package com.neotys.gremlin.common;

import javax.swing.*;
import java.net.URL;

public  class GreminUtils {
    private static final ImageIcon GREMLIN_ICON;

    static {

        final URL iconURL = GreminUtils.class.getResource("Logo-gremlin.png");
        if (iconURL != null) {
            GREMLIN_ICON = new ImageIcon(iconURL);
        } else {
            GREMLIN_ICON = null;
        }
    }

    public GreminUtils() {
    }

    public static ImageIcon getGremlinIcon() {
        return GREMLIN_ICON;
    }

}
