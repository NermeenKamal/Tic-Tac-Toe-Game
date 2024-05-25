package Tic_Tac_Toe;

import X_O_IMAGE.Image;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public class Graphics {
    private static float red = 1;
    private static float green = 1;
    private static float blue = 1;
    private static float alpha = 1;

    public static float rotation = 0;

    public static void setColor(float r, float g, float b, float a) {
        red = Math.max(0, Math.min(1, r));
        green = Math.max(0, Math.min(1, g));
        blue = Math.max(0, Math.min(1, b));
        alpha = Math.max(0, Math.min(1, a));
    }

    public static void setRotation(float r) {
        rotation = r;
    }

    public static void drawImage(GL2 gl, Image img, float x, float y, float width, float height) {
        Texture tex = img.getTexture();
        if (tex != null) {
            tex.enable(gl);
            tex.bind(gl);
        } else {
            System.err.println("Texture is null, cannot draw image.");
        }

        gl.glPushMatrix();
        gl.glTranslatef(x, y, 0);
        gl.glRotatef(-rotation, 0, 0, 1);

        gl.glColor4f(red, green, blue, alpha);
        gl.glBegin(GL2.GL_QUADS);

        gl.glTexCoord2f(0, 1);
        gl.glVertex2f(-width / 2, -height / 2);

        gl.glTexCoord2f(1, 1);
        gl.glVertex2f(width / 2, -height / 2);

        gl.glTexCoord2f(1, 0);
        gl.glVertex2f(width / 2, height / 2);

        gl.glTexCoord2f(0, 0);
        gl.glVertex2f(-width / 2, height / 2);

        gl.glEnd();
        gl.glPopMatrix();

        if (tex != null) {
            tex.disable(gl);
        }
    }
}
