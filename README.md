# 🏰 ThreeTeamKingdomWar

A custom PvP event plugin for **Paper 1.21.5** Minecraft servers, managing a kingdom war between **three teams**: **Red**, **Blue**, and **Green**.

---

## 📦 Overview

Each team has:
- A maximum of **30 players**
- A special **enchanted beacon** controlling their respawn point
- Custom **phase-based gameplay flow**
- Scoreboard tracking live player status per team

The last team with surviving players wins.

---

## ⚙️ Setup Instructions

### 📥 Install the Plugin

1. Download or build the `ThreeTeamKingdomWar-x.x.jar`.
2. Place it into your server’s `/plugins/` directory.
3. Start the server once to generate configs (if applicable).

---

## 📜 Commands

> 📌 All commands require the `tkw.admin` permission.

### 👥 Team Commands

| Command                            | Description                                 |
|:----------------------------------|:--------------------------------------------|
| `/team create <red|blue|green>`   | Creates a team (automatically when joining). |
| `/team join <red|blue|green>`     | Join a team.                                |

---

### 🏰 Beacon Commands

| Command                                 | Description                                              |
|:---------------------------------------|:---------------------------------------------------------|
| `/teambeacon create <red|blue|green>`  | Gives you an enchanted beacon for the selected team.      |

**When placed:**  
Registers the beacon's location as the team’s respawn point.

---

### 🕹️ Phase Commands

| Command                                         | Description                                      |
|:------------------------------------------------|:-------------------------------------------------|
| `/phase create <name>`                          | Creates a new named phase.                       |
| `/phase delete <name>`                          | Deletes an existing phase.                       |
| `/phase set <name> <time_in_seconds>`           | Starts a phase immediately with a countdown.     |

---

### 🚀 Game Start Command

| Command  | Description                                              |
|:----------|:---------------------------------------------------------|
| `/start`  | Teleports all players to their team’s beacon and starts the game. |

---

## ⚔️ Gameplay Flow

1. **Players join a team** using `/team join <team>`.
2. **Admin places each team's beacon** using `/teambeacon create <team>` and physically placing it.
3. **Admin starts the game** via `/start`.
4. The game runs through **phases**:
   - Preparation Phase (PvP disabled)
   - Battle Phase (PvP enabled, beacons vulnerable)
5. Destroyed team beacons stop respawns for that team.
6. The last team standing wins.

---
