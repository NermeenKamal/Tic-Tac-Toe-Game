package Mouse;

import Tic_Tac_Toe.EventListener;
import Tic_Tac_Toe.Render;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class Mouse_Input implements MouseListener {
    private static final int GRID_SIZE = 3;

    @Override
    public void mouseClicked(MouseEvent e) {
        float mouseX = e.getX() / (float) Render.screenWidth * 2 - 1;
        float mouseY = 1 - e.getY() / (float) Render.screenHeight * 2;

        int gridX = (int) ((mouseX + 1.0f) / (2.0f / GRID_SIZE));
        int gridY = (int) ((1.0f - mouseY) / (2.0f / GRID_SIZE)); // Adjusted calculation for Y coordinate

        EventListener.updateGrid(gridX, gridY);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseWheelMoved(MouseEvent mouseEvent) {

    }

}
