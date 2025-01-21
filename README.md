[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.


## Adventurer Subclasses

| Adventurer | Adventurer Health | Normal Attack         | Special Resource | Support                                         | Special Attack                                                                               |
|:------------:|:-------------------:|:-----------------------:|:------------------:|:------------------------------------------------:|:---------------------------------------------------------------------------------------------:|
| Mage       | 20 - 22           | "Thunderbolt" <br/> Deals 3-7 dmg to one enemy. There is a 50% chance of a lightning strike, dealing 3 extra damage. Mage gains 2 Aura.   | Aura             | "Elemental Surge" <br/>  Increase damage of allies for 2 turns (1.5x multiplier). Mage gains 2 Aura.        | "Inferno Blast"  <br/>  Deals 5-6 dmg to all enemies, lighting them on fire, dealing one damage per turn, for 3 turns. 10 Aura required. |
| Healer     | 24 - 26           | "Divine&nbsp;Strike" <br/> Deals 1-3 dmg to one enemy. Heals all allies by the damage done. Healer gains 3 elixir. | Elixir          | "Angel’s Touch" <br/> Heal a single teammate or themselves 7 HP and restores 3 special. Healer gains 1 elixir.                                  | "Dark Blessing" <br/> Healer sacrifices 25% of their HP to heal teammates by 50% of their max HP. Deals 2-4 damage to a single enemy. 10 Elixir required.        |
| Sentinel   | 28 - 30           | "Rock Slam" <br/> Deals 3-4 dmg to a single enemy. Senintel gains 3 fortitude. | Fortitude        | "Guardian’s Shield" <br/> Gives a shield to a teammate that absorbs 75% of damage done to them for 2 turns. Sentintel gains 2 fortitude.       | "Iron Earthquake" <br/> Stun an enemy for up to three turns (Random number between 0 - 100. Greater than 75 is 3, greater than 25 is 2, 0 to 25 is 1 ). 10 fortitude required.               |

## Boss Subclass
| Name | Health | Normal Attack         | Special Resource | Support                                         | Special Attack                                                                               |
|:------------:|:-------------------:|:-----------------------:|:------------------:|:------------------------------------------------:|:---------------------------------------------------------------------------------------------:|
| Chimera   |    100        |   "Rampage" <br/>  Deals 6-10 dmg to one enemy, poisoning them, which reduces enemy attack damage by 75% and deals 1 damage per turn. Chimera gains 1 Rage.|   Rage   |  "Limitless adaptation" <br/> Chimera heals itself for 25% of its current HP and nullifies all of its bad status effects. Gains 1 rage. |    "Chimera's wrath" <br/> Chimera does an AOE stomp, dealing 8 dmg to all enemies, while breathing fire, lighting all of its enemies on fire for 5 turns. 15 rage required.  |
