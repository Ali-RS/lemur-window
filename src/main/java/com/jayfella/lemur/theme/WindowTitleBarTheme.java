package com.jayfella.lemur.theme;

import com.jayfella.lemur.util.BackgroundUtils;
import com.jme3.math.ColorRGBA;

public class WindowTitleBarTheme extends ContainerTheme {

    public WindowTitleBarTheme() {
        super("window-title-bar");

        BackgroundUtils.setMargin(background, 2, 2);
        BackgroundUtils.setBackgroundColor(background, new ColorRGBA(0.25f, 0.5f, 0.5f, 1.0f));

    }
}
