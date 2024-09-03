package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="AlexandraTest")
public class AlexandraTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("name", "Alexandra");
        telemetry.update();


        DcMotor bk_lt = hardwareMap.dcMotor.get("back_left_motor");
        DcMotor ft_lt = hardwareMap.dcMotor.get("front_left_motor");
        DcMotor ft_rt = hardwareMap.dcMotor.get("front_right_motor");
        DcMotor bk_rt = hardwareMap.dcMotor.get("back_right_motor");


        bk_lt.setDirection(DcMotor.Direction.REVERSE);
        ft_lt.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();


        while (opModeIsActive()) {


            boolean dpadDown = gamepad2.dpad_down;
            boolean dpadUp = gamepad2.dpad_up;


            if (dpadUp == true){
                bk_lt.setTargetPosition(1000);
                bk_rt.setTargetPosition(1000);
                ft_rt.setTargetPosition(1000);
                ft_lt.setTargetPosition(1000);
                bk_lt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                bk_rt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                ft_rt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                ft_lt.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                bk_lt.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                bk_rt.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                ft_rt.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                ft_lt.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }

            if (dpadDown == true){
                bk_lt.setTargetPosition(-1000);
                bk_rt.setTargetPosition(-1000);
                bk_lt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                bk_rt.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                bk_lt.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                bk_rt.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
        }
    }
}
