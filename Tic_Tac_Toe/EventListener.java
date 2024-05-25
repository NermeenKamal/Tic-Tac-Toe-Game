package Tic_Tac_Toe;

import X_O_IMAGE.Image;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.texture.Texture;

public class EventListener implements GLEventListener {
    private static final int GRID_SIZE = 3;
    private static final int EMPTY = 0;
    private static final int IMAGE1 = 1;
    private static final int IMAGE2 = 2;

    private static int[][] grid = new int[GRID_SIZE][GRID_SIZE];
    private static int currentImage = IMAGE1; // Start with IMAGE1

    private static Image image1 = null;
    private static Image image2 = null;

    private static boolean gameFinished = false;

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glEnable(GL2.GL_TEXTURE_2D);

        // Load images
        image1 = new Image("C:\\Users\\Nermeen Kamal\\IdeaProjects\\Project\\src\\main\\java\\res\\O.png");
        image2 = new Image("C:\\Users\\Nermeen Kamal\\IdeaProjects\\Project\\src\\main\\java\\res\\X.jpg");

        // Initialize grid
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = EMPTY;
            }
        }
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public static void updateGrid(int x, int y) {
        if (!gameFinished && x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE && grid[x][y] == EMPTY) {
            // Toggle between IMAGE1 and IMAGE2
            grid[x][y] = currentImage;
            currentImage = (currentImage == IMAGE1) ? IMAGE2 : IMAGE1; // Toggle for next click

            // Check for winning condition
            if (checkWin(x, y, grid[x][y])) {
                // Player has won, stop further calls to updateGrid
                System.out.println("Player " + grid[x][y] + " wins!");
                currentImage = EMPTY; // Reset currentImage to stop further moves
                // Animation code to rotate the winning image can be added here
                gameFinished = true;
            } else if (checkDraw()) {
                // Game is a draw
                System.out.println("Draw!");
                gameFinished = true;
            }
        }
    }

    private static boolean checkWin(int x, int y, int player) {
        // Check row
        boolean win = true;
        for (int i = 0; i < GRID_SIZE; i++) {
            if (grid[x][i] != player) {
                win = false;
                break;
            }
        }
        if (win) {
            return true;
        }

        // Check column
        win = true;
        for (int i = 0; i < GRID_SIZE; i++) {
            if (grid[i][y] != player) {
                win = false;
                break;
            }
        }
        if (win) {
            return true;
        }

        // Check main diagonal
        if (x == y) {
            win = true;
            for (int i = 0; i < GRID_SIZE; i++) {
                if (grid[i][i] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }

        // Check anti-diagonal
        if (x + y == GRID_SIZE - 1) {
            win = true;
            for (int i = 0; i < GRID_SIZE; i++) {
                if (grid[i][GRID_SIZE - 1 - i] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkDraw() {
        // Check if the grid is full (no more empty cells)
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == EMPTY) {
                    // Found an empty cell, game is not a draw yet
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glClearColor(0, 0, 0, 0);

        // Drawing the grid for Tic-Tac-Toe
        gl.glColor3f(1, 1, 1);
        gl.glBegin(GL2.GL_LINES);

        // Vertical lines
        for (int i = 1; i < GRID_SIZE; i++) {
            float x = -1.0f + 2.0f / GRID_SIZE * i;
            gl.glVertex2f(x, 1.0f);
            gl.glVertex2f(x, -1.0f);
        }

        // Horizontal lines
        for (int i = 1; i < GRID_SIZE; i++) {
            float y = 1.0f - 2.0f / GRID_SIZE * i;
            gl.glVertex2f(-1.0f, y);
            gl.glVertex2f(1.0f, y);
        }

        gl.glEnd();

        // Draw images based on grid state
        float squareSize = 2.0f / GRID_SIZE;
        float imageSize = squareSize * 0.8f; // Image size slightly smaller than the square size

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                float x = -1.0f + squareSize * (i + 0.5f);
                float y = 1.0f - squareSize * (j + 0.5f);
                if (grid[i][j] == IMAGE1) {
                    Graphics.drawImage(gl, image1, x, y, imageSize, imageSize);
                } else if (grid[i][j] == IMAGE2) {
                    Graphics.drawImage(gl, image2, x, y, imageSize, imageSize);
                }
            }
        }
    }
}
