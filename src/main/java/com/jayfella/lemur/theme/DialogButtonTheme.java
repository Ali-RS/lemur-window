package com.jayfella.lemur.theme;

import com.jayfella.lemur.util.BackgroundUtils;
import com.simsilica.lemur.Insets3f;

public class DialogButtonTheme extends ButtonTheme {

    protected Insets3f insets = new Insets3f(5, 10, 5, 10);

    public DialogButtonTheme() {
        super("dialog-button");

        BackgroundUtils.setMargin(background, 15, 5);
    }

}
