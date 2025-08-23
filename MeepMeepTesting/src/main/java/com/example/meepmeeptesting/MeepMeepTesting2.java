package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting2 {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);



        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(56, -70, 0))
                .waitSeconds(2)
                .lineToX(20)
                .turn(Math.toRadians(90))
                .lineToY(-34)
                .turn(Math.toRadians(-90))
                .lineToX(50)
                .splineTo(new Vector2d(-70,-65), Math.toRadians(-100))
                .strafeTo(new Vector2d(0,-30))
                .strafeTo(new Vector2d(10,-25))
                .strafeTo(new Vector2d(50,-25))

                .build()
        );

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();

        // meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
    }
}