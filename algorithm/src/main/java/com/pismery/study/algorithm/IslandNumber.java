package com.pismery.study.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * <p>
 * exmaple:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
@Slf4j
public class IslandNumber {

    public static int getIslandNumber(char[][] grid) {
        int islandNum = 0;
        int columnNum = grid.length;
        int rowNum = grid[0].length;

        for (int i = 0; i < columnNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                if ('1' == grid[i][j]) {
                    islandNum++;
                    setAroundToWater(grid, i, j);
                }
            }
        }
        return islandNum;
    }

    private static void setAroundToWater(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || '1' != grid[i][j]) {
            return;
        }

        grid[i][j] = '0';
        setAroundToWater(grid, i + 1, j);
        setAroundToWater(grid, i - 1, j);
        setAroundToWater(grid, i, j + 1);
        setAroundToWater(grid, i, j - 1);
    }

}
