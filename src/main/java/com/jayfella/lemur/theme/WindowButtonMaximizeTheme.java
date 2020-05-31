package com.jayfella.lemur.theme;

import com.jayfella.lemur.util.BackgroundUtils;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.Insets3f;
import com.simsilica.lemur.component.IconComponent;

public class WindowButtonMaximizeTheme extends ButtonTheme {

    protected IconComponent icon = new IconComponent("Style/Icon/button.png");
    protected Insets3f insets = new Insets3f(5,0,5,5);
    protected float fontSize = 0.0f;

    public WindowButtonMaximizeTheme() {
        super("window-button-maximize");

        BackgroundUtils.setBackgroundColor(background, new ColorRGBA(0, 0, 0, 0));
        icon.setColor(new ColorRGBA(0.0f, 0.7921f, 0.3411f, 1.0f));

    }

}
