# Eyeball Maze (C#.NET)
A simple maze game where the player navigates an eyeball through a maze. Built using C#.NET, this project demonstrates basic game logic, collision detection, and user input handling.

## Table of Contents
Overview
Features
Setup & Installation
Controls
Project Structure
Diagram
Contributing
License

## Overview
Eyeball Maze is a desktop-based game where players guide an eyeball through a maze to reach the goal. The game showcases:
- Maze generation and design
- Collision detection
- Smooth user input handling
- Basic game loop implementation


This project is ideal for beginners learning C#.NET game programming concepts.

## Features
- Navigate an eyeball through predefined mazes
- Simple collision detection with walls
- Keyboard input controls (arrow keys)
- Goal detection and game completion feedback


## Setup & Installation

1. Clone the repository:
```
git clone https://github.com/arsenie-sarmiento/draft-project-eyeball-maze.git
```

2. Open the solution in Visual Studio.
3. Build the project (Ctrl+Shift+B).
4. Run the game (F5 or Debug → Start Debugging).

## Controls
| Action     | Key |
| ---------- | --- |
| Move Up    | ↑   |
| Move Down  | ↓   |
| Move Left  | ←   |
| Move Right | →   |


## Project Structure
```
EyeballMaze/
│
├─ EyeballMaze.sln          # Visual Studio solution file
├─ EyeballMaze/
│  ├─ Program.cs            # Main entry point
│  ├─ Game.cs               # Game logic
│  ├─ Player.cs             # Eyeball/player logic
│  ├─ Maze.cs               # Maze generation and data
│  ├─ Resources/            # Images, sprites, sounds
│  └─ README.md
├─ Diagrams/
│  └─ MazeDiagram.pdf       # PDF diagram of the maze/game logic
└─ README.md
```
## Diagram
A visual representation of the maze and game logic is available in the PDF file:
[Diagrams/MazeDiagram.pdf](https://github.com/arsenie-sarmiento/draft-project-eyeball-maze/blob/main/eyeball-maze-diagram.pdf)

## License
This project is licensed under the MIT License.
