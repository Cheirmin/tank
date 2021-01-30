package com.cheirmin.tank.pojo;

import com.cheirmin.tank.Dir;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: Cheirmin
 * @since: 2021-01-30
 * @history: 1.2021-01-30 created by Cheirmin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tank {
    //坐标
    private int x,y;
    private int wide,high;
    private Dir dir;
    private int SPEED;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
        dir = Dir.NO;
        SPEED = 10;
        wide=50;
        high=50;
    }
}
