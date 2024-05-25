package X_O_IMAGE;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import java.io.File;
import java.io.IOException;

public class Image {
    private Texture texture = null;

    public Image(String path) {
        try {
            texture = TextureIO.newTexture(new File(path), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Texture getTexture() {
        return texture;
    }
}
