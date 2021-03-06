package org.openRealmOfStars.player.diplomacy;

import org.openRealmOfStars.player.PlayerList;

/**
*
* Open Realm of Stars game project
* Copyright (C) 2017  Tuomo Untinen
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, see http://www.gnu.org/licenses/
*
*
* Diplomacy for player and handling of it
*
*/
public class Diplomacy {

  /**
   * Diplomacy Bonus list for each player
   */
  private DiplomacyBonusList[] diplomacyList;

  /**
   * Constructor for Diplomacy for one player
   * @param players All players in list
   * @param playerIndex Which player is creating the list
   */
  public Diplomacy(final PlayerList players, final int playerIndex) {
    diplomacyList = new DiplomacyBonusList[players.getCurrentMaxPlayers()];
    for (int i = 0; i < players.getCurrentMaxPlayers(); i++) {
      if (i != playerIndex) {
        diplomacyList[i] = new DiplomacyBonusList(i,
            players.getPlayerInfoByIndex(i));
      }
    }
  }

  /**
   * Get diplomacy list for player index. This can return
   * null if player index is same as who's diplomacy object this is
   * being called or index is out of bounds.
   * @param index Player index.
   * @return Diplomacy list or null
   */
  public DiplomacyBonusList getDiplomacyList(final int index) {
    if (index > -1 && index < diplomacyList.length) {
      return diplomacyList[index];
    }
    return null;
  }
}
