package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
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
                .setConstraints(49, 49, Math.toRadians(180), Math.toRadians(180), 12)
                // Option: Set theme. Default = ColorSchemeRedDark()
                .setColorScheme(new ColorSchemeRedDark())
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(35, 62, 0))
                                        .strafeRight(62)
                                        .waitSeconds(0.2)
                                        // bot.grabber.drop()
                                        .strafeLeft(7)
                                        .splineToConstantHeading(new Vector2d(56, 12), Math.toRadians(0))
                                        // #1
                                        // bot.grabber.pickUp()
                                        .waitSeconds(0.2)
                                        .back(32)
                                        .waitSeconds(0.2)
                                        // bot.grabber.drop()
                                        .forward(32)
                                        // #2
                                        // bot.grabber.pickUp()
                                        .waitSeconds(0.2)
                                        .back(32)
                                        // bot.grabber.drop()
                                        .waitSeconds(0.2)
                                        .forward(32)
                                        // #3
                                        // bot.grabber.pickUp()
                                        .waitSeconds(0.2)
                                        .back(32)
                                        // bot.grabber.drop()
                                        .waitSeconds(0.2)
                                        .forward(32)
                                        // #4
                                        // bot.grabber.pickUp()
                                        .waitSeconds(0.2)
                                        .back(32)
                                        // bot.grabber.drop()
                                        .waitSeconds(0.2)
                                        .forward(32)
                                        // #5
                                        // bot.grabber.pickUp()
                                        .waitSeconds(0.2)
                                        .back(32)
                                        // bot.grabber.drop()
                                        .waitSeconds(0.2)
                                        .forward(36)
                                        // park at terminal
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