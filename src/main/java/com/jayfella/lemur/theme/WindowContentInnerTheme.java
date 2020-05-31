package com.jayfella.lemur.theme;

import com.jayfella.lemur.util.BackgroundUtils;
import com.jme3.math.ColorRGBA;

public class WindowContentInnerTheme extends ContainerTheme {

    public WindowContentInnerTheme() {
        super("window-content-outer");

        BackgroundUtils.setBackgroundColor(background, new ColorRGBA(0.25f, 0.5f, 0.5f, 0.25f));
        BackgroundUtils.setMargin(background, 5, 5);
    }

}
