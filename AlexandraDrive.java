package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "AlexandraDrive")
public class AlexandraDrive extends LinearOpMode {
    public void runOpMode() throws InterruptedExeption {
        DcMotor front_left = hardwareMap.dcMotor.get("front_left_motor");
        DcMotor front_right = hardwareMap.dcMotor.get("front_right_motor");
        DcMotor back_left = hardwareMap.dcMotor.get("back_left_motor");
        DcMotor back_right = hardwareMap.dcMotor.get("back_right_motor");

        front_left.setDirection(DcMotorSimple.Direction.REVERSE);
        back_left.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()){
            double left_stick_y = -gamepad1.left_stick_y;
            double left_stick_x = -gamepad1.left_stick_x;

            front_left.setPower(left_stick_y + left_stick_x);
            front_right.setPower(left_stick_y - left_stick_x);
            back_left.setPower(left_stick_y - left_stick_x);
            back_right.setPower(left_stick_y + left_stick_x);

            telemetry.addData("left_stick_y",left_stick_y);
            telemetry.addData("left_stick_x",left_stick_x);
            telemetry.update();
        }
    }
}
