package com.jayfella.lemur.window;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.BaseAppState;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.simsilica.lemur.event.PopupState;
import org.jetbrains.annotations.NotNull;

public class SimpleWindowManager extends BaseAppState implements WindowManager {

    private final WindowList windowList;
    private Node guiNode;

    /**
     * Create a new Window Manager with a starting Z Order of ZERO.
     */
    public SimpleWindowManager() {
        this(0);
    }

    /**
     * Create a new Window Manager with a starting Z Order
     *
     * @param startZOrder the minimum z order of the windows.
     */
    public SimpleWindowManager(int startZOrder) {
        windowList = new WindowList(startZOrder);
    }

    @Override
    protected void initialize(Application app) {
        this.guiNode = ((SimpleApplication)app).getGuiNode();
    }

    @Override protected void cleanup(Application app) { }
    @Override protected void onEnable() { }
    @Override protected void onDisable() { }

    @Override
    public void update(float tpf) {
        windowList.executeWindowUpdateLoops(tpf);
    }

    WindowList getWindowList() {
        return windowList;
    }

    @Override
    @NotNull
    public Window add(@NotNull Window window) {

        window.setWindowManager(this);
        windowList.add(window);
        guiNode.attachChild(window.getWindowPanel());
        return window;
    }

    @Override
    public boolean remove(@NotNull Window window) {
        window.getWindowPanel().removeFromParent();
        return windowList.remove(window);
    }

    @Override
    public Window getByTitle(@NotNull String title) {
        return windowList.getByTitle(title);
    }

    @Override
    public Window getById(@NotNull String id) {
        return windowList.getById(id);
    }

    @Override
    public int getWindowCount() {
        return windowList.getWindowCount();
    }

    @Override
    public void bringToFront(@NotNull Window window) {
        windowList.bringToFront(window);
    }

    @Override
    public void sendToBack(@NotNull Window window) {
        windowList.sendToBack(window);
    }

    @Override
    public void showDialog(@NotNull String title, @NotNull String text) {
        showDialog(new JmeDialog(title, text));
    }

    @Override
    public void showDialog(@NotNull Dialog dialog) {

        dialog.setWindowManager(this);

        dialog.getDialogPanel().setLocalTranslation(
                getApplication().getCamera().getWidth() * 0.5f - dialog.getDialogPanel().getPreferredSize().x * 0.5f,
                getApplication().getCamera().getHeight() * 0.5f + dialog.getDialogPanel().getPreferredSize().y,
                1
        );

        PopupState popupState = getApplication().getStateManager().getState(PopupState.class);
        popupState.showModalPopup(dialog.getDialogPanel(), new ColorRGBA(0.2f, 0.2f, 0.2f, 0.8f));

    }

    @Override
    public void closeDialog(@NotNull Dialog dialog) {
        PopupState popupState = getApplication().getStateManager().getState(PopupState.class);
        popupState.closePopup(dialog.getDialogPanel());
    }

}
