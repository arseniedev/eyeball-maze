# Eyeball Maze
![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-%2325A162.svg?style=for-the-badge&logo=junit5&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android%20Studio-%230052CC.svg?style=for-the-badge&logo=androidstudio&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)

> BCDE223 Best Programming Practices (Java)

> A simple maze game where the player navigates an eyeball through a maze. Built using Java, as part of the **BCDE223 Best Programming Practices (Java)** course, this project demonstrates basic game logic, collision detection, and user input handling.

---

[![Live Demo](https://img.shields.io/badge/Download_APK-Live%20Demo%20-181717?style=for-the-badge&logo=android&labelColor=gray)]()

[![Video Demo](https://img.shields.io/badge/YouTube-View%20Recorded%20Demo-1a1a2e?style=for-the-badge&logo=youtube&labelColor=16213e)]()

---

## Features

- Navigate an eyeball through predefined mazes
- Simple collision detection with walls
- Keyboard input controls (arrow keys)
- Goal detection and game completion feedback

> [![📖 See Wiki ](https://img.shields.io/badge/See_Wiki_⊿_-1a1a2e?style=for-the-badge&labelColor=16213e)](https://github.com/arseniedev/eyeball-maze/wiki)</br>
> for the iteration snapshots, full admin usage instructions, and data model details.

<table>
    <tr>
        <td><image src="https://github.com/arseniedev/eyeball-maze/tree/docs/assets/clips/clip-001.gif" width="200" alt="clip-001.gif"></image></td>
        <td>
            <ul>
                <li>Display starting level + level name</li>
                <li>Diplay level goal(s)</li>
                <li>Diplay image of player character + correct direction</li>
            </ul>
        </td>
    </tr>
    <tr>
        <td><image src="https://github.com/arseniedev/eyeball-maze/tree/docs/assets/clips/clip-002.gif" width="200" alt="clip-002.gif"></td>
        <td>
            <ul>
                <li>Event handler (button clicks/ tough gestures) to control player movement</li>
                <li>Display an updated move count for player character</li>
                <li></li>
            </ul>
        </td>
    </tr>
    <tr>
        <td><image src="https://github.com/arseniedev/eyeball-maze/tree/docs/assets/clips/clip-003.gif" width="200" alt="clip-003.gif"></td>
        <td>
            <ul>
                <li>A button or menu to restart the current maze*</li>
            </ul>
        </td>
    </tr>
    <tr>
        <td><image src="https://github.com/arseniedev/eyeball-maze/tree/docs/assets/clips/clip-004.gif" width="200" alt="clip-004.gif"></td>
        <td>
            <ul>
                <li>Diplay rules/prompt if move does not obey move logic rules</li>
                <li>Play a short relevant and suitable audio / video if player character intends to move incorrectly*</li>
            </ul>
        </td>
    </tr>
</table>

## Setup & Installation

1. Clone the repository:

```bash
git clone https://github.com/arsenie-sarmiento/draft-project-eyeball-maze.git
```

2. Open the solution in Visual Studio.
3. Build the project (`Ctrl` + `Shift` + `B`).
4. Run the game (F5 or Debug → Start Debugging).

> [![📖 Wiki — Full Local Setup Guide](https://img.shields.io/badge/📖_Wiki-Full%20Local%20Setup%20Guide_⊿_-1a1a2e?style=for-the-badge&labelColor=16213e)](https://github.com/arseniedev/music-catalogue/wiki/Local-Installation-Guide) <br/>

## Project Structure

<!-- START_STRUCTURE -->

```text
EyeballMaze/
  ├── Game.java          # Main game loop and entry point
  ├── Maze.java          # Maze structure and layout logic
  ├── Player.java        # Eyeball entity (movement & state)
  ├── InputHandler.java  # Keyboard input processing
  └── Utils/             # Helper classes (if any)

/docs
  └── EyeballMazeDiagram.pdf   # System/design diagram

```
<!-- END_STRUCTURE -->

## Diagram

A visual representation of the maze and game logic is available in the PDF file:

- [Iteration 1](https://github.com/arsenie-sarmiento/draft-project-eyeball-maze/blob/docs/diagrams/eyeball-maze-class-diagram-iteration-1.pdf)

---

</br>

> ![IMPORTANT_NOTICE-_Academic_Integrity](https://img.shields.io/badge/IMPORTANT_NOTICE-_Academic_Integrity-%23800000.svg?style=for-the-badge&logoColor=white)
>
> **BCDE223 Best Programming Practices (Java)**
>
> This portfolio contains original work completed as part of my **BCDE223 Best Programming Practices (Java)** course at Ara Institute of Canterbury. I do **not condone plagiarism or academic misconduct** in any form. This project is for academic purposes only and is not intended to be copied or used without proper authorisation.
> The university has a <span style="color:red;">**STRICT**</span> policy on academic misconduct, and I fully support this policy. Any attempt to plagiarize, copy, or use this work as your own will result in serious consequences. Please respect academic integrity and do not attempt to pass off this work as your own.
>
> **Disclaimer**
> 
> All the content presented here is the result of my own individual work, and any resemblance to other works is purely coincidental. If you are a student, please refrain from using or copying this work in any way that violates the principles of academic honesty and integrity.
