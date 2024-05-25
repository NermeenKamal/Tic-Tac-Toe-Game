![image](https://github.com/NermeenKamal/Tic-Tac-Toe-Game/assets/114883845/cd6f7ad3-c4e6-4701-be37-b35f5db64e02)

---

# Tic-Tac-Toe Game

## Introduction

Tic-Tac-Toe is a classic two-player game where players take turns marking spaces in a 3x3 grid with their respective symbols, 'X' and 'O'. The objective is to form a line of three of one's own symbols either horizontally, vertically, or diagonally.

This project is an implementation of the Tic-Tac-Toe game using Java and the OpenGL (Open Graphics Library) for rendering graphics. The game features a graphical user interface, mouse input for player moves, and animations for the winning symbol.

## Features

- **Two-Player Gameplay**: Supports two players taking turns to place 'X' and 'O' symbols.
- **Winning Condition Detection**: Detects and announces when a player wins by forming a line of three symbols.
- **Draw Condition Detection**: Detects when the game ends in a draw.
- **Animated Winning Symbol**: Rotates the winning symbol to indicate the winning line.
- **Mouse Input**: Players interact with the game using mouse clicks.
- **Graphical Rendering**: Utilizes OpenGL for efficient and smooth graphics rendering.

## Installation and Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- JOGL (Java Binding for the OpenGL API) library

### Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/tic-tac-toe.git
   cd tic-tac-toe
   ```

2. **Set Up JOGL Library**
   - Download JOGL from the official website: https://jogamp.org/jogl/www/
   - Add JOGL jars to your project's build path.

3. **Compile and Run**
   - Open the project in your favorite IDE (Eclipse, IntelliJ, etc.).
   - Ensure the JOGL library is correctly referenced in your project.
   - Run the `Render` class.

## Project Structure

- `Tic_Tac_Toe/Render.java`: Initializes the OpenGL window and starts the game.
- `Tic_Tac_Toe/EventListener.java`: Handles the game logic, including player moves and win detection.
- `Tic_Tac_Toe/Graphics.java`: Provides methods for rendering images and handling graphics transformations.
- `Mouse/Mouse_Input.java`: Captures and processes mouse input from the player.
- `X_O_IMAGE/Image.java`: Represents an image resource loaded as an OpenGL texture.

## Usage

- Run the `Render` class to start the game.
- Click on the grid to place your symbol ('X' or 'O').
- The game will detect and announce the winner or a draw.
- When a player wins, the winning symbol will rotate to highlight the winning line.

## Contributing

Contributions are welcome! If you have any suggestions or improvements, feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

---
