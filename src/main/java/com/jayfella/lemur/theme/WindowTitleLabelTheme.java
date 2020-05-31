package com.jayfella.lemur.theme;

import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.Insets3f;
import com.simsilica.lemur.VAlignment;

public class WindowTitleLabelTheme extends LabelTheme {

    protected ColorRGBA color = new ColorRGBA(0.8f, 0.8f, 0.8f, 1.0f);
    protected VAlignment textVAlignment = VAlignment.Center;
    protected Insets3f insets = new Insets3f(5,5,5,15);

    public WindowTitleLabelTheme() {
        super("window-title-label");

    }
}
