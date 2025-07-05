# 🧩 Eyeball Maze

Eyeball Maze is a logic-based Android puzzle game built on a visual grid system. Your goal is to reach special GOAL squares by navigating shape and color-based movement rules. As you solve each level, you'll face increasing difficulty, disappearing tiles, and directional constraints.

---

## 📱 Quick Summary

| Action               | Description                                                            |
|----------------------|------------------------------------------------------------------------|
| 🔄 **Restart**        | Restarts the current maze layout                                       |
| ▶️ **Start**          | Begins the selected level (1–13 available)                             |
| ⏪ **Undo Move**      | Goes back one move (can be clicked multiple times)                     |
| 🔊 **Sound**          | Toggles game audio                                                     |

---

## 🕹 How to Play

- You are the circle with two **eyeballs** — their direction shows where you're facing.
- Tap a valid square to **move**.
- You may move any number of steps **horizontally or vertically**, but **not diagonally**.
- You **cannot cross blank squares**.
- You may **only end your move** on a square that has the **same shape or color** as the square you started from.
- You may only move **forward, left, or right** relative to your current facing direction — **never backward**.
- If you land on a GOAL square, it will **disappear** and become a blank space.
- If a level has multiple goals, you must reach **all of them** — and the blanks left behind will increase the challenge.
- Mazes 1–2 include **solutions**. Mazes 12–13 feature special **purple lightning** tiles, which cannot be landed on but can be passed over.

---

## 📦 Features

- 🧠 Shape & color logic via enums (`Shape`, `Color`)
- 🧰 Grid-driven puzzle layout (8x7)
- 📂 Level structure stored in JSON
- 🎯 Disappearing goal tiles
- 🧱 Obstacle rules based on color and shape
- 🎨 Visual mapping to Android `drawable` resources
- 🔊 Optional sound support

---

## 🎮 Example Gameplay Rules

| Condition                                      | Example                                  |
|-----------------------------------------------|------------------------------------------|
| End on same shape or same color               | STAR🟥 → STAR🟨 or CROSS🟥                 |
| No backward movement                          | If facing up, cannot move down           |
| Can pass over, but not stop on, purple bolts  | Purple lightning squares in Maze 12–13   |
| Goals become blanks after stepping on them    | Forces route planning                    |
| Undo lets you retry steps                     | Tap multiple times to rewind             |

---

## 📚 Maze Fun Facts

- Most mazes are **hand-designed**, except Maze 5 & 6 (generated using PuzzleBeast).
- Maze 11 contains a **pattern** you might recognize.
- Maze 1 and 2 reflect each other: false paths and true paths are reversed.

---

## 📂 Project Structure

