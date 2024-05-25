package Tic_Tac_Toe;

import Mouse.Mouse_Input;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Render {
    static GLWindow window = null;

    public static int screenWidth = 640;
    public static int screenHeight = 640; // Change the height to make it a square window

    public static final int unitWide = 10;

    private static GLProfile profile;

    public static void init() {
        profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);

        window = GLWindow.create(caps);
        window.setSize(screenWidth, screenHeight);
        window.setResizable(false);
        window.addGLEventListener(new EventListener());
        window.setVisible(true);

        window.addMouseListener(new Mouse_Input());

        FPSAnimator animator = new FPSAnimator(window, 60);
        animator.start();
    }

    public static GLProfile getProfile() {
        return profile;
    }

    public static void main(String[] args) {
        init();
    }
}
