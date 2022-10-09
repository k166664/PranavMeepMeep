package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;

public class MeepMeepTesting {
    public static void main(String[] args) {
        // Declare a MeepMeep instance
        // With a field size of 800 pixels
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(49, 49, Math.toRadians(180), Math.toRadians(180), 15)
                // Option: Set theme. Default = ColorSchemeRedDark()
                .setColorScheme(new ColorSchemeRedDark())
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(38, 62, 0))
                                        .strafeRight(62)
                                        .turn(Math.toRadians(18))
                                        // #1
                                        .forward(21)
                                        .forward(-24)
                                        // #2
                                        .forward(24)
                                        .forward(-24)
                                        // #3
                                        .forward(24)
                                        .forward(-24)
                                        // #4
                                        .forward(24)
                                        .forward(-24)
                                        // #5
                                        .forward(24)
                                        .forward(-24)
//                                .turn(Math.toRadians(90))
//                                .forward(33)
//                                .turn(Math.toRadians(90))
//                                .forward(62)
//                                .turn(Math.toRadians(90))
                                        /* Everything in the marker callback should be commented out */

                                        // bot.shooter.shoot()
                                        // bot.wobbleArm.lower()
                                        .build()
                );
        // Set field image
        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                // Background opacity from 0-1
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}